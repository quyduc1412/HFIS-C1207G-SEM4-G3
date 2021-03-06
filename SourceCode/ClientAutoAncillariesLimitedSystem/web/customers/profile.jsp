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
        <link href="../manager/themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="../manager/jquery-ui-1.11.0/jquery-ui.min.js" type="text/javascript"></script>
        <link href="../manager/jquery-ui-1.11.0/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/shoppingcart.js" type="text/javascript"></script>
        <script src="js/login.js" type="text/javascript"></script>
        <script src="js/views/profile.js" type="text/javascript"></script>
        <style>
            .content tr:nth-child(even),#context tr:nth-child(even){
                background: #ffffff;
            }
            .content tr:nth-child(odd),#context tr:nth-child(odd){
                background: #f7f7f7;
            }
            #overlay{
                width: 100%;
                height: 100%;
                position: fixed;
                z-index: 1000;
                display: none;
            }
            #overlay #bg-overlay{
                height: 100%;
                width: 100%;
                opacity: 0.7;
                position: fixed;
                background: url(img/overlay.png) repeat 0 0;
            }
        </style>
    </head>
    <body>
        <div id="message" style="width: 100%;height: auto;text-align: center;font-size: xx-large;background-color: #0ba1b5;color: white"></div>
        <div id="overlay">
            <div id="bg-overlay"></div>
            <!--<div class="comfirm dialog half_w"><button id="yes">Yes</button><button id="cancel">Cancel</button></div>-->
            <div id="context">

            </div>
        </div>
        <div id="header">
            <%@include file="menubar.jsp" %>
        </div>
        <div id="body">
            <div class="content">
                <div class="section">
                    <div style="width: 100%;text-align: center"><h3>Profile</h3><a id="id-profile" style="display: none"><d:property value="customer.id"/></a></div>
                    <form id="form-updateprofile">
                        <table>
                            <tr>
                                <td>Email</td>
                                <td><d:property value="customer.email"/></td>
                            </tr>
                            <tr>
                                <td>First Name</td>
                                <td><input type="text" class="validate[required,maxSize[20]]" value="<d:property value="customer.firstName"/>" id="fname"/></td>
                            </tr>

                            <tr>
                                <td>Last Name</td>
                                <td><input type="text" class="validate[required,maxSize[20]]" value="<d:property value="customer.lastName"/>" id="lname"/></td>
                            </tr>
                            <tr>
                                <td>Gender</td>
                                <td><select id="gender"><option value="0">Male</option><option value="1">Female</option></select></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><a href="#" class="clickchangepassword">Click here to change password</a></td>
                            </tr>
                            <tr>
                                <td>Phone</td>
                                <td><input id="phone" type="text" value="<d:property value="customer.phoneNumber"/>" class="validate[custom[onlyNumber],required,maxSize[12],minSize[8]]"/></td>
                            </tr>

                            <tr>
                                <td>Address</td>
                                <td><input id="address" type="text" class="validate[required,maxSize[50]]" value="<d:property value="customer.address"/>"/>  </td>
                            </tr>

                            <tr>
                                <td>City</td>
                                <!--<td><d:property value="customer.city"/></td>-->
                                <td><select id="city"><option value="Ha Noi">Ha Noi</option><option value="Vinh Phuc">Vinh Phuc</option><option value="Ho Chi Minh">Ho Chi Minh</option></select></td>
                            </tr>

                            <tr>
                                <td>Country</td>
                                <!--<td><d:property value="customer.country"/></td>-->
                                <td><select id="country"><option value="Viet Nam">Viet Nam</option><option value="Nhat Ban">Nhat Ban</option></select></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="button" value="Update" id="update-profile"/></td>
                            </tr>
                        </table>
                    </form>
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