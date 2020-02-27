<%-- 
    Document   : Menu
    Created on : 18-nov-2019, 13:46:35
    Author     : addaw19
--%>

<%@page import="Modelo.Informacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Menu</title>
        <link rel="stylesheet" type="text/css" href="../css/index.css">
    </head>
    <body bgcolor="#ffd5b8">
      <div id="header">
          <%
              Informacion info= (Informacion)session.getAttribute("ObjInformacion");
          %>
          <center>
              <h1><% out.print(info.getTipo_consulta()+" "+info.getCircunscripcion()+" "+info.getFechaString()); %></h1>
          </center>
        <ul class="nav">
            <li><a href="../Dispacher?peticion=listado">Listado Censo</a>
            </li>
            <li><a href="">Escrutinio</a>
                <ul>
                    <li><a href="../Dispacher?peticion=abierto">Abrir votaciones</a></li>
                    <li><a href="../Dispacher?peticion=finalizado">Finalizar votaciones</a></li>
                </ul>
            </li>
            <li><a href="">Votantes</a>
                <ul>
                    <li><a href="../Dispacher?peticion=baja">Darse de baja</a></li>
                    <li><a href="../Dispacher?peticion=modificar">Modificar datos</a></li>
                </ul>
            </li>
            <li><a href="../Dispacher?peticion=votar">Votar</a>
            </li>
            <li><a href="">Listados</a>
                <ul>
                    <li><a href="../Dispacher?peticion=resultado">Resultado de las votaciones</a></li>
                    <li><a href="../Dispacher?peticion=candidatos">Candidatos elegidos</a></li>
                </ul>
            </li>
            <li><a href="../ControladorSalir">Salir</a>
            </li>
        </ul>
      </div>
    </body>
</html>
