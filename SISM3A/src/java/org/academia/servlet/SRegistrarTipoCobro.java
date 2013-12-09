/*
 * To change this template, choose Tools | Templates
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
import javax.xml.bind.ParseConversionEvent;
import org.academia.bean.BTipoCobro;
import org.academia.dao.DAOTipoCobro;
import org.json.JSONObject;

/**
 *
 * @author davis
 */
@WebServlet(name = "SRegistrarTipoCobro", urlPatterns = {"/SRegistrarTipoCobro"})
public class SRegistrarTipoCobro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

//        String accion = request.getParameter("accion");
//        if (accion.equals("RegistrarTipoCobro")) {
//            this.registrarTipoCobro(request, response);
//        } else if (accion.equals("ModificarTipoCobro")) {
//        }
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
//    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

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
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }

            String datt = String.valueOf(jb.toString());

            JSONObject jsonObj = new JSONObject(datt);

            BTipoCobro oBTipoCobro = new BTipoCobro();
            String value;

            value = (String) jsonObj.get("idCiclo");
            oBTipoCobro.setIdCiclo(Integer.parseInt(value));

            value = (String) jsonObj.get("denominacion");
            oBTipoCobro.setDenominacion(value);

            value = (String) jsonObj.get("monto");
            oBTipoCobro.setMonto(Double.parseDouble(value));

            boolean flag = new DAOTipoCobro().registrarTipoCobro(oBTipoCobro);
            if (flag == true) {
                String json1 = new Gson().toJson("Tipo cobro registrado!");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);

            } else {
                String json1 = new Gson().toJson("Error al registrar tipo cobro");
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                response.getWriter().write(json1);
            }

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
}
