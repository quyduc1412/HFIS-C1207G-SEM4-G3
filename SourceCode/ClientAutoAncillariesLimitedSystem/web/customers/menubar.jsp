<%-- 
    Document   : menubar
    Created on : Jul 9, 2014, 6:18:56 PM
    Author     : Duc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <a href="index.html" class="logo"><img src="images/logo.png" alt=""></a>
    <form action="">
        <input type="text" name="name" id="search" value="">
        <input type="submit" name="searchBtn" id="searchBtn" value="">
    </form>
</div>
<div class="navigation">
    <ul>
        <li>
            <a href="home">home</a>
        </li>
        <li>
            <a href="#">Product</a>
            <ul id="productmenu">

            </ul>
        </li>
        <li>
            <%
                if (request.getSession().getAttribute("USER") == null) {
                    out.print("<li><a href='register.jsp'>Register</a></li>");
                } else {
                }
            %>
        </li>

        <%
            if (request.getSession().getAttribute("USER") == null) {
                out.print("<li><a href='login.jsp'>Login</a></li>");
            } else {
            }
        %>
        <li>
            <a href="contact.html">contact</a>
        </li>
        <%
            if (request.getSession().getAttribute("USER") != null) {
                out.print("<li class='booking'> <a href='historycart'>History Order</a> </li>");
            } else {
            }
        %>
    </ul>
</div>
<script>
    $(document).ready(function() {
        var _service = Service();
        var onGetCategorySuccess = function(result) {
            var data = "";
            $.each(result.list, function(index, value) {
                data += "<li> <a href='home?category=" + value.id + "'>" + value.nameType + "</a> </li>";
            });
            $('#productmenu').html(data);
            $('#menu-category').html(data);
        };
        _service.call('../manager/getcategory', '', onGetCategorySuccess);
    });
</script>