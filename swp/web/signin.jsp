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
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="wapper">
            <form action="signin" method="get">
                <h1>Sign in</h1>
                <div class="input-box">
                    <input type="text" id="uname" name="username" placeholder="Username" required>   
                </div>    
                <div class="input-box">
                    <input type="password" id="pass" name="password" placeholder="Password" required>   
                </div> 
                <div class="remember">
                    <label><input type="checkbox"  name="remember pass" >Remember password</label> 
                    <a><a href="changepass.jsp" >Change password</a>

                </div>

                <button class="button" type="submit" name="signup">
                    LOGIN
                </button>
                <div class="resiter-link">
                    <p>Don't have an account? </p>
                    <a ><a href="#" >Register</a>
                </div>

            </form>

        </div>
    </body>
</html>
