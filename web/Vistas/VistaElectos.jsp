<%-- 
    Document   : VistaElectos
    Created on : 16-dic-2019, 14:10:05
    Author     : addaw19
--%>

<%@page import="Modelo.Electos"%>
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
    <table style="width: 400px;height: 40px;" border="1" bgcolor="#b3d0e6">
      <tbody>
        <tr bgcolor="#d9efff">
          <td rowspan="1" colspan="11"><br>
            <div style="text-align: center;">Electos</div>
            <div style="text-align: center;">&nbsp;</div>
          </td>
        </tr>
        <tr>
            <td>Logo</td>
            <td>Siglas</td>
            <td>Votos</td>
        </tr>
        <%
            ArrayList<Electos> obj= (ArrayList<Electos>) session.getAttribute("electos");
            for(Electos ArrayElectos:obj ){
        %>
        <tr>
            <td><img src="../imagenes/<% out.print(ArrayElectos.getLogo()); %>"/></td>
            <td><% out.print(ArrayElectos.getDenominacion()); %></td>
            <td><% out.print(ArrayElectos.getNombreyapellidos()); %></td>
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