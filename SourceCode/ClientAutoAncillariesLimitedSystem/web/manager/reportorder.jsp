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
        <title>Report Order</title>
        <link rel="shortcut icon" href="img/au-icon.png">
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
        <script src="js/view/report.js" type="text/javascript"></script>
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
                        <div class="h_title">Report Order</div>
                        <h2>Report Order</h2>
                        <div>
                            <form method="get">
                                <div style="float: right;margin-right: 5px">
                                    <!--<a>Warehouse</a><select id="warehouse" name="warehouse"></select>-->
                                    <a>From</a><input name="datefrom" type="text" id="datefrom" value="<d:property value="datefrom"/>"/>
                                    <a>To</a><input name="dateto" type="text" id="dateto" value="<d:property value="dateto"/>"/>
                                    <input type="submit" value="Search" />
                                </div>
                            </form>
                        </div>
                        <div class="entry">
                            <div class="sep"></div>
                        </div>
                        <table style="width: 100% !important;margin:0px !important">
                            <thead>
                                <tr>
                                    <th scope="col">Warehouse</th>
                                    <th scope="col">Pending Order</th>
                                    <th scope="col">Cancel Order</th>
                                    <th scope="col">Completed Order</th>
                                    <th scope="col">Total Order</th>
                                </tr>
                            </thead>

                            <tbody>
                                <d:iterator value="list">
                                    <tr>
                                        <td class="align-center full-order warehouse-details" idname="<d:property value="id"/>"> <a href="#"><d:property value="name"/></a></td>
                                        <td class="align-center full-order"> <a href="#"><d:property value="pendingOrder"/></a></td>
                                        <td class="align-center full-order"> <a href="#"><d:property value="cancelOrder"/></a></td>
                                        <td class="align-center full-order"> <a href="#"><d:property value="completeOrder"/></a></td>
                                        <td class="align-center full-order"> <a href="#"><d:property value="totalOrder"/></a></td>
                                    </tr>
                                </d:iterator>
                                    <tr style="border-style:solid; border-top:thick double #404345;">
                                        <td class="align-center full-order">Total</td>
                                        <td class="align-center full-order"><d:property value="pendingOrder"/></td>
                                        <td class="align-center full-order"><d:property value="cancelOrder"/></td>
                                        <td class="align-center full-order"><d:property value="completedOrder"/></td>
                                        <td class="align-center full-order"><d:property value="totalOrder"/></td>
                                    </tr>
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
                    <p>Design: <a href="http://kilab.pl">Paweł Balicki</a> | Admin Panel: <a href="">YourSite.com</a></p>
                </div>
                <div class="right">
                    <p><a href="">Example link 1</a> | <a href="">Example link 2</a></p>
                </div>
            </div>
        </div>

    </body>
</html>
