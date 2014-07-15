<%-- 
    Document   : detail
    Created on : Jul 1, 2014, 11:22:51 AM
    Author     : Mr.HamHo
--%>

<html>
    <head>

        <%@taglib prefix="s" uri="/struts-tags"%>
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
    </head>
    <body><div id="message" style="width: 100%;height: auto;position: fixed;text-align: center;font-size: xx-large;background-color: #0ba1b5;color: white"></div>
        <div id="header">
            <%@include file="menubar.jsp" %>
        </div>
        <div id="body">
            <div class="content">
                <div class="section">
                    <div class="blog">
                        <div class="article">

                            <div>
                                <a href="#" class="figure"><img src='../upload/<s:property value="item.thumbnail"/>' width="169" height="152" alt=""></a>
                                <h3><s:property value="item.name" /></h3>
                                <p><s:property value="item.description" /></p>
                                <p>Category : <s:property value="item.typeItem.nameType" /></p>
                                <p>Price : <s:property value="item.price" /></p>
                                <input type="submit" name="Add To Cart" id="addtocart" value="" style="float: right;background: url(img/Add-to-Cart-Button.png) no-repeat;width: 120px;height: 32px">
                            </div>
                        </div>
                        <div class="comment">
                            <h4>one comment</h4>
                            <div>
                                <a href="#" class="figure"><img src="images/janedoe.jpg" alt="">jane doe</a>
                                <p>
                                    <span>july 27, 2023</span> This is a comment. Nunc sed porta neque. Sed dui elit, condimentum venenatis pretium ut, pellentesque eget nulla. Nulla facilisi. <a href="#" class="reply">reply</a>
                                </p>
                            </div>
                        </div>
                        <div class="commentForm">
                            <h4>leave a comment</h4>
                            <form action="index.html">
                                <div>
                                    <label for="name"> <span>name</span>
                                        <input type="text" name="name" id="name">
                                    </label>
                                    <label for="email"> <span>email</span>
                                        <input type="text" name="email" id="email">
                                    </label>
                                </div>
                                <label for="comment"> <span>comment</span>
                                    <textarea name="comment" id="comment"></textarea>
                                </label>
                            </form>
                        </div>
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