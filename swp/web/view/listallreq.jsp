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
            .rate-link {
                text-decoration: none;
                font-size: 20px;
            }

            .wrapper{
                width: 470px;
                background: #ddd;
                border-radius: 5px;
                padding: 25px 25px 30px;
                box-shadow: 8px 8px 10px rgba(0,0,0,0.06);
                margin-top: 10px;
                margin-left: 36%;
                margin-bottom: 20px;
            }
            .wrapper h2{
                color: #4671EA;
                font-size: 28px;
                text-align: center;
            }
            .wrapper textarea{
                width: 80%;
                resize: none;
                height: 59px;
                outline: none;
                padding: 15px;
                font-size: 16px;
                margin-top: 20px;
                border-radius: 5px;
                max-height: 330px;
                caret-color: #4671EA;
                border: 1px solid #bfbfbf;
                padding-right: 0px;
                padding-left: 2px;
            }
            textarea::placeholder{
                color: #b3b3b3;
            }
            textarea:is(:focus, :valid){
                padding: 14px;
                border: 2px solid #4671EA;
            }
            textarea::-webkit-scrollbar{
                width: 0px;
            }
            .notice{
                font-size: 15px;
                color: red;

            }
        </style>
    </head>
    <body>

        <header style="background: #48CEFA;margin: 20px;">
            <!--            <h1>List of Requests</h1>-->
            <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
                <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
                Home
            </a>
            <h1 style="margin-left: auto; padding-bottom: 20px;">List of Requests</h1>
        </header>

        <section>
            <table border="1" style="margin:auto">
                <thead style="border: 1px solid black; background:#48CEFA;">
                    <tr>
                        <th style="width: 10%;text-align: center;">Title</th>
                        <th style="width: 10%;text-align: center;">Skills</th>
                        <th style="width: 10%;text-align: center;">Description</th>
                        <th style="width: 10%;text-align: center;">Start Learn</th>
                        <th style="width: 10%;text-align: center;">Day Complete</th>
                        <th style="width: 10%;text-align: center;">Total learn hour</th>
                        <th style="width: 10%;text-align: center;">Status</th>
                        <th style="width: 10%;text-align: center;">Total money</th>
                        <th style="width: 10%;text-align: center;">Actions</th>
                        <th style="width: 10%;text-align: center;">Report</th>

                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="request" items="${listReq}">
                        <tr>
                            <td style="width: 10%;text-align: center;">${request.title}</td>
                            <td style="width: 10%;text-align: center;">${request.skill}</td>
                            <td style="width: 10%;text-align: center;">${request.content}</td>
                            <td style="width: 10%;text-align: center;">${request.startDate}</td>
                            <td style="width: 10%;text-align: center;">${request.endDate}</td>
                            <td style="width: 10%;text-align: center;">${request.hour}</td>
                            <td style="width: 10%;text-align: center;">${request.status}</td>
                            <td style="width: 10%;text-align: center;">${request.getTotalCost()}</td>
                            <c:if test="${request.status eq 'Open' || request.status eq 'Rejected'}">
                                <td class="btn-container" style="width: 10%;text-align: center;">
                                    <button class="rate" > <a href="updatereq?idrequest=${request.idRequest} " class="rate-link">Update</a></button>
                                </td>
                            </c:if>         
                            <c:if test="${request.status == 'Accepted'}">
                                <td style="width: 10%;text-align: center;">
                                    <button class="rate"> <a class="rate-link" href="payment?idrequest=${request.idRequest}">Payment</a></button>   
                                </td>
                            </c:if>
                            <c:if test="${request.status eq 'Completed'}">
                                <td style="width: 10%;text-align: center;">
                                    <button class="rate" onclick="hideRateButton(this)"><a href="rate?idrequest=${request.idRequest}&idMentor=${request.idMentor}&idMentee=${request.idMentee}" class="rate-link">Rate</a></button>
                                </td>
                            </c:if>
                            <td>
                                <c:if test="${request.status == 'Completed'}">
                                    <button class="rate"><a onclick="showRePortForm(${request.idRequest},${request.idMentor});" >
                                            Report
                                        </a></button>
                                    </c:if>
                            </td>
                        </tr>
                    </c:forEach>

                    <!-- Add more rows as needed -->
                </tbody>
                <form id="ReportForm" method="get" action="ReportListall">
                    <input type="text" id="idRequest" name="idRequest"  style="display: none"> 
                    <input type="text" id="idMentor" name="idMentor"  style="display: none"> 
                    <div class="wrapper" style="display:none; text-align: center;" >
                        <h2>Create Report</h2>
                        <div style="margin: 20px;">To continue learning, please click here <a id="reportLink" href="#">Click</a></div>

                        <select name="badreport" id="badreport" style="font-size: larger; text-align: center; margin:20px;">
                            <option value="Poor quality">Poor quality</option>
                            <option value="The Mentor lacks unprofessional skills">The Mentor lacks unprofessional skills</option>
                            <option value="Teaching is not on time">Teaching is not on time</option>
                            <option value="Others">Others</option>
                        </select>
                        <div class="notice"> <i>Note: If you still have problems, please leave your phone number and personal information so we can discuss</i></div>
                        <textarea id="auto-resize-textarea" name="reasonReport" spellcheck="false" placeholder="Type something here..." required></textarea>
                        <br>
                        <div class="button "style="text-align: center;">
                            <button style="background-color: #28a745; margin: 10px;" type="submit">Submit</button>
                            <button style="background-color: #dc3545; margin: 10px;" type="button" onclick="cancelRejectForm()">Cancel</button>
                        </div>
                    </div>
                    <c:if test="${msg != null}">
                        <div class="alert alert-success" role="alert">
                            Create successful!
                        </div>
                    </c:if>
                    <c:if test="${param.fail != null}">
                        <div class="alert alert-danger" role="alert">
                            Create failed. Please try again.
                        </div>
                    </c:if>
                </form>
            </table>
        </section>

        <script>
            function showRePortForm(idRequest, idMentor) {
                document.getElementById('idRequest').value = idRequest;
                document.getElementById('idMentor').value = idMentor;
                document.querySelector('.wrapper').style.display = 'block';
                var reportLink = document.getElementById('reportLink');

                // Update the href attribute of the report link
                reportLink.href = 'Request?action=create&idMentor=' + idMentor;

            }



            const textarea = document.getElementById("auto-resize-textarea");
            textarea.addEventListener("input", function () {
                this.style.height = "auto";
                this.style.height = (this.scrollHeight) + "px";
            });
        </script>
    </body>
</html>
