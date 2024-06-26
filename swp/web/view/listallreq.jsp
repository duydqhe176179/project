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
        <!-- Bootstrap core CSS -->
        <link href="assets/bootstrap.min.css" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="assets/jumbotron-narrow.css" rel="stylesheet">
        <link href="https://pay.vnpay.vn/lib/vnpay/vnpay.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <title>List of Requests</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
        <link rel="stylesheet" href="assets/css/animated.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.9/css/all.css" integrity="sha384-5SOiIsAziJl6AWe0HWRKTXlfcSHKmYV4RBF18PPJ173Kzn7jzMyFuTtk8JA7QQG1"
              crossorigin="anonymous" />
        <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }

            header {
                /*                background-color: #3931af;*/
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
               background: lightblue;
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
              .rate{
                padding: 8px;
                border-radius: 2px;
            }
        </style>

        <jsp:include page="../header.jsp"></jsp:include>
        </head>
        <body>
            <br/><!-- comment -->
            <br/>
            <header>
                <!--            <h1>List of Requests</h1>-->
                <!--                <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
                                    <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
                                    Home
                                </a>-->
                <h1 style="margin-left: auto; padding-bottom: 20px; color: #000;">List of Requests</h1>
            </header>

            <section>
                <table border="1" style="margin:auto">
                    <thead style="border: 1px solid black; background:#48CEFA;">
                        <tr>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Title</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Skills</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Description</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Start Learn</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Day Complete</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Total learn hour</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Status</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Total money</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Actions</th>
                            <th style="width: 10%;text-align: center;font-size: 15px;">Report</th>

                        </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="request" items="${listReq}">
                        <tr>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.title}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.skill}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.content}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.startDate}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.endDate}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.hour}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.status}</td>
                            <td style="width: 10%;text-align: center;font-size: 15px;">${request.getTotalCost()}</td>
                            <c:if test="${request.status eq 'Open' || request.status eq 'Rejected'}">
                                <td class="btn-container" style="width: 10%;text-align: center;">
                                    <button class="rate" > <a href="updatereq?idrequest=${request.idRequest} " class="rate-link">Update</a></button>
                                </td>
                            </c:if>         
                            <c:if test="${request.status == 'Accepted'}">
                        <form id="paymentForm" action="vnpay" method="post">
                            <input type="hidden" name="requestid" value="${request.idRequest}">
                            <td style="width: 10%; text-align: center;">
                                <button class="btn btn-default" type="submit">Payment</button>
                            </td>
                        </form>
                    </c:if>
                    <c:if test="${request.status eq 'Completed'}">
                        <td class="btn-container" style="width: 10%;text-align: center;">
                            <a href="rate?idrequest=${request.idRequest}&idMentor=${request.idMentor}&idMentee=${request.idMentee}" class="btn btn-lg btn-primary">Finish</a>
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
                        <div style="margin: 20px; font-size: 15px;">To continue learning, please click here <a id="reportLink" href="#">Click</a></div>

                        <select name="badreport" id="badreport" style="font-size: 15px; text-align: center; margin:20px;">
                            <option value="Poor quality">Poor quality</option>
                            <option value="The Mentor lacks unprofessional skills">The Mentor lacks unprofessional skills</option>
                            <option value="Teaching is not on time">Teaching is not on time</option>
                            <option value="Others">Others</option>
                        </select>
                        <div class="notice"> <i>Note: If you still have problems, please leave your phone number and personal information so we can discuss</i></div>
                        <textarea id="auto-resize-textarea" name="reasonReport" spellcheck="false" placeholder="Type something here..." required></textarea>
                        <br>
                        <div class="button "style="text-align: center;">
                            <button style="background-color: #28a745; margin: 10px; padding: 8px;" type="submit">Submit</button>
                            <button style="background-color: #dc3545; margin: 10px; padding: 8px;" type="button" onclick="cancelRejectForm()">Cancel</button>
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
        <jsp:include page="../footer.jsp"></jsp:include>
        <script src="assets/jquery-1.11.3.min.js"></script>
        <script src="https://pay.vnpay.vn/lib/vnpay/vnpay.min.js"></script>
        <script type="text/javascript">
                                $("#paymentForm").submit(function () {
                                    var postData = $("#paymentForm").serialize();
                                    var submitUrl = $("#paymentForm").attr("action");
                                    $.ajax({
                                        type: "POST",
                                        url: submitUrl,
                                        data: postData,
                                        dataType: 'JSON',
                                        success: function (x) {
                                            if (x.code === '00') {
                                                if (window.vnpay) {
                                                    vnpay.open({width: 768, height: 600, url: x.data});
                                                } else {
                                                    location.href = x.data;
                                                }
                                                return false;
                                            } else {
                                                alert(x.Message);
                                            }
                                        }
                                    });
                                    return false;
                                });
        </script>   
        <script>
            function showRePortForm(idRequest, idMentor) {
                document.getElementById('idRequest').value = idRequest;
                document.getElementById('idMentor').value = idMentor;
                document.querySelector('.wrapper').style.display = 'block';
                var reportLink = document.getElementById('reportLink');

                // Update the href attribute of the report link
                reportLink.href = 'Request?action=create&idMentor=' + idMentor;

            }

            function cancelRejectForm() {
                // Hide reject popup form
                document.querySelector('.wrapper').style.display = 'none';
            }

            const textarea = document.getElementById("auto-resize-textarea");
            textarea.addEventListener("input", function () {
                this.style.height = "auto";
                this.style.height = (this.scrollHeight) + "px";
            });
        </script>

    </body>
</html>
