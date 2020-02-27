/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Operaciones;
import Modelo.ApplicationErrorException;
import Modelo.ConexionBBDD;
import Modelo.Votante;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bonnye
 */
public class ControladorBuscarVotante extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        Votante objVotante= new Votante();
        objVotante.setNif(usuario);
        objVotante.setPassword(password);
        HttpSession session= request.getSession(true);
        Votante v= (Votante) session.getAttribute("Votante");
        try {
          new Operaciones().comprobarVotante(Conexion, objVotante);
          if(v.getNif().equals(objVotante.getNif())){
            if(v.getVotado().equals("N")){
                response.sendRedirect("Vistas/VistaModificarVotante.jsp");
            }
            else{
                throw new ApplicationErrorException(0,"Ya has votado","Este usuario ya ha votado en buscarVotante");
            }
          }
          else{
              throw new ApplicationErrorException(1,"Usuario erroneo","Usuario erroneo en buscarVotante");
          }
        } catch (ApplicationErrorException AEE) {
            if(AEE.getCodigo()==0||AEE.getCodigo()==1){
               response.sendRedirect("Vistas/VistaErrores.jsp?error="+AEE+"&donde=0"); 
            }
            else{
                response.sendRedirect("Vistas/VistaErrores.jsp?error="+AEE+"&donde=1"); 
            }
        }
        
        
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorBuscarVotante</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorBuscarVotante at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
