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
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.academia.bean.BTelefono;
import org.academia.bean.BTutor;
import org.academia.dao.DAOTelefono;
import org.academia.dao.DAOTutor;
import org.json.JSONObject;

/**
 *
 * @author ABEL-LP
 */
@WebServlet(name = "SRegistrarTutor", urlPatterns = {"/SRegistrarTutor"})
public class SRegistrarTutor extends HttpServlet {

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
    public SRegistrarTutor() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SRegistrarTutor</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SRegistrarTutor at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
        
        String json1 = new Gson().toJson(new DAOTutor().listarTutor());
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

            BTutor oTutor = new BTutor();
            String value = (String) jsonObj.get("nombre");
            oTutor.setNombre(value);

            value = (String) jsonObj.get("apellidoPaterno");
            oTutor.setApellidoPaterno(value);

            value = (String) jsonObj.get("apellidoMaterno");
            oTutor.setApellidoMaterno(value);

            value = (String) jsonObj.get("dni");
            oTutor.setDni(value);

            value = (String) jsonObj.get("direccion");
            oTutor.setDireccion(value);

            //Valores por defecto
            oTutor.setEstado(true);
            oTutor.setIdTutor(1);//no interesa el numero de id
            
            int idTutor = new DAOTutor().registrarTutor(oTutor);
            
            BTelefono oBTelefono = new BTelefono();
            
            value = (String) jsonObj.get("telefono");
            oBTelefono.setNumero(value);
            //valores predetemindas
            oBTelefono.setIdTelefono(1);
            oBTelefono.setIdTitular(idTutor);
            oBTelefono.setTipoTelefono("Claro");
            oBTelefono.setEstado(true);
            
            boolean flag=new DAOTelefono().insertarTelefono(oBTelefono);
            
            if ((idTutor!=0)&& flag==true) {
                String json1 = new Gson().toJson("Tutor Registrado!");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            } else {
                String json1 = new Gson().toJson("Error al registrar Tutor");
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
