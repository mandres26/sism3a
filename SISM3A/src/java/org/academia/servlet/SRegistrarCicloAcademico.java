/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.academia.servlet;

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

/**
 *
 * @author davis
 */
@WebServlet(name = "SRegistrarCicloAcademico", urlPatterns = {"/SRegistrarCicloAcademico"})
public class SRegistrarCicloAcademico extends HttpServlet {

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
//            out.println("<title>Servlet SRegistrarCicloAcademico</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet SRegistrarCicloAcademico at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        } finally {            
//            out.close();
//        }

        String accion = request.getParameter("accion");
        if (accion.equals("RegistrarCicloAcademico")) {
            this.registrarCicloAcademico(request, response);
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
    protected void registrarCicloAcademico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        Date fechaIni = convertStringToDate(request.getParameter("txtFechaInicio"));
        Date fechaFin = convertStringToDate(request.getParameter("txtFechaFin"));
        java.sql.Date sqlDateIni = new java.sql.Date(fechaIni.getTime());
        java.sql.Date sqlDateFin = new java.sql.Date(fechaFin.getTime());

        BCicloAcademico oBCicloAcademico = new BCicloAcademico();

        oBCicloAcademico.setTipoCiclo(request.getParameter("txtTipoCicloAcademico"));
        oBCicloAcademico.setFechaInicio(sqlDateIni);
        oBCicloAcademico.setFechaFin(sqlDateFin);
        oBCicloAcademico.setCosto(Double.parseDouble(request.getParameter("txtCosto")));

        BTipoCobro oBTipoCobro = new BTipoCobro();
        oBTipoCobro.setDenominacion(request.getParameter("txtDenominacion"));
        oBTipoCobro.setMonto(Double.parseDouble(request.getParameter("txtMonto")));

        boolean repta = DAOTipoCobro.registrarTipoCobro(oBTipoCobro);
        oBCicloAcademico.setIdTipoCobro(2);

        boolean rpta = DAOCicloAcademico.registrarCicloAcademico(oBCicloAcademico);
        if (rpta) {
            response.sendRedirect("registrarCicloAcademico.jsp");
        } else {
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
