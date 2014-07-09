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
        <!--[if lt IE 9]>
                <link rel="stylesheet" type="text/css" href="css/ie.css">
        <![endif]-->
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
            <div class="navigation">
                <ul>
                    <li>
                        <a href="home">home</a>
                    </li>
                    <li>
                        <a href="about.html">about</a>
                        <ul>
                            <li>
                                <a href="team.html">the team</a>
                            </li>
                            <li>
                                <a href="testimonials.html">testimonials</a>
                            </li>
                            <li>
                                <a href="gallery.html">gallery</a>
                            </li>
                        </ul>
                    </li>
                    <li class="selected">
                        <a href="">categrory</a>
                        <ul>
                            <s:iterator value="listTypeItem" var="l">
                                <li>
                                    <a href=""><s:property value="nameType" /></a>
                                </li>
                                        
                            </s:iterator>                                                       
                        </ul>
                    </li>
                    
                    <li>
                        <a href="contact.html">contact</a>
                    </li>
                    <li class="booking">
                        <a href="booking.html">book an appointment</a>
                    </li>
                </ul>
            </div>
        </div>
        <div id="body">
            <div class="content">
                <div class="section">
                    <div class="breadcrumb">
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
                    </div>
                    <div class="services">
                        <h2>services</h2>
                        <ul>
                            <s:iterator value="litstItem" var="l">
                                <li>
                                    <a href="#" class="figure"><img src='../upload/<s:property value="thumbnail"/>' width="169" height="152" alt=""></a>
                                    <div>
                                        <h3><s:property value="name" /></h3>
                                        <p><s:property value="description" /></p>
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
                <div class="sidebar">
                    <div class="navigation">
                        <h3>Services</h3>
                        <ul>
                            <li class="selected">
                                <a href="services.html">engine maintenance</a>
                            </li>
                            <li>
                                <a href="services.html">wheel alignment</a>
                            </li>
                            <li>
                                <a href="services.html">air condition services</a>
                            </li>
                            <li>
                                <a href="services.html">transmission</a>
                            </li>
                            <li>
                                <a href="promo.html">promos &amp; discounts</a>
                            </li>
                        </ul>
                    </div>
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
                    <div class="gallery">
                        <h3>featured from gallery</h3>
                        <a href="gallery.html" class="figure"><img src="images/featured.jpg" alt=""></a> <span><a href="gallery.html">Aenean interdum erat urna</a></span>
                        <p>
                            Nam lectus quam, dictum a vehicula ut, congue ac arcu. Sed vitae nisi ut nibh iaculis bibendums.
                        </p>
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