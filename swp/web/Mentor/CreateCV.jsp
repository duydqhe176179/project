<%-- 
    Document   : CreateCV
    Created on : Jan 18, 2024, 10:09:37 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"  type="text/css" href="../css/style_3.css"/>
         <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_3.css"/>
    </head>
    <body>
       <div class="container">
      <div class="text">
         Create CV Mentor   
      </div>
      <form action="#">
         <div class="form-row">
            <div class="input-data">
               <input type="text" required>
               <div class="underline"></div>
               <label for="">Full Name</label>
            </div>
            <div class="input-data">
               <input type="text" required>
               <div class="underline"></div>
               <label for="">Email</label>
            </div>
         </div>
         <div class="form-row">
            <div class="input-data">
               <input type="text" required>
               <div class="underline"></div>
               <label for="">Profession</label>
            </div>
            <div class="input-data">
               <input type="text" required>
               <div class="underline"></div>
               <label for="">Phone</label>
            </div>
         </div>
         <div class="form-row">
         <div class="input-data textarea">
            <textarea rows="8" cols="80" required></textarea>
            <br />
            <div class="underline"></div>
            <label for="">Write your message</label>
            <br />
            <div class="form-row submit-btn">
               <div class="input-data">
                  <div class="inner"></div>
                  <input type="submit" value="submit">
               </div>
            </div>
      </form>
      </div>
    </body>
</html>
