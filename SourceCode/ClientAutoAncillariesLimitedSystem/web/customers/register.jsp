<%-- 
    Document   : register
    Created on : Jul 9, 2014, 2:38:28 PM
    Author     : Han
--%>

<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
    <head>
        <meta charset="UTF-8">
        <title>Book An Apppointment - Car Repair Shop Website Template</title>
        <link rel="stylesheet" href="css/style_1.css" type="text/css">
        <script src="js/jquery1.9.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.json-2.4.js" type="text/javascript"></script>
        <script src="js/jquery.uploadfile.min.js" type="text/javascript"></script>
        <script src="js/classy.min.js" type="text/javascript"></script>
        <script src="js/model.js" type="text/javascript"></script>
        <script src="js/service.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine.js" type="text/javascript"></script>
        <link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
        <script src="js/shoppingcart.js" type="text/javascript"></script>
        <script src="js/register.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="message" style="width: 100%;height: auto;position: fixed;text-align: center;font-size: xx-large;background-color: #0ba1b5;color: white"></div>
        <div id="header">
            <%@include file="menubar.jsp" %>
        </div>
        <div id="body">
            <div class="content">
                <div class="section">
                    <div class="booking">
                        <form action="index.html" id="register">
                            <h4>Register</h4>
                            <div class="form1 register">
                                <label for="fname"> <span>first name</span>
                                    <input type="text" name="fname" id="fname" class="validate[required,maxSize[20]]">
                                </label>
                                <label for="lname"> <span>last name</span>
                                    <input type="text" name="lname" id="lname" class="validate[required,maxSize[20]]">
                                </label>
                                <label for="email3"> <span>email</span>
                                    <input type="text" name="email3" id="email3" class="validate[required,custom[email],maxSize[30]]">
                                </label>
                                <label for="phone"> <span>phone number</span>
                                    <input type="text" name="phone" id="phone" class="validate[custom[onlyNumber],required,minSize[9],maxSize[20]]">
                                </label>
                                <label for="address1"> <span>address</span>
                                    <input type="text" name="address1" id="address1" class="validate[required,maxSize[20]]">
                                </label>
                                <div class="register_1">
                                    <label for="city"> <span>city</span>
                                        <input type="text" name="city" id="city" class="validate[required,maxSize[20]]">
                                    </label>

                                </div>
                                <label for="address2"> <span>password</span>
                                    <input type="password" name="password" id="address2" class="validate[required,maxSize[20],minSize[8]]">
                                </label>
                                <label for="address2"> <span>Re-password</span>
                                    <input type="password" name="password" id="address3" class="validate[required,maxSize[20],minSize[8],equals[address2]]">
                                </label>
                                <label for="zip"> <span>country</span>
                                    <input type="text" name="country" id="zip" class="validate[required,maxSize[20]]">
                                </label>
                                <label for="state" style="margin-left: 40px;"> <span>gender</span>
                                    <select name="gender" id="gender">
                                        <option value="0">Male</option>
                                        <option value="1">Female</option>
                                    </select>
                                </label>
                            </div>
                            <input type="submit" name="send2" id="send2" value="" style="background: url(img/orange_registerbutton.png) no-repeat;">
                        </form>
                    </div>
                </div>
                <div class="sidebar">
                    <div class="contact">
                        <div>
                            <a href="gallery.html"><img src="images/lava2.jpg" alt=""></a>
                        </div>
                        <h4>contact information</h4>
                        <ul>
                            <li>
                                <b>address:</b> <span>FPT - Aptech Group 3</span>
                            </li>
                            <li>
                                <b>phone:</b> <span>+841695716614</span>
                            </li>
                            <li>
                                <b>email:</b> <span><a>ducnxq_b01437@fpt.aptech.ac.vn</a></span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="footer">
            <div>
                <div class="contact">
                    <h3>contact information</h3>
                    <ul>
                        <li>
                            <b>address:</b> <span>426 Grant Street Pine Hill, TX 75652</span>
                        </li>
                        <li>
                            <b>phone:</b> <span>903-889-6313</span>
                        </li>
                        <li>
                            <b>fax:</b> <span>903-889-6313</span>
                        </li>
                        <li>
                            <b>email:</b> <span><a href="http://www.freewebsitetemplates.com/misc/contact">info@carrepairshop.com</a></span>
                        </li>
                    </ul>
                </div>
                <div class="tweets">
                    <h3>recent tweets</h3>
                    <ul>
                        <li>
                            <a href="#">Fusce ut massa magna, quis aliquam justo. In hac habitasse platea dictumst.<span>1 day ago</span></a>
                        </li>
                        <li>
                            <a href="#">Fusce ut massa magna, quis aliquam justo.<span>2 days ago</span></a>
                        </li>
                    </ul>
                </div>
                <div class="posts">
                    <h3>recent blog post</h3>
                    <ul>
                        <li>
                            <a href="#">Fusce Ut Massa Magna</a>
                        </li>
                        <li>
                            <a href="#">Quis Aliquam Justo</a>
                        </li>
                        <li>
                            <a href="#">In Hac Habitasse Platea</a>
                        </li>
                        <li>
                            <a href="#">Vestibulum Volutpat Turpis Eu Leo Eleifend Et Adipiscing </a>
                        </li>
                    </ul>
                </div>
                <div class="connect">
                    <h3>stay in touch</h3>
                    <p>
                        Donec tempor, ipsum quis imperdiet, sapien sapien iaculis elit, at malesuada nulla nibh vel eros.
                    </p>
                    <ul>
                        <li id="facebook">
                            <a href="http://freewebsitetemplates.com/go/facebook/">facebook</a>
                        </li>
                        <li id="twitter">
                            <a href="http://freewebsitetemplates.com/go/twitter/">twitter</a>
                        </li>
                        <li id="googleplus">
                            <a href="http://freewebsitetemplates.com/go/googleplus/">googleplus</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="section">
                <p>
                    &copy; this is the copyright area
                </p>
                <ul>
                    <li>
                        <a href="index.html">home</a>
                    </li>
                    <li>
                        <a href="about.html">about</a>
                    </li>
                    <li>
                        <a href="services.html">services</a>
                    </li>
                    <li>
                        <a href="blog.html">blog</a>
                    </li>
                    <li>
                        <a href="contact.html">contact</a>
                    </li>
                    <li>
                        <a href="booking.html">book an appointment</a>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>