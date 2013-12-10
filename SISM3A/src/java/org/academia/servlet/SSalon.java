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
import org.academia.bean.BSalon;
import org.academia.bean.BSalon_Tutor;
import org.academia.bean.BTelefono;
import org.academia.bean.BTutor;
import org.academia.dao.DAOSalon;
import org.academia.dao.DAOSalon_Tutor;
import org.academia.dao.DAOTelefono;
import org.academia.dao.DAOTutor;
import org.json.JSONObject;

/**
 *
 * @author ABEL-LP
 */
@WebServlet(name = "SSalon", urlPatterns = {"/SSalon"})
public class SSalon extends HttpServlet {

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
    public SSalon() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SSalon</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SSalon at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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

            BSalon oBSalon=new BSalon();
            String value = (String) jsonObj.get("nombre");
            oBSalon.setDenominacion(value);

            value = (String) jsonObj.get("capacidad");
            oBSalon.setCapacidad(Integer.parseInt(value));
            oBSalon.setCantidadActual(0);
            oBSalon.setEstado(true);
            oBSalon.setIdSalon(12);
            
            int idSalon=new DAOSalon().crearSalon(oBSalon);
            
            BSalon_Tutor oBSalon_Tutor = new BSalon_Tutor();
            
            value = (String) jsonObj.get("idTutor");
            oBSalon_Tutor.setIdTutor(Integer.parseInt(value));
            oBSalon_Tutor.setIdSalon(idSalon);  
            
            boolean flag=new DAOSalon_Tutor().registrarSalonTutor(oBSalon_Tutor);
           
            if (flag==true) {
                String json1 = new Gson().toJson("Salon Registrado!");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            } else {
                String json1 = new Gson().toJson("Error al registrar Salon");
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
