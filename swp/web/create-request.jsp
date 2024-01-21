<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Create Request</title>
        <!-- Bootstrap CSS link -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>

        <div class="container mt-5">
            <form action="Request" method="post">

                <input type="hidden" name="action" value="create">

                <div class="row">
                    <div class="col-md-8 offset-md-2">
                        <div class="card">
                            <div class="card-header">
                                <h1 class="text-center">Create Request</h1>
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

                            <div class="card-body">

                                <div class="form-group">
                                    <label for="idMentor">Select Mentor:</label>
                                    <select class="form-select" name="idMentor" required>
                                        <c:forEach var="mentor" items="${listMentor}">
                                            <option value="${mentor.idMentor}">${mentor.fullname}</option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <label for="title">Title (Subject) of Request:</label>
                                    <input type="text" class="form-control" name="title" required>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="deadlineDate">Deadline Date:</label>
                                        <input type="date" class="form-control" name="deadlineDate" required>
                                    </div>
                                    <!--                                    <div class="form-group col-md-6">
                                                                            <label for="deadlineHour">Deadline Hour:</label>
                                                                            <input type="time" class="form-control" name="deadlineHour" required>
                                                                        </div>-->
                                </div>

                                <div class="form-group">
                                    <label for="content">Content of Request:</label>
                                    <textarea class="form-control" name="content" rows="4" required></textarea>
                                </div>

                                <div class="form-group">
                                    <label for="skills">Select Skills:</label><br>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="skills" value="Java"> Java
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="skills" value="Python"> Python
                                    </label>
                                    <label class="checkbox-inline">
                                        <input type="checkbox" name="skills" value="JavaScript"> JavaScript
                                    </label>
                                    <!-- Add more skills as needed -->
                                </div>

                                <button class="btn btn-primary btn-block" type="submit" name="createRequest">
                                    OK
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    </body>
</html>