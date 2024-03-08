<%-- 
    Document   : statisticreq
    Created on : Feb 5, 2024, 11:12:34 PM
    Author     : ADMIN
--%>

<%-- 
    Document   : listallreq
    Created on : Jan 18, 2024, 11:43:47 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <title>List of Requests</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            header {
                background-color: #3931af;
                color: #fff;
                padding: 10px;
                text-align: center;
            }

            section {
                margin: 20px;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }

            th {
              background-color: #48CEFA;
                color: #fff;
            }

            .btn-container {
                margin-top: 10px;
            }

            .update-btn, .delete-btn {
                padding: 8px 16px;
                margin-right: 10px;
                cursor: pointer;
            }

            .update-btn {
                background-color: #4caf50;
                color: #fff;
                border: none;
            }

            .delete-btn {
                background-color: #f44336;
                color: #fff;
                border: none;
            }
        </style>
    </head>
    <body>

        <header  style="background: #48CEFA;margin: 20px;">
            <!--            <h1>List of Requests</h1>-->
            <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
                <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
                Home
            </a>
            <h1 style="margin-left: auto; padding-bottom: 20px;">Statistic of Requests</h1>
        </header>

        <section>
            <table  border="1" style="margin:auto">
                <thead style="border: 1px solid black; background:#48CEFA;">
                    <tr>
                        <th  style="width: 10%;text-align: center;">Title</th>
                        <th  style="width: 10%;text-align: center;">Skills</th>
                        <th  style="width: 10%;text-align: center;">Description</th>
                        <th  style="width: 10%;text-align: center;">Deadline Date</th>
                        <th  style="width: 10%;text-align: center;">Deadline Hour</th>
                        <th  style="width: 10%;text-align: center;">Status</th>

                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="request" items="${listReq}">
                        <tr>
                            <td  style="width: 10%;text-align: center;">${request.title}</td>
                            <td  style="width: 10%;text-align: center;">${request.skill}</td>
                            <td  style="width: 10%;text-align: center;">${request.content}</td>
                            <td  style="width: 10%;text-align: center;">${request.deadline}</td>
                            <td  style="width: 10%;text-align: center;">${request.hour}</td>
                            <td  style="width: 10%;text-align: center;">${request.status}</td>

                        </tr>

                    </c:forEach>
                    
                       
                    <tr>
                        <td style="width: 10%;text-align: center;">Total Request: </td>
                        <td style="width: 10%;text-align: center;">${totalRequests}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>
                            <!-- First empty column -->

                            <!-- Second empty column -->

                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%;text-align: center;">Total Hour: </td>
                        <td style="width: 10%;text-align: center;">${totalHours}</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <td style="width: 10%;text-align: center;">Mentor Name: </td>
                        <c:forEach var="entry" items="${mentorNames}">
                        <td style="width: 10%;text-align: center;">${entry.value}</td>
                        </c:forEach>
                        <td></td>
                        <td></td>
                        
                        
                    </tr>
                    <tr>
                        <td style="width: 10%;text-align: center;">Total Request send to Mentor: </td>
                        <c:forEach var="entry" items="${mentorCounts}">
                        <td style="width: 10%;text-align: center;">${entry.value}</td>
                        </c:forEach>
                        <td></td>
                        <td></td>
                        
                    </tr>
                    <!-- Add more rows as needed -->
                </tbody>
            </table>
        </section>

    </body>
</html>

