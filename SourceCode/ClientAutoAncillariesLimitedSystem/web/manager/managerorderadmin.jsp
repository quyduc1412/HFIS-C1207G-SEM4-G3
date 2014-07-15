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
        <title>Manager Employee Page</title>
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
        <script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine.js" type="text/javascript"></script>
        <link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
        <script src="js/model/reponse.js" type="text/javascript"></script>
        <link href="themes/smoothness/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="jquery-ui-1.11.0/jquery-ui.min.js" type="text/javascript"></script>
        <link href="jquery-ui-1.11.0/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/view/managerorder.js" type="text/javascript"></script>  
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
                <%@include file="navigation.jsp" %>
            </div>
            <div id="content">
                <div id="main" style="width: 100% !important">
                    <div class="full_w">
                        <div class="h_title">Manager Order</div>
                        <h2>Manager Employee Page</h2>
                        <div>
                            <form method="get">
                                <div style="float: right;margin-right: 5px">
                                    <a>From</a><input name="datefrom" type="text" id="datefrom" value="<d:property value="datefrom"/>"/>
                                    <a>To</a><input name="dateto" type="text" id="dateto" value="<d:property value="dateto"/>"/>
                                    <a>Name</a><select name="status"><option value="-1">All</option><option value="0">Pending</option><option value="1">Watting</option><option value="2">Completed</option></select><input type="submit" value="Search" />
                                </div>
                            </form>
                        </div>
                        <div class="entry">
                            <div class="sep"></div>
                        </div>
                        <table style="width: 100% !important;margin:0px !important">
                            <thead>
                                <tr>
                                    <th scope="col">ID Order</th>
                                    <th scope="col">Warehouse</th>
                                    <th scope="col">Date Order</th>
                                    <th scope="col">Customer</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Detail</th>
                                </tr>
                            </thead>

                            <tbody>
                                <d:iterator value="list">
                                    <tr>
                                        <td class="align-center full-order" idcustomer="<d:property value="customer.id"/>" status="<d:property value="statusString"/>" idorder="<d:property value="id"/>"><a href="#">Order ID <d:property value="id"/></a></td>
                                        <td class="align-center warehouse-details" idname="<d:property value="wareHouses.id"/>"><a href="#"><d:property value="wareHouses.name"/></a></td>
                                        <td class="align-center"><d:property value="dateOrder"/></td>
                                        <td class="align-center customer-detail" idname="<d:property value="customer.id"/>"><a href="#"><d:property value="customer.email"/><a class="table-icon archive" title="Archive"></a></a></td>
                                        <td class="align-center details-status" idname="<d:property value="id"/>" ><a href="#"><d:property value="statusString"/><a class="table-icon edit" title="Edit"></a></a></a></td>
                                        <td class="align-center details-order" idname="<d:property value="id"/>"><a href="#">Detail</a><a class="table-icon archive" title="Archive"></a></td> 
                                    </tr>
                                </d:iterator>

                            </tbody>
                        </table>
                        <div class="entry">
                            <div class="sep">
                                <d:property value="pagecontent" escape="false"/>
                            </div>		
                        </div>
                    </div>
                </div>
                <div class="clear"></div>
            </div>

            <div id="footer">
                <div class="left">
                    <p>Design: <a href="">Paweł Balicki</a> | Admin Panel: <a href="">YourSite.com</a></p>
                </div>
                <div class="right">
                    <p><a href="">Example link 1</a> | <a href="">Example link 2</a></p>
                </div>
            </div>
        </div>

    </body>
</html>
