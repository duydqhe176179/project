<%-- 
    Document   : changepass
    Created on : Jan 9, 2024, 4:18:02 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="style.css"/>
    </head>
    <body>

        <div class="wapper"> 
            <form action="changepass" method="get">
                <h1>Change Password</h1>
                <p style="text-align: center;">Please enter your user name and password</p>

                <div class="input-box">
                    <input type="text" id="aname" name="accountname" placeholder="Account Name" required>   
                </div>
                <div class="input-box">
                    <input type="password" id="pass" name="oldpassword" placeholder="Old Password" required>   
                </div>
                <div class="input-box">
                    <input type="password" id="npass" name="newpassword" placeholder="New Password" required>   
                </div>
                <div class="input-box">
                    <input type="password" id="confirm" name="confirm " placeholder="Confirm new password" required>   
                </div>
                <button class="button" type="submit" name="signup">
                    Change Password
                </button>
                <div class="resiter-link">

                    <a href="signin.jsp" style="margin-left: 30px;" >Sign in</a>
                </div>
            </form>

        </div>




    </body>
</html>
