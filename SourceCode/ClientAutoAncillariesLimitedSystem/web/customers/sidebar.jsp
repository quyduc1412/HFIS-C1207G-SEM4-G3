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
                out.print("Webcome " + user.getEmail()+ " <a href='logout'>Logout</a>");
            }
        %>
    </div>
    <div class="categories">
        <h3>categories</h3>
        <ul>
            <li>
                <a href="blog-single.html">customize</a>
            </li>
            <li>
                <a href="http://www.freewebsitetemplates.com/">freewebsite templates</a>
            </li>
            <li>
                <a href="http://www.freewebsitetemplates.com/">free web design</a>
            </li>
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