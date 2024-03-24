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
            #contact {
                -webkit-user-select: none; /* Chrome/Safari */
                -moz-user-select: none; /* Firefox */
                -ms-user-select: none; /* IE10+ */
                margin: 4em auto;
                width: 100px;
                height: 30px;
                line-height: 30px;
                background: teal;
                color: white;
                font-weight: 700;
                text-align: center;
                cursor: pointer;
                border: 1px solid white;
            }

            #contact:hover {
                background: #666;
            }
            #contact:active {
                background: #444;
            }

            #contactForm {
                display: none;

                border: 6px solid salmon;
                padding: 2em;
                width: 400px;
                text-align: center;
                background: #fff;
                position: fixed;
                top:50%;
                left:50%;
                transform: translate(-50%,-50%);
                -webkit-transform: translate(-50%,-50%)

            }

            input, textarea {
                margin: .8em auto;
                font-family: inherit;
                text-transform: inherit;
                font-size: inherit;

                display: block;
                width: 280px;
                padding: .4em;
            }
            textarea {
                height: 80px;
                resize: none;
            }

            .formBtn {
                width: 140px;
                display: inline-block;

                background: teal;
                color: #fff;
                font-weight: 100;
                font-size: 1.2em;
                border: none;
                height: 30px;
            }

        </style>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    </head>
    <body>

        <header style="background: #48CEFA;margin: 20px;">
            <!--            <h1>List of Requests</h1>-->
            <a href="home" style="text-decoration: none; color: white; display: flex; align-items: center;">
                <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
                Home
            </a>
            <h1 style="margin-left: auto; padding-bottom: 20px; margin: 20px;">List of Wallet</h1>
        </header>

        <section>
            <table border="1" style="margin:auto">
                <thead style="border: 1px solid black; background:#48CEFA;">
                    <tr>
                        <th style="width: 10%;text-align: center;">idAccount</th>
                        <th style="width: 10%;text-align: center;">Amount</th>
                        <th style="width: 10%;text-align: center;">DatePay</th>
                        <th style="width: 10%;text-align: center;">Content</th>
                        <th style="width: 10%;text-align: center;">Stype</th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>23$</td>
                        <td>23-11-2024</td>
                        <td>K co</td>
                        <td><div id="contact">Contact</div></td>
                    </tr>

                    <!-- Add more rows as needed -->
                </tbody>

            </table>
        </section>
        <div id="contactForm">

            <h1>View Money</h1>        
            <h2>Surplus : </h2>
            <form action="#">

                <h4>Amount to withdraw: </h4>
                <input placeholder="Money" type="text" required />
                <c:if test="${mess eq 'ok'}">
                    <div class="alert alert-success" role="alert">
                        Submitted withdrawal request successfully
                    </div>
                </c:if>
                <c:if test="${param.fail != null}">
                    <div class="alert alert-danger" role="alert">
                        Create failed. Please try again.
                    </div>
                </c:if>
                <button class="formBtn" type="submit" >Request</button>

            </form>

            <script src="assets/jquery-1.11.3.min.js"></script>


            <script>

                $(function () {

                    // contact form animations
                    $('#contact').click(function () {
                        $('#contactForm').fadeToggle();
                    })
                    $(document).mouseup(function (e) {
                        var container = $("#contactForm");

                        if (!container.is(e.target) // if the target of the click isn't the container...
                                && container.has(e.target).length === 0) // ... nor a descendant of the container
                        {
                            container.fadeOut();
                        }
                    });

                });
            </script>
    </body>
</html>
