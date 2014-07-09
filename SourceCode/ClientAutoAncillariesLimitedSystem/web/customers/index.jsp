<%-- 
    Document   : newjsp
    Created on : Jun 29, 2014, 2:26:21 PM
    Author     : Mr.HamHo
--%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
    <%@taglib prefix="s" uri="/struts-tags"%>
    <head>
        <meta charset="UTF-8">
        <title>Services - Car Repair Shop Website Template</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
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
    </head>
    <body>
        <div id="header">
            <div>
                <a href="index.html" class="logo"><img src="images/logo.png" alt=""></a>
                <form action="index.html">
                    <input type="text" name="search" id="search" value="">
                    <input type="submit" name="searchBtn" id="searchBtn" value="">
                </form>
            </div>
            <%@include file="menubar.jsp" %>
        </div>
        <div id="body">
            <div class="content">
                <div class="section">
<!--                    <div class="breadcrumb">
                        <span>You are here:</span>
                        <ul>
                            <li>
                                <a href="index.html">home</a>
                            </li>
                            <li>
                                <a href="services.html">services</a>
                            </li>
                            <li>
                                <a href="services.html">engine maintenance</a>
                            </li>
                        </ul>
                    </div>-->
                    <div class="services">
                        <h2>Product</h2>
                        <ul>
                            <s:iterator value="litstItem" var="l">
                                <li>
                                    <a href="#" class="figure"><img src='../upload/<s:property value="thumbnail"/>' width="169" height="152" alt=""></a>
                                    <div>
                                        <h3><s:property value="name" /></h3>
                                        <p><s:property value="descriptionDisplay" /></p>
                                        <p><s:property value="typeItem.nameType" /></p>
                                        <p><s:property value="price" /></p>
                                         <a href="detail?id=<s:property value="id" />">Detail</a>
                                    </div>
                                </li>
                            </s:iterator>
              
                            <li>
                                <a href="#" class="figure"><img src="images/tool-box.jpg" alt=""></a>
                                <div>
                                    <h3>Quisque consectetur</h3>
                                    <p>
                                        If you're having problems editing this website template, then don't hesitate to ask for help on the <a href="http://www.freewebsitetemplates.com/forums/">Forums</a>. Morbi eros diam, placerat in elementum et, dictum at tellus. Fusce eleifend convallis risus vel malesuada.
                                    </p>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <%@include file="sidebar.jsp" %>
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