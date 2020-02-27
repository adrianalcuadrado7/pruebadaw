<%-- 
    Document   : VistaAltaVotantes
    Created on : 19-nov-2019, 9:39:48
    Author     : addaw19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Votantes</title>
    </head>
    <body bgcolor="#ffd5b8">
      <form name="pepe" action="../ControladorAltaVotantes" method="POST">
          <center>
      <table style="width: 400px; height: 108px;" border="1" bgcolor="#b3d0e6">
        <tbody>
          <tr align="center" bgcolor="#d9efff">
            <td rowspan="1" colspan="2">Registro</td>
          </tr>
          <tr>
            <td>NIF</td>
            <td><input name="nif" type="text"><br></td>
          </tr>
          <tr>
            <td>Contraseña</td>
            <td><input name="password" type="password"></td>
          </tr>
          <tr>
            <td>Nombre</td>
            <td><input name="nombre" type="text"></td>
          </tr>
          <tr>
            <td>Apellidos</td>
            <td><input name="apellidos" type="text" size="40" maxlength="40"></td>
          </tr>
          <tr>
            <td>Domicilio</td>
            <td><input name="domicilio" type="text" maxlength="100" size="40"></td>
          </tr>
          <tr>
            <td>Fecha_nac</td>
            <td><input name="fecha_nac" type="date"></td>
          </tr>
          <tr>
          <tr>
              <td><a href="../index.html">Volver al Inicio</a></td>
           <td style="text-align: center;">
          <input name="boton" type="submit" value="Enviar">
           </td>
          </tr>
        </tbody>
      </table>
          </center>
    </form>
</html>
