<%-- 
    Document   : VistaMensajes
    Created on : 03-dic-2019, 10:42:41
    Author     : addaw19
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
        <link rel="stylesheet" type="text/css" href="../css/vistaMensajes.css">
    </head>
    <body bgcolor="#ffd5b8">
        <%
            String mensaje= request.getParameter("mensaje");
            int donde= Integer.parseInt(request.getParameter("donde"));
        %>
      <center>
      <table style="width: 762px; height: 56px;" border="1" bgcolor="white">
        <tbody>
          <tr>
              <td style="text-align: center;"><h1>Correcto</h1>
            </td>
          </tr>
          <tr>
              <td><p><% out.print(mensaje); %></p>
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
