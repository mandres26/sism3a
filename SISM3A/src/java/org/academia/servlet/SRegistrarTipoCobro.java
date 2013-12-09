/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;
import org.academia.bean.BTipoCobro;
import org.academia.dao.DAOTipoCobro;

/**
 *
 * @author davis
 */
@WebServlet(name = "SRegistrarTipoCobro", urlPatterns = {"/SRegistrarTipoCobro"})
public class SRegistrarTipoCobro extends HttpServlet {

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
//            out.println("<title>Servlet SRegistrarTipoCobro</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SRegistrarTipoCobro at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }

        String accion = request.getParameter("accion");
        if (accion.equals("RegistrarTipoCobro")) {
            this.registrarTipoCobro(request, response);
        } else if (accion.equals("ModificarTipoCobro")) {
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
    protected void registrarTipoCobro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        BTipoCobro oBTipoCobro = new BTipoCobro();
        oBTipoCobro.setDenominacion(request.getParameter("txtDenominacion"));
        oBTipoCobro.setMonto(Double.parseDouble(request.getParameter("txtMonto")));

        boolean rpta= DAOTipoCobro.registrarTipoCobro(oBTipoCobro);
        if (rpta) {
            response.sendRedirect("registrarCicloAcademico.jsp");
        }
        else{
            response.sendRedirect("Mensaje.jsp?men=no se registro el tipo cobro");
                    
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
