<%-- 
    Document   : index
    Created on : Jun 6, 2014, 11:29:25 AM
    Author     : Duc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="Paweł 'kilab' Balicki - kilab.pl" />
        <title>Home Admin</title>
        <link rel="shortcut icon" href="img/au-icon.png">
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/navi.css" media="screen" />
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript">
            $(function() {
                $(".box .h_title").not(this).next("ul").hide("normal");
                $(".box .h_title").not(this).next("#home").show("normal");
                $(".box").children(".h_title").click(function() {
                    $(this).next("ul").slideToggle();
                });
            });
        </script>
        <style>
            .icon-home{width: 50%;float:left;height: 150px;text-align: center;margin-top: 40px;}
            .icon-home .title{
                font-size: larger
            }
        </style>
    </head>
    <body>
        <div class="wrap">
            <div id="header">
                <%@include file="navigation.jsp" %>
            </div>

            <div id="content">
                <%@include file="sidebar.jsp" %>
                <div id="main">
                    
                    <div class="full_w">
                        <div class="icon-home" style="margin-top: 0">
                            <div class="title">Customers</div>
                            <a href="customer"><img height="150px" src="img/home/Customer.png" alt=""/></a>
                        </div>
                        <div class="icon-home" style="margin-top: 0">
                            <div class="title">Employees</div>
                            <a href="employees"><img height="150px"  src="img/home/Employee.png" alt=""/></a>
                        </div>
                        <div class="icon-home">
                            <div class="title">Products</div>
                            <a href="item"><img height="150px" src="img/home/products.png" alt=""/></a>
                        </div>
                        <div class="icon-home">
                            <div class="title">Order Manager</div>
                            <a href="managerorderadmin"><img height="150px" src="img/home/order.png" alt=""/></a>
                        </div>
                        <div class="icon-home">
                            <div class="title">Warehouses</div>
                            <a href="warehouses"><img height="150px" src="img/home/Warehouses.png" alt=""/></a>
                        </div>
                        <div class="icon-home">
                            <div class="title">Report Order</div>
                            <a href="reportorder"><img height="150px" src="img/home/report.png" alt=""/></a>
                        </div>
                    </div>
                <div class="clear"></div>
            </div>

            <div id="footer">
                <div class="left">
                    <p>Design: <a href="http://kilab.pl">Paweł Balicki</a> | Admin Panel: <a href="">YourSite.com</a></p>
                </div>
                <div class="right">
                    <p><a href="">Example link 1</a> | <a href="">Example link 2</a></p>
                </div>
            </div>
        </div>

    </body>
</html>
