<%-- 
    Document   : test
    Created on : Jan 9, 2024, 11:52:18 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table border="1">
            <tr>
                <th>username</th>
                <th>password</th>
                <th>role</th>
            </tr>
            <c:forEach items="${listAccount}" var="e">
                <tr>
                    <td>${e.getUser()}</td>
                    <td>${e.getPass()}</td>
                    <td>${e.getRole()}</td>
                    

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
