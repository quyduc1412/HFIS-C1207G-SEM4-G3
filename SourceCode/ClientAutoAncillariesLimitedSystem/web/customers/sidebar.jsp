<script src="js/login.js" type="text/javascript"></script>
<%@page import="autoancillarieslimited.hiberate.entities.Customer"%>
<div class="sidebar">
    <div class="post">
        <h3>Cart</h3>
    </div>
    <div class="categories">
        <h3>User</h3>
        <%
            if (request.getSession().getAttribute("USER") == null) {
                out.print("<div style='text-align: center;' id='formlogin'><br/><input type='text' id='user' name='username2'/><input id='pass' type='password' name='password2'/><br/><input type='submit' id='submit-login' value='Login'/><input type='submit' value='Register'/></div>");
            } else {
                Customer user = (Customer) request.getSession().getAttribute("USER");
                out.print("<div style='text-align: center;'>Webcome <a style='color:blue;'> " + user.getEmail()+ "<a> <a href='logout'>Logout</a></div>");
                out.print("<ul> <li> <a href='historycart'>Order History</a> </li> <li> <a href='#'>Profile</a> </li> <li> <a href='#'>Change Password</a> </li> </ul>");
            }
        %>
    </div>
    <div class="categories">
        <h3>categories</h3>
        <ul id="menu-category">
        </ul>
    </div>
    <div class="archives">
        <h3>archive</h3>
        <ul>
            <li>
                <a href="blog-single.html">june 2023</a>
            </li>
            <li>
                <a href="blog-single.html">may 2023</a>
            </li>
            <li>
                <a href="blog-single.html">april 2023</a>
            </li>
            <li>
                <a href="blog-single.html">march 2023</a>
            </li>
            <li>
                <a href="blog-single.html">february 2023</a>
            </li>
        </ul>
    </div>
</div>   