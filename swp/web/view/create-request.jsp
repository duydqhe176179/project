<%@ page import="java.util.List" %>
<%@ page import="dal.ViewStatisticRequestDAO" %>
<%@ page import="model.Mentor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <style>
            form {
                max-width: 500px;
                margin: 0 auto;
                padding: 50px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            label {
                display: block;
                margin-bottom: 5px;
            }

            input[type="text"],
            input[type="date"],
            textarea {
                width: 100%;
                padding: 5px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            select {
                width: 100%;
                padding: 5px;
                border-radius: 3px;
            }

            input[type="submit"] {
                margin-top: 10px;
                background-color: #4CAF50;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                float: right;
            }

            input[type="submit"]:hover {
                margin-top: 20px;
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <h2>Create Request</h2>

        <form action="createRequest" method="post">



            <label for="mentor">Select Mentor:</label>
            <select id="mentor" name="idMentor">
                <c:forEach var="mentorItem" items="${listMentor}">
                    <option value="${mentorItem.idMentor}">${mentorItem.fullname}</option>
                </c:forEach>
            </select>

            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="content">Content:</label>
            <textarea id="content" name="content" required></textarea>

            <label for="deadlineDate">Deadline Date:</label>
            <input type="date" id="deadlineDate" name="deadlineDate" required>


            <label for="deadlineHour">Deadline Hour:</label>
            <input type="text" id="deadlineHour" name="deadlineHour" required>

            <div class="form-group">
                <label for="skills">Select Skills (1-3):</label><br>
                <label class="checkbox-inline">
                    <input type="checkbox" name="skills" value="Java"> Java
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" name="skills" value="Python"> Python
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" name="skills" value="NodeJS"> NodeJS
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" name="skills" value="C++"> C++
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" name="skills" value="C#"> C#
                </label>
                <label class="checkbox-inline">
                    <input type="checkbox" name="skills" value="React"> React
                </label>
                <!-- Add more skills as needed -->
            </div>
            
        <div class="container mt-3">
            <c:if test="${param.success != null}">
                <div class="alert alert-success" role="alert">
                    Create successful!
                </div>
            </c:if>
            <c:if test="${param.fail != null}">
                <div class="alert alert-danger" role="alert">
                    Create failed. Please try again.
                </div>
            </c:if>
        </div>

            <input type="submit" value="Create Request">
        </form>

    </body>
</html>
