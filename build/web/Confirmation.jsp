<%-- 
    Document   : Confirmation
    Created on : 25-01-2019, 21:21:31
    Author     : KATHY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession objsesion=request.getSession(false);
    String Nombre=(String)objsesion.getAttribute("nombre");
    if (Nombre.equals("")){
        response.sendRedirect("LogIn.jsp");
    }
   out.println(request.getAttribute("personaje"));

%>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <br><br><br>
        <div align="center">
            <img src="https://fontmeme.com/permalink/190206/cc8bff332df13d63619f061948f54771.png" alt="pokemon-font" border="0"><br><br>
            <h1><strong style="font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 40px; text-decoration: none; padding-right: 5px"><%out.println(Nombre);%>.</strong></h1>
            <br>
        </div>
        <div align="center">
            <h2> <strong style="font-family: Arial, Helvetica, sans-serif; color: #2a75bb; font-size: 25px; text-decoration: none; padding-right: 5px">Ingresa a tu</strong>
                <br>
              <a href="Personaje.jsp">
                  <img src="https://fontmeme.com/permalink/190206/cc9e13605efe0631c4ee6b88902da0b9.png" alt="pokemon-font" border="0"></a></h2>        
        </div>
        
    </body>
</html>