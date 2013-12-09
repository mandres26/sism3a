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
@WebServlet(name = "SListarTutor", urlPatterns = {"/SListarTutor"})
public class SListarTutor extends HttpServlet {

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
    public SListarTutor() {
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
//            out.println("<title>Servlet SListarTutor</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SListarTutor at " + request.getContextPath() + "</h1>");
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
//        String g = request.getParameter("ids");
//
//        BTutor oBTutor = new BTutor();
//        oBTutor.setIdTutor(Integer.parseInt(g));
//        oBTutor.setIdTutor(Integer.parseInt(g));
//        ArrayList<String> array = new DAOTutor().detalleTutor(oBTutor);
//        String arraystring = "{\"direccion\":\""+ array.get(0) +"\", \"estado\":" + array.get(1) + ", \"numero\":\"" + array.get(2) + "\", \"denominacion\": \"" + array.get(3) + "\"}";
//        String json1 = new Gson().toJson(arraystring);
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().write(arraystring);
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);

        }
        String datt = String.valueOf(jb.toString());

            JSONObject jsonObj = new JSONObject(datt);

            BTutor oTutor = new BTutor();
            String value = (String) jsonObj.get("idTutor") ;
            
            oTutor.setIdTutor(Integer.parseInt(value));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
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
        processRequest(request, response);
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
