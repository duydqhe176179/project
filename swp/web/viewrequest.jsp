<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Requests</title>
        <link rel="stylesheet" href="css/viewrequestmentor.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <style>
            /* Import Google font - Poppins */
            @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: "Poppins", sans-serif;
            }

            ::selection{
                color: #fff;
                background: #4671EA;
            }
            .wrapper{
                width: 470px;
                background: #edf4f0;
                border-radius: 5px;
                padding: 25px 25px 30px;
                box-shadow: 8px 8px 10px rgba(0,0,0,0.06);
                margin-top: 40px;
                margin-left: 36%;
            }
            .wrapper h2{
                color: #4671EA;
                font-size: 28px;
                text-align: center;
            }
            .wrapper textarea{
                width: 100%;
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
            .button button{
                text-align: center;
                color: white;
                border-radius: 3px;
                padding: 10px 20px;
                border: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <div style="background-color: #3BB3F6; text-align: left; padding: 10px; margin-bottom: 20px;">
            <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
                <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
            </a>
            <h1 style="text-align: center;">View List Requests</h1>
        </div>
        <h1 style="color: Red; text-align: center;">${errorMessage}</h1>
        <h1 style="color: Red; text-align: center;">${error}</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Full Name</th>
                    <th>Title</th>
                    <th>Content of request</th>
                    <th>Start Date</th>
                    <th>Deadline Date</th>
                    <th style="width:40px;">Deadline Hour (h)</th>
                    <th>Skills</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody style="text-align: center;">
                <c:forEach var="a" items="${listR}">
                    <tr style="height: 10%;">
                        <td>${a.fullname}</td>
                        <td>${a.title}</td>
                        <td>${a.content}</td>
                        <td>${a.startDate}</td>
                        <td>${a.deadline}</td>
                        <td>${a.hour}</td>
                        <td>${a.skill}</td>
                        <td>${a.status}</td>
                        <td class="btn-container">
                            <button onclick="showRejectForm(${a.idRequest});" style="background-color: #DE3E44; border-radius: 5px; border: none; height: 30px; width: 60px; margin-left: 5px;">
                                <a style="text-decoration: none; color: white;" href="">Reject</a>
                            </button>
                            <button onclick="confirmAccept(${a.idRequest});" style="background-color: #1BA345; border-radius: 5px; border: none; height: 30px; width: 60px">
                                <a style="text-decoration: none; color: white;" href="">Accept</a>
                            </button>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
        <form id="rejectForm" method="post" action="reasonreject">
            <input type="text" id="idRequest" name="idRequest" style="display: none"> <!-- Input hidden để lưu idRequest -->
            <div class="wrapper" style="display:none;">
                <h2>Reason Reject</h2>
                <textarea id="auto-resize-textarea" name="reasonReject" spellcheck="false" placeholder="Type something here..." required></textarea>
                <br>
                <div class="button "style="text-align: center;">
                    <button style="background-color: #28a745; margin: 0 5px;" type="submit">Submit</button>
                    <button style="background-color: #dc3545;" type="button" onclick="cancelRejectForm()">Cancel</button>
                </div>
            </div>
        </form>

        <script>
            function showRejectForm(idRequest) {
                console.log("Show Reject Form function called with idRequest:", idRequest);
                // Set idRequest value
                document.getElementById('idRequest').value = idRequest;
                // Show reject popup form
                document.querySelector('.wrapper').style.display = 'block';

                // Set onclick event for the confirmReject button
                document.querySelector('.button button[type="submit"]').setAttribute('onclick', 'confirmReject(' + idRequest + ')');
            }

            function cancelRejectForm() {
                // Hide reject popup form
                document.querySelector('.wrapper').style.display = 'none';
            }

            // Function to submit the reject form
            document.getElementById('rejectForm').addEventListener('submit', function (event) {
                event.preventDefault(); // Prevent form submission
                // Perform actions you need here, for example, submit the form via AJAX
                // Then, hide the form
                document.querySelector('.wrapper').style.display = 'none';
            });

            function confirmAccept(idRequest) {
                if (confirm('Are you sure you want to accept this request?')) {
                    // If user clicks OK, redirect to the accept servlet
                    window.location.href = 'accept?idRequest=' + idRequest + '&action=accept';
                }
            }

            function confirmReject(idRequest) {
                if (confirm('Are you sure you want to reject this request?')) {
                    var reasonReject = document.getElementById('auto-resize-textarea').value;
                    var xhr = new XMLHttpRequest();
                    xhr.open("POST", "reasonreject?idRequest=" + idRequest + "&reasonReject=" + reasonReject, true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            // Xử lý phản hồi từ server (nếu cần)
                            document.querySelector('.wrapper').style.display = 'none';
                        }
                    };
                    xhr.send();
                }
            }

            const textarea = document.getElementById("auto-resize-textarea");
            textarea.addEventListener("input", function () {
                this.style.height = "auto";
                this.style.height = (this.scrollHeight) + "px";
            });
        </script>
    </body>
</html>
