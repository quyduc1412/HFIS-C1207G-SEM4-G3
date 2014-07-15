<%-- 
    Document   : navigation
    Created on : Jul 7, 2014, 11:43:10 AM
    Author     : Duc
--%>

<%@page import="autoancillarieslimited.hiberate.entities.Admin"%>
<div id="top">
    <div class="left">
        <% 
            if(session.getAttribute("USER-ADMIN")!=null){
                Admin admin  = (Admin)session.getAttribute("USER-ADMIN");
                out.print("<p>Welcome, <strong>"+admin.getEmail()+".</strong> [ <a href='logout.jsp'>logout</a> ]</p>");
            }else{
                response.sendRedirect("loginemployee.jsp");
            }
        %>
    </div>
    <div class="right">
        <div class="align-right">
            <p>Last login: <strong>23-04-2012 23:12</strong></p>
        </div>
    </div>
</div>
<div id="nav">
    <ul>
        <li class="upp"><a href="home">Main control</a>
        </li>
        <li class="upp"><a href="#">Manage content</a>
            <ul>
                <li>>> <a href="warehouses">Warehouses</a></li>
                <li>>> <a href="employees">Employee</a></li>
                <li>>> <a href="item">Item</a></li>
            </ul>
        </li>
        <li class="upp"><a href="#">Customer</a>
            <ul>
                <li>>> <a href="customer">Manager Customer</a></li>
                <li>>> <a href="">Add new user</a></li>
                <li>>> <a href="">Lock users</a></li>
            </ul>
        </li>
        <li class="upp"><a href="managerorderadmin">Order</a>
            <ul>
                <li>>> <a href="managerorderadmin">Manager Order</a></li>
            </ul>
        </li>
    </ul>
</div>