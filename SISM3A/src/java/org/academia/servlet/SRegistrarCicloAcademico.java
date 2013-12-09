/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.servlet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.academia.bean.BCicloAcademico;
import org.academia.bean.BTipoCobro;
import org.academia.dao.DAOCicloAcademico;
import org.academia.dao.DAOTipoCobro;
import org.json.JSONObject;

/**
 *
 * @author davis
 */
@WebServlet(name = "SRegistrarCicloAcademico", urlPatterns = {"/SRegistrarCicloAcademico"})
public class SRegistrarCicloAcademico extends HttpServlet {

    BCicloAcademico oBCicloAcademico = new BCicloAcademico();

    private static final long serialVersionUID = 1L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public SRegistrarCicloAcademico() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String json1 = new Gson().toJson(new DAOCicloAcademico().mostrarCicloAcademico(oBCicloAcademico.getIdCiclo()));
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().write(json1);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            String datt = String.valueOf(jb.toString());

            JSONObject jsonObj = new JSONObject(datt);

//            BCicloAcademico oBCicloAcademico = new BCicloAcademico();
            String value;
            value = (String) jsonObj.get("tipoCicloAcademico");
            oBCicloAcademico.setTipoCiclo(value);

            value = (String) jsonObj.get("fechaInicio");
            Date fechaIni = convertStringToDate(value);
            java.sql.Date sqlDateIni = new java.sql.Date(fechaIni.getTime());
            oBCicloAcademico.setFechaInicio(sqlDateIni);

            value = (String) jsonObj.get("fechaFin");
            Date fechaFin = convertStringToDate(value);
            java.sql.Date sqlDateFin = new java.sql.Date(fechaFin.getTime());
            oBCicloAcademico.setFechaFin(sqlDateFin);

            value = (String) jsonObj.get("costo");
            oBCicloAcademico.setCosto(Double.parseDouble(value));

            int idCiclo = new DAOCicloAcademico().registrarCicloAcademico(oBCicloAcademico);

            if (idCiclo != 0) {
//                String json1 = new Gson().toJson("Ciclo Academico Registrado!");
                 String json1 = new Gson().toJson(oBCicloAcademico.getIdCiclo());
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            } else {
                String json1 = new Gson().toJson("Error al registrar Ciclo academico");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            }

            BTipoCobro oBTipoCobro = new BTipoCobro();
            oBTipoCobro.setIdCiclo(idCiclo);
        } catch (Exception e) {
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Date convertStringToDate(String fecha) {
        Date dato = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            dato = formato.parse(fecha);

        } catch (ParseException e) {
            System.out.println(" error en fechas " + e);
        }
        return dato;
    }
}
