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
        <script src="js/jquery.json-2.4.js" type="text/javascript"></script>
        <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
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
        <script src="js/view/item.js" type="text/javascript"></script>
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
            }
        </style>
    </head>
    <body>
        <div id="message" style="width: 100%;height: 30px;position: fixed"></div>
        <div id="overlay">
            <div class="half_w dialog additem">
                <div class="h_title">Add new page - form elements<a id="id"></a></div>
                <form action="" method="post">
                    <div class="element">
                        <label for="name">Name <span class="red">(required)</span></label>
                        <input id="name" name="name" class="text err">
                    </div>
                    <div class="element">
                        <label for="category">Category <span class="red">(required)</span></label>
                        <select name="category" class="err" id="category">
                        </select>
                    </div>
                    <div class="element">
                        <label for="price">Price <span class="red">(required)</span></label>
                        <input id="price" name="price" class="text err">
                    </div>
                    <div class="element">
                        <label for="attach">Attachments</label>
                        <input type="file" name="attach">
                    </div>
                    <div class="element">
                        <label for="content">Description <span>(required)</span></label>
                        <textarea name="content" class="textarea" rows="10" id="desciption"></textarea>
                    </div>
                    <div class="entry">
                        <button type="submit" class="add">Save page</button> <button class="cancel">Cancel</button>
                    </div>
                </form>
            </div>
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
                        <div class="h_title">Manage pages - table</div>
                        <h2>Lorem ipsum dolor sit ame</h2>
                        <p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumyeirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diamvolupt</p>

                        <div class="entry">
                            <div class="sep"></div>
                        </div>
                        <table>
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Date Created</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Price</th>
                                    <th scope="col" style="width: 65px;">Modify</th>
                                </tr>
                            </thead>

                            <tbody>
                                <d:iterator value="litstItem">
                                    <tr>
                                        <td class="align-center"><d:property value="id"/></td>
                                        <td><d:property value="name"/></td>
                                        <td><d:property value="description"/></td>
                                        <td><d:property value="date_Created"/></td>
                                        <td class="align-center"><d:property value="typeItem.nameType"/></td>
                                        <td><d:property value="price"/></td>
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
