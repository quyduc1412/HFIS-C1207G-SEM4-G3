<%-- 
    Document   : detail
    Created on : Jul 1, 2014, 11:22:51 AM
    Author     : Mr.HamHo
--%>

<html>
    <head>

        <%@taglib prefix="d" uri="/struts-tags"%>
        <meta charset="UTF-8">
        <title>Blog - Car Repair Shop Website Template</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <script src="js/jquery1.9.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.json-2.4.js" type="text/javascript"></script>
        <script src="js/jquery.uploadfile.min.js" type="text/javascript"></script>
        <script src="js/classy.min.js" type="text/javascript"></script>
        <script src="js/model.js" type="text/javascript"></script>
        <script src="js/service.js" type="text/javascript"></script>
        <script type="text/javascript">
            $(function() {
                $(".box .h_title").not(this).next("ul").hide("normal");
                $(".box .h_title").not(this).next("#home").show("normal");
                $(".box").children(".h_title").click(function() {
                    $(this).next("ul").slideToggle();
                });
            });
        </script>
        <script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine.js" type="text/javascript"></script>
        <link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
        <script src="js/shoppingcart.js" type="text/javascript"></script>
        <script src="js/login.js" type="text/javascript"></script>
        <style>
            #body .content .section .booking span {
                line-height: 24px;
                padding: 10px 0 5px;
                text-transform: capitalize;
            }
            #body .content .section .booking input {
                background: url(../customers/images/interface.png) no-repeat;
                border: 0;
                height: 24px;
                line-height: 24px;
                padding: 0 5px;
            }
            #body .content .section .booking input {
                background-position: 0 -382px;
                width: 250px;
            }
        </style>
    </head>
    <body>
        <div id="message" style="width: 100%;height: auto;position: fixed;text-align: center;font-size: xx-large;background-color: #0ba1b5;color: white"></div>
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
                        <a href="index.html">home</a>
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
                    <li>
                        <a href="services.html">services</a>
                        <ul>
                            <li>
                                <a href="services.html">engine maintenance</a>
                            </li>
                            <li>
                                <a href="services.html">wheel allignment</a>
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
                    </li>
                    <li class="selected">
                        <a href="blog.html">blog</a>
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
                    <div class="booking">
                        <div class="formlogin" style="text-align: center;">
                            <h3>Login to checkout</h3>
                            <div>
                                Email :<input type="text" id="user"/>
                            </div>
                            <div>
                                Password :<input type="password" id="pass"/>
                            </div>
                            <div>
                                <input type="submit" id="submit-login" value="Continue"/>
                                <a>Register</a>
                            </div>
                            <div id="error-login"></div>
                        </div>
                    </div>
                </div>
                <div class="sidebar">
                    <div class="post">
                        <h3>Cart</h3>
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