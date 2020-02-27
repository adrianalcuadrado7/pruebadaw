<%-- 
    Document   : VistaVotar
    Created on : 04-ene-2020, 10:40:28
    Author     : Bonnye
--%>

<%@page import="Modelo.Informacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Partido"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            img{
                width:150px;
                height: 80px;
            }
        </style>
    </head>
    <body bgcolor="#ffd5b8"><!--Este de aqui va al controlador -->
    <center>
        <%
              Informacion info= (Informacion)session.getAttribute("ObjInformacion");
        %>
        <h1><% out.print(info.getTipo_consulta()+" "+info.getCircunscripcion()+" "+info.getFechaString()); %></h1>
    <form name="pepe" action="../ControladorVotacion" method="POST">
    <table style="width: 400px;height: 40px;" border="1" bgcolor="#b3d0e6">
      <tbody>
        <tr bgcolor="#d9efff">
          <td rowspan="1" colspan="11"><br>
            <div style="text-align: center;">Votación</div>
            <div style="text-align: center;">&nbsp;</div>
          </td>
        </tr>
        <tr>
            <td>Logo</td>
            <td>Siglas</td>
            <td>Voto</td>
        </tr>
        <%
            ArrayList<Partido> obj= (ArrayList<Partido>) session.getAttribute("Partidos");
            for(Partido ArrayVotaciones:obj ){
        %>
        <tr>
            <td><img src="../imagenes/<% out.print(ArrayVotaciones.getLogo()); %>"/></td>
            <td><% out.print(ArrayVotaciones.getSiglas()); %></td>
            <td><input type="radio" name="votacion" value="<% out.print(ArrayVotaciones.getId_partido()); %>"></td>
        </tr>
        <%
            }
        %>
        <tr>
            <td colspan="3"><center><input type="submit" value="Votar"></center></td>
        </tr>
      </tbody>
    </table>
        <a href="VistaMenu.jsp">Volver al inicio</a>
    </form>
    </center>
    </body>
</html>
