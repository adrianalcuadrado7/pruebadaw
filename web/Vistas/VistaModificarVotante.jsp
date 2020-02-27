<%-- 
    Document   : VistaModificarVotante
    Created on : 03-ene-2020, 11:55:41
    Author     : Bonnye
--%>

<%@page import="Modelo.Votante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Votantes</title>
    </head>
    <body bgcolor="#ffd5b8">
        <%
            Votante v= (Votante)session.getAttribute("Votante");
        %>
      <form name="pepe" action="../ControladorModificarVotante" method="POST">
          <center>
      <table style="width: 400px; height: 108px;" border="1" bgcolor="#b3d0e6">
        <tbody>
          <tr align="center" bgcolor="#d9efff">
            <td rowspan="1" colspan="2">Modificacion Datos Votante</td>
          </tr>
          <tr>
            <td>NIF</td>
            <td><input name="nif" type="text" value="<% out.print(v.getNif());%>" readonly><br></td>
          </tr>
          <tr>
            <td>Contraseña</td>
            <td><input name="password" type="password" value="<% out.print(v.getPassword());%>"></td>
          </tr>
          <tr>
            <td>Nombre</td>
            <td><input name="nombre" type="text" value="<% out.print(v.getNombre());%>"></td>
          </tr>
          <tr>
            <td>Apellidos</td>
            <td><input name="apellidos" type="text" size="40" maxlength="40" value="<% out.print(v.getApellidos());%>"></td>
          </tr>
          <tr>
            <td>Domicilio</td>
            <td><input name="domicilio" type="text" maxlength="100" size="40" value="<% out.print(v.getDomicilio());%>"></td>
          </tr>
          <tr>
            <td>Fecha_nac</td>
            <td><input name="fecha_nac" type="date" value="<% out.print(v.getFecha_nac());%>"></td>
          </tr>
          <tr>
          <tr>
              <td><a href="VistaMenu.jsp">Volver al Inicio</a></td>
           <td style="text-align: center;">
          <input name="boton" type="submit" value="Modificar">
           </td>
          </tr>
        </tbody>
      </table>
          </center>
    </form>
</html>