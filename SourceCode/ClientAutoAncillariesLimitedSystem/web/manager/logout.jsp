<%-- 
    Document   : logout
    Created on : Jul 12, 2014, 1:12:04 PM
    Author     : Duc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
            if(session.getAttribute("USER-EMPLOYEE")==null){
                response.sendRedirect("loginemployee.jsp");
            }else{
                session.setAttribute("USER-EMPLOYEE", null);
                response.sendRedirect("loginemployee.jsp");
            }
        %>
    </body>
</html>
