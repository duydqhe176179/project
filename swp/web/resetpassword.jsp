<%-- 
    Document   : login
    Created on : Jan 8, 2024, 9:26:26 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style_1.css"/>
    </head>
    <body>
        <div class="wapper">
            <form action="signin" method="get">
                <h1>Reset Password</h1>
                <p style="text-align: center;">If you've forgotten your password, enter your account and email</p>
                <div class="input-box">
                    <input type="text" id="aname" name="accountname" placeholder="Account name" required>   
                </div>    
                <div class="input-box">
                    <input type="email" id="email" name="emailaddress" placeholder="Email address" required>   
                </div> 
                
                <button class="button" type="submit" name="signup">
                    Enter
                </button>
               
            </form>

        </div>
    </body>
</html>