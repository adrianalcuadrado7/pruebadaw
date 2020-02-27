<%-- 
    Document   : VistaErrores
    Created on : 03-dic-2019, 9:56:30
    Author     : addaw19
--%>

<%@page import="Modelo.ApplicationErrorException"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="../css/vistaErrores.css">
    </head>
    <body bgcolor="#ffd5b8">
        <%
            
            String error= request.getParameter("error");
            int donde= Integer.parseInt(request.getParameter("donde"));
        %>
      <center>
      <table style="width: 762px; height: 56px;" border="1" bgcolor="white">
        <tbody>
          <tr>
              <td style="text-align: center;"><h1>Error</h1>
            </td>
          </tr>
          <tr>
              <td><p><% out.print(error); %></p>
            </td>
          </tr>
        </tbody>
      </table>
            <%
                if(donde==1){
            %>
            <a href="../index.html">Volver al inicio</a>
            <%
                }
                else{
            %>
          <a href="VistaMenu.jsp">Volver al inicio</a>
            <%
                }
            %>
    </center>
    </body>
</html>
