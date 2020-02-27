/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Operaciones;
import Modelo.ApplicationErrorException;
import Modelo.ConexionBBDD;
import Modelo.Electos;
import Modelo.Informacion;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author addaw19
 */
public class ControladorElectos extends HttpServlet {

    private Connection Conexion;
    public void init(ServletConfig config) throws ServletException {
        try{
            ConexionBBDD ConexBD=ConexionBBDD.GetConexion();
            Conexion=(Connection) ConexBD.GetCon();
        }catch(ClassNotFoundException cnfe){
            
        }catch(SQLException sqle){
            
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ApplicationErrorException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                HttpSession session= request.getSession(true);
                int i= ((Informacion)session.getAttribute("ObjInformacion")).getCandidatos();
                ArrayList<Electos> electos= new Operaciones().calcularElectos(i,Conexion);
                session.setAttribute("electos", electos);
                response.sendRedirect("Vistas/VistaElectos.jsp");
            } catch (ApplicationErrorException AEE) {
                response.sendRedirect("Vistas/VistaErrores.jsp?error="+AEE+"&donde=0");
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorElectos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorElectos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
        } catch (ApplicationErrorException ex) {
            Logger.getLogger(ControladorElectos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorElectos.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ApplicationErrorException ex) {
            Logger.getLogger(ControladorElectos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorElectos.class.getName()).log(Level.SEVERE, null, ex);
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
