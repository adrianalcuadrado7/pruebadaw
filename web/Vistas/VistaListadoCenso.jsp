<%-- 
    Document   : VistaListadoCenso
    Created on : 10-dic-2019, 10:42:05
    Author     : addaw19
--%>

<%@page import="Modelo.Informacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#ffd5b8"><!--Este de aqui va al controlador -->
    <center>
        <%
              Informacion info= (Informacion)session.getAttribute("ObjInformacion");
        %>
        <h1><% out.print(info.getTipo_consulta()+" "+info.getCircunscripcion()+" "+info.getFechaString()); %></h1>
    <table style="width: 1135px; height: 40px;" border="1" bgcolor="#b3d0e6">
      <tbody>
        <tr bgcolor="#d9efff">
          <td rowspan="1" colspan="11"><br>
            <div style="text-align: center;">Listado Censo</div>
            <div style="text-align: center;">&nbsp;</div>
          </td>
        </tr>
        <tr>
          <td style="width: 53.2px;">Nif</td>
          <td style="width: 56.2px;">Nombre</td>
          <td style="width: 68.2px;">Apellidos</td>
          <td style="width: 53.2px;">Domicilio</td>
          <td style="width: 53.2px;">Fecha Nacimiento</td>
          <td style="width: 53.2px;">Votado</td>
        </tr>
        <%
            ArrayList<Votante> obj= (ArrayList<Votante>) session.getAttribute("ArrayVotantes");
            for(Votante ArrayVotante:obj ){
        %>
        <tr>
            <td><% out.print(ArrayVotante.getNif()); %></td>
            <td><% out.print(ArrayVotante.getNombre()); %></td>
            <td><% out.print(ArrayVotante.getApellidos()); %></td>
            <td><% out.print(ArrayVotante.getDomicilio()); %></td>
            <td><% out.print(ArrayVotante.getFecha_nacString()); %></td>
            <td><% out.print(ArrayVotante.getVotado()); %></td>
        </tr>
        <%
            }
        %>
      </tbody>
    </table>
        <a href="VistaMenu.jsp">Volver al inicio</a>
    </center>
    </body>
</html>
