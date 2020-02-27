/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Operaciones;
import Modelo.ApplicationErrorException;
import Modelo.ConexionBBDD;
import Modelo.Informacion;
import Modelo.Votante;
import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.objects.Global.undefined;

/**
 *
 * @author Bonnye
 */
public class Dispacher extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ApplicationErrorException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session= request.getSession(true);
        String peticion= request.getParameter("peticion");
        Informacion info= new Operaciones().informacion(Conexion);
        String escrutinio= info.getEscrutinio();
        String votante= "";
        if(session.getAttribute("Votante")!=null){
            votante= ((Votante) session.getAttribute("Votante")).getRol();
        }
        
        ServletContext sc=getServletContext();
        RequestDispatcher rd;
        
        switch(escrutinio){
            case "cerrado":
                switch(votante){
                    case "votante":
                        switch(peticion){
                            case "baja":
                                response.sendRedirect("Vistas/VistaBajaVotantes.jsp");
                            break;
                            case "modificar":
                                response.sendRedirect("Vistas/VistaBuscarVotante.jsp");
                            break;
                            default:
                                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                            break;
                        }
                    break;
                    case "administrador":
                        switch(peticion){
                            case "listado":
                                response.sendRedirect("ControladorListarCenso");
                            break;
                            case "baja":
                                response.sendRedirect("Vistas/VistaBajaVotantes.jsp");
                            break;
                            case "modificar":
                                response.sendRedirect("Vistas/VistaBuscarVotante.jsp");
                            break;
                            case "abierto":
                                response.sendRedirect("ControladorEscrutinio?opcion="+peticion);
                            break;
                            default:
                                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                            break;
                        }
                    break;
                    case "":
                        switch(peticion){
                        case "alta":
                                response.sendRedirect("Vistas/VistaAltaVotantes.jsp");
                            break;
                        }
                    break;
                    default:
                        response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                    break;
                }
            break;
            case "abierto":
                switch(votante){
                    case "votante":
                        switch(peticion){
                            case "votar":
                                response.sendRedirect("Vistas/VistaVotar.jsp");
                            break;
                            case "baja":
                                response.sendRedirect("Vistas/VistaBajaVotantes.jsp");
                            break;
                            case "modificar":
                                response.sendRedirect("Vistas/VistaBuscarVotante.jsp");
                            break;
                            default:
                                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                            break;
                        }
                    break;
                    case "administrador":
                        switch(peticion){
                            case "votar":
                                response.sendRedirect("Vistas/VistaVotar.jsp");
                            break;
                            case "listado":
                                response.sendRedirect("ControladorListarCenso");
                            break;
                            case "baja":
                                response.sendRedirect("Vistas/VistaBajaVotantes.jsp");
                            break;
                            case "modificar":
                                response.sendRedirect("Vistas/VistaBuscarVotante.jsp");
                            break;
                            case "finalizado":
                                response.sendRedirect("ControladorEscrutinio?opcion="+peticion);
                            break; 
                            default:
                                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                            break;
                        }
                    break;
                    case "":
                        switch(peticion){
                        case "alta":
                            response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=1");
                        break;
                        }
                    break;
                    default:
                        response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                    break;
                }
            break;
            case "finalizado":
                switch(votante){
                    case "votante":
                        switch(peticion){
                            case "resultado":
                                response.sendRedirect("ControladorResultadoVotaciones");
                            break;
                             case "candidatos":
                                response.sendRedirect("ControladorElectos");
                            break;
                            default:
                                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                            break;
                        }
                    break;
                    case "administrador":
                        switch(peticion){
                            case "listado":
                                response.sendRedirect("ControladorListarCenso");
                            break;
                            case "resultado":
                                response.sendRedirect("ControladorResultadoVotaciones");
                            break;
                             case "candidatos":
                                response.sendRedirect("ControladorElectos");
                            break;
                            default:
                                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                            break;
                        }
                    break;
                    case "":
                        switch(peticion){
                        case "alta":
                            response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=1");
                        break;
                        }
                    break;
                    default:
                        response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
                    break;
                }
            break;
            default:
                response.sendRedirect("Vistas/VistaErrores.jsp?error=No puedes hacer eso&donde=0");
            break;
        }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Dispacher</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Dispacher at " + request.getContextPath() + "</h1>");
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
        } catch (SQLException ex) {
            Logger.getLogger(Dispacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ApplicationErrorException ex) {
            Logger.getLogger(Dispacher.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(Dispacher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ApplicationErrorException ex) {
            Logger.getLogger(Dispacher.class.getName()).log(Level.SEVERE, null, ex);
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
