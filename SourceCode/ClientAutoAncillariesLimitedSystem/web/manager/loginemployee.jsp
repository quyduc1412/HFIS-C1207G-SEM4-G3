<%-- 
    Document   : loginemployee
    Created on : Jul 11, 2014, 8:58:05 AM
    Author     : Duc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pl" xml:lang="pl">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <meta name="author" content="Paweł 'kilab' Balicki - kilab.pl" />
        <title>SimpleAdmin</title>
        <link rel="stylesheet" type="text/css" href="css/login.css" media="screen" />
        <link href="js/uploadfile.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery1.9.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.json-2.4.js" type="text/javascript"></script>
        <script src="js/jquery.uploadfile.min.js" type="text/javascript"></script>
        <script src="js/classy.min.js" type="text/javascript"></script>
        <script src="js/model.js" type="text/javascript"></script>
        <script src="js/service.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine-en.js" type="text/javascript"></script>
        <script src="js/jquery.validationEngine.js" type="text/javascript"></script>
        <link href="css/validationEngine.jquery.css" rel="stylesheet" type="text/css"/>
        <script src="js/model/reponse.js" type="text/javascript"></script>
        <script src="js/loginemployee.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="message" style="width: 100%;height: auto;position: fixed;text-align: center;font-size: xx-large;background-color: #0ba1b5;color: white;top: 0;"></div>
        <div class="wrap">
            <div id="content">
                <div id="main">
                    <div class="full_w">
                        <form action="" method="post">
                            <label for="login">Username:</label>
                            <input id="login" name="login" class="text" />
                            <label for="pass">Password:</label>
                            <input id="pass" name="pass" type="password" class="text" />
                            <div class="sep"></div>
                            <button id="submit-login" type="submit" class="ok">Login</button> <a class="button" href="">Forgotten password?</a>
                        </form>
                    </div>
                    <div class="footer">&raquo; <a href="">http://yourpage.com</a> | Admin Panel</div>
                </div>
            </div>
        </div>

    </body>
</html>

