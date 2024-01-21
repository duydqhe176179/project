<%-- 
    Document   : confirmAccount
    Created on : Jan 14, 2024, 3:23:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Click here to send Email
        <form action="sendEmailVerify" method="post">
            <input type="submit" value="Send Email">
        </form>
        Please confirm your account.<br>
        Please enter OTP to confirm your account:
        <form action="confirm" method="post">
            <input type="text" name="verify" value=${verify}>
            <input type="text" name="confirm" placeholder="Enter here">
            <input type="submit">
        </form>
            ${mess}
    </body>
</html>
