<%@page import="autoancillarieslimited.hiberate.entities.Employee"%>
<div id="header">
    <div id="top">
        <%
            if (request.getSession().getAttribute("USER-EMPLOYEE") != null) {
                Employee e = (Employee) request.getSession().getAttribute("USER-EMPLOYEE");
                out.print("<div class='left'> <p>Welcome, <strong>" + e.getEmail() + "</strong> [ <a href='profileemployee'>Profile</a> ][ <a href='logout.jsp'>Logout</a> ]</p> </div>");
            } else {
                response.sendRedirect("loginemployee.jsp");
            }
        %>
    </div>
    <%@include file="navigation.jsp" %>
</div>