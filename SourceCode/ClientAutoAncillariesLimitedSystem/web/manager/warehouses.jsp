<%-- 
    Document   : index
    Created on : Jun 6, 2014, 11:29:25 AM
    Author     : Duc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="d" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="Paweł 'kilab' Balicki - kilab.pl" />
        <title>SimpleAdmin</title>
        <link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/navi.css" media="screen" />
        <link href="js/uploadfile.min.css" rel="stylesheet" type="text/css"/>
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
        <script src="js/model/reponse.js" type="text/javascript"></script>
        <script src="js/view/warehouses.js" type="text/javascript"></script>
        <style>
            #overlay{
                width: 100%;
                height: 100%;
                position: fixed;
                z-index: 1000;
                display: none;
            }
            .dialog.half_w{
                margin-left: auto;
                margin-right: auto;
                float: none;

                position: relative;
            }
            .dialog.half_w.confirm{
                margin-top: 100px;
                text-align: center;

            }
            .dialog.half_w.confirm h3.title{
                height: 30px;
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
         <div id="message" style="width: 100%;height: auto;position: fixed;text-align: center;font-size: xx-large;background-color: #0ba1b5;color: white"></div>
        <div id="overlay">
            <div id="bg-overlay"></div>
            <!--<div class="comfirm dialog half_w"><button id="yes">Yes</button><button id="cancel">Cancel</button></div>-->
            <div id="context"></div>
        </div>
        <div class="wrap">
            <div id="header">
                <div id="top">
                    <div class="left">
                        <p>Welcome, <strong>Paweł B.</strong> [ <a href="">logout</a> ]</p>
                    </div>
                    <div class="right">
                        <div class="align-right">
                            <p>Last login: <strong>23-04-2012 23:12</strong></p>
                        </div>
                    </div>
                </div>
                <div id="nav">
                    <ul>
                        <li class="upp"><a href="#">Main control</a>
                            <ul>
                                <li>&#8250; <a href="">Visit site</a></li>
                                <li>&#8250; <a href="">Reports</a></li>
                                <li>&#8250; <a href="">Add new page</a></li>
                                <li>&#8250; <a href="">Site config</a></li>
                            </ul>
                        </li>
                        <li class="upp"><a href="#">Manage content</a>
                            <ul>
                                <li>&#8250; <a href="">Show all pages</a></li>
                                <li>&#8250; <a href="">Add new page</a></li>
                                <li>&#8250; <a href="">Add new gallery</a></li>
                                <li>&#8250; <a href="">Categories</a></li>
                            </ul>
                        </li>
                        <li class="upp"><a href="#">Users</a>
                            <ul>
                                <li>&#8250; <a href="">Show all uses</a></li>
                                <li>&#8250; <a href="">Add new user</a></li>
                                <li>&#8250; <a href="">Lock users</a></li>
                            </ul>
                        </li>
                        <li class="upp"><a href="#">Settings</a>
                            <ul>
                                <li>&#8250; <a href="">Site configuration</a></li>
                                <li>&#8250; <a href="">Contact Form</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

            <div id="content">
                <div id="sidebar">
                    <div class="box">
                        <div class="h_title">&#8250; Main control</div>
                        <ul id="home">
                            <li class="b1"><a class="icon view_page" href="">Visit site</a></li>
                            <li class="b2"><a class="icon report" href="">Reports</a></li>
                            <li class="b1"><a class="icon add_page" href="">Add new page</a></li>
                            <li class="b2"><a class="icon config" href="">Site config</a></li>
                        </ul>
                    </div>

                    <div class="box">
                        <div class="h_title">&#8250; Manage content</div>
                        <ul>
                            <li class="b1"><a class="icon page" href="">Show all pages</a></li>
                            <li class="b2"><a class="icon add_page" href="">Add new page</a></li>
                            <li class="b1"><a class="icon photo" href="">Add new gallery</a></li>
                            <li class="b2"><a class="icon category" href="">Categories</a></li>
                        </ul>
                    </div>
                    <div class="box">
                        <div class="h_title">&#8250; Users</div>
                        <ul>
                            <li class="b1"><a class="icon users" href="">Show all users</a></li>
                            <li class="b2"><a class="icon add_user" href="">Add new user</a></li>
                            <li class="b1"><a class="icon block_users" href="">Lock users</a></li>
                        </ul>
                    </div>
                    <div class="box">
                        <div class="h_title">&#8250; Settings</div>
                        <ul>
                            <li class="b1"><a class="icon config" href="">Site configuration</a></li>
                            <li class="b2"><a class="icon contact" href="">Contact Form</a></li>
                        </ul>
                    </div>
                </div>
                <div id="main">
                    <div class="full_w">
                        <div class="h_title">Manager Warehourses Page</div>
                        <h2>Manager Warehourses Page</h2>
                        <div>
                            <form method="get">
                                <div style="float: right;margin-right: 5px">
                                    <a>Category</a><select name="category" id="filterCategory"></select><a>Name</a><input type="search" name="name" value="<d:property value="name"/>"/><input type="submit" value="Search" />
                                </div>
                            </form>
                        </div>
                        <div class="entry">
                            <div class="sep"></div>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Address</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Email</th>
                                    <th scope="col" style="width: 65px;">Modify</th>
                                </tr>
                            </thead>

                            <tbody>
                                <d:iterator value="list">
                                    <tr>
                                        <td class="align-center"><d:property value="id"/></td>
                                        <td class="align-center"><d:property value="name"/></td>
                                        <td class="align-center"><d:property value="address"/></td>
                                        <td class="align-center"><d:property value="phone"/></td>
                                        <td class="align-center"><d:property value="email"/></td> 
                                        <td>
                                            <a href="#" class="table-icon edit" item_id="<d:property value="id"/>" title="Edit"></a>
                                            <a href="#" class="table-icon archive" item_id="<d:property value="id"/>" title="Archive"></a>
                                            <a href="#" class="table-icon delete" item_id="<d:property value="id"/>" title="Delete"></a>
                                        </td>
                                    </tr>
                                </d:iterator>

                            </tbody>
                        </table>
                        <div class="entry">
                            <div class="pagination">
                                <span>« First</span>
                                <span class="active">1</span>
                                <a href="">2</a>
                                <a href="">3</a>
                                <a href="">4</a>
                                <span>...</span>
                                <a href="">23</a>
                                <a href="">24</a>
                                <a href="">Last »</a>
                            </div>
                            <div class="sep"></div>		
                            <a class="button add" href="">Add new page</a> <a class="button" href="">Categories</a> 
                        </div>
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