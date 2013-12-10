/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.servlet;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.academia.bean.BAlumno;
import org.academia.bean.BMatricula;
import org.academia.bean.BSalon;
import org.academia.bean.BSalon_Tutor;
import org.academia.dao.DAOAlumno;
import org.academia.dao.DAOCicloAcademico;
import org.academia.dao.DAOMatricula;
import org.academia.dao.DAOSalon;
import org.academia.dao.DAOSalon_Tutor;
import org.academia.dao.DAOTipoCobro;
import org.academia.dao.DAOTutor;
import org.json.JSONObject;

/**
 *
 * @author ABEL-LP
 */
@WebServlet(name = "SMatricula", urlPatterns = {"/SMatricula"})
public class SMatricula extends HttpServlet {

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
    public SMatricula() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            /* out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Servlet SMatricula</title>");            
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Servlet SMatricula at " + request.getContextPath() + "</h1>");
             out.println("</body>");
             out.println("</html*/
        } finally {
            out.close();
        }
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
        String json1 = new Gson().toJson(new DAOTipoCobro().listarTipoCobro());
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json1);

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
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
            //System.out.println(jb.toString());
            String datt = String.valueOf(jb.toString());

            JSONObject jsonObj = new JSONObject(datt);

            BAlumno oBAlumno = new BAlumno();
            String value = (String) jsonObj.get("nombre");
            oBAlumno.setNombre(value);

            value = (String) jsonObj.get("apellidoPaterno");
            oBAlumno.setApellidoPaterno(value);
            
            value = (String) jsonObj.get("apellidoMaterno");
            oBAlumno.setApellidoMaterno(value);
            
            value = (String) jsonObj.get("dni");
            oBAlumno.setDni(value);
            
            value = (String) jsonObj.get("direccion");
            oBAlumno.setDireccion(value);
            
            oBAlumno.setEstado(true);
            oBAlumno.setIdSalon(5);
            oBAlumno.setIdExamen(5);
            
            int idAlumno = new DAOAlumno().registrarAlumno(oBAlumno);
            
            BMatricula oBMatricula = new BMatricula();
            
            value = (String) jsonObj.get("escuela");
            oBMatricula.setEscuela(value);
            value = (String) jsonObj.get("idciclo");
            oBMatricula.setIdCiclo(Integer.parseInt(value));
            
            oBMatricula.setIdAlumno(idAlumno);
            oBMatricula.setIdSecretario(1);
            oBMatricula.setMonto(360.0);
            
            boolean flag=new DAOMatricula().registrarAlumno(oBMatricula);

            


            if (idAlumno!=0&&flag == true) {
                String json1 = new Gson().toJson("Alumno matriculado!");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            } else {
                String json1 = new Gson().toJson("Error al matricular Alumno");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            }

        } catch (Exception e) {
            e.printStackTrace();
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

}
