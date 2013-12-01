/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.academia.bean.BExamen;
import org.academia.dao.DAOExamen;

/**
 *
 * @author davis
 */
@WebServlet(name = "SRegistrarExamen", urlPatterns = {"/SRegistrarExamen"})
public class SRegistrarExamen extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        try {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet SRegistrarExamen</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SRegistrarExamen at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }

        String accion = request.getParameter("accion");
        if (accion.equals("RegistrarExamen")) {
            this.registrarExamen(request, response);
        } else if (accion.equals("ModificarProducto")) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
    protected void registrarExamen(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = request.getParameter("txtFecha");
        java.util.Date utilDate = new java.util.Date();
        utilDate = null;
        java.sql.Date sqlDate = null;
//          Date fecha = null;
        try {

            utilDate = formatoDelTexto.parse(strFecha);
            sqlDate = new java.sql.Date(utilDate.getTime());

        } catch (ParseException ex) {

            ex.printStackTrace();

        }

        BExamen oBExamen = new BExamen();
        oBExamen.setTipoExamen(request.getParameter("txtTipoExamen"));
        oBExamen.setNota(Double.parseDouble(request.getParameter("txtNota")));
        oBExamen.setFecha(sqlDate);
        
        boolean rpta= DAOExamen.registrarExamen(oBExamen);
        if (rpta) {
            response.sendRedirect("Mensaje.jsp?men=se registro el producto de manera correcta");
        }
        else{
            response.sendRedirect("Mensaje.jsp?men=no se registro el producto");
                    
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
