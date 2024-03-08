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
                margin-top: 10px;
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
            .pagination {
                margin-bottom: 2px;
            }

            .pagination a {
                display: inline-block;
                padding: 8px 16px;
                text-decoration: none;
                color: #000;
                background-color: #fff;
                border: 1px solid #ddd;
                margin: 0 4px;
            }

            .pagination a.active {
                background-color: #007bff;
                color: #fff;
                border: 1px solid #007bff;
            }
            .flex-container {
                display: flex;
                flex-direction: row; /* Sắp xếp theo hàng ngang */
                flex-wrap: wrap; /* Cho phép các phần tử lớn hơn kích thước của flex container ngắt dòng xuống dòng mới */
            }

            .flex-item {
                margin-right: 20px; /* Khoảng cách bên phải giữa các phần tử */
                margin-bottom: 10px; /* Khoảng cách dưới giữa các phần tử */
            }
        </style>
    </head>
    <link href="vendor/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet">

    <!--
    
    TemplateMo 570 Chain App Dev
    
    https://templatemo.com/tm-570-chain-app-dev
    
    -->

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link rel="stylesheet" href="assets/css/templatemo-chain-app-dev.css">
    <link rel="stylesheet" href="assets/css/animated.css">
    <link rel="stylesheet" href="assets/css/owl.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://kit.fontawesome.com/4c292f6960.js" crossorigin="anonymous"></script>


    <jsp:include page="header.jsp"></jsp:include>


        <body>
            <section>

                <h1 style="text-align: center; color: white;">View </h1>

                <h1 style="color: Red; text-align: center;">${errorMessage}</h1>
            <h1 style="color: Red; text-align: center;">${error}</h1>
            <div style="margin: 100px">

                <div style="margin-bottom: 5px;">
                    <form action="reqmentor" method="post">
                        <div class="flex-container">
                            <c:forEach items="${ls}" var="checkbox">
                                <div class="flex-item">
                                    <input type="checkbox" id="${checkbox}" name="checkbox" value="${checkbox}">
                                    <label for="${checkbox}">${checkbox}</label><br>
                                </div>
                            </c:forEach>
                            <c:forEach items="${choice}" var="checkboxId">
                                <script>
                                    var checkbox = document.getElementById("${checkboxId}");
                                    if (checkbox) {
                                        checkbox.checked = true;
                                    }
                                </script>
                            </c:forEach>
                        </div>


                        <button type="submit" style="background: #b3b3b3; border: 1px; border-radius: 2px; width: 80px; height: 40px;">
                            <i style="width: 10px;"class="fas fa-search"></i>
                        </button>
                    </form>
                </div>

                <div style="margin-bottom: 5px;" class="pagination">
                    <c:if test="${totalPages > 1}">
                        <c:forEach var="i" begin="1" end="${totalPages}">
                            <c:url value="reqmentor" var="paginationUrl">
                                <c:param name="page" value="${i}" />
                            </c:url>
                            <a href="${paginationUrl}" class="${i == currentPage ? 'active' : ''}">${i}</a>
                        </c:forEach>
                    </c:if>
                </div>


                <table border="1" style="margin:auto">
                    <thead style="border: 1px solid black; background:#48CEFA;" >
                        <tr>
                            <th style="width: 10%;text-align: center;">Full Name</th>
                            <th style="width: 10%;text-align: center;">Title</th>
                            <th style="width: 15%;text-align: center;">Content of request</th>
                            <th style="width: 10%;text-align: center;">Start Date</th>
                            <th style="width: 10%;text-align: center;">Deadline Date</th>
                            <th style="width: 10%;text-align: center;">Deadline Hour (h)</th>
                            <th style="width: 10%;text-align: center;">Skills</th>
                            <th style="width: 10%;text-align: center;">Status</th>
                            <th style="width: 15%;text-align: center;">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="a" items="${listR}">
                            <tr style="height: 20%;border: 1px solid black;">
                                <td style="text-align: center;"><a style="text-decoration: none;" href="infomentee?id=${a.idMentee}">${a.fullname}</a></td>
                                <td style="text-align: center;">${a.title}</td>
                                <td style="text-align: center;">${a.content}</td>
                                <td style="text-align: center;">${a.startDate}</td>
                                <td style="text-align: center;">${a.deadline}</td>
                                <td style="text-align: center;">${a.hour}</td>
                                <td style="text-align: center;">${a.skill}</td>
                                <td style="text-align: center;">${a.status}</td>
                                <td class="btn-container" style="text-align: center;">
                                    <c:choose>
                                        <c:when test="${a.status eq 'Open'}">

                                            <a href="accept?idRequest=${a.idRequest}" onclick="return confirmAccept(event);" style="background-color: #1BA345; border-radius: 5px; height: 30px; width: 70px; display: inline-block; text-align: center; line-height: 30px; color: white; text-decoration: none;cursor: pointer">
                                                Accept
                                            </a>
                                            <a onclick="showRejectForm(${a.idRequest});" style="background-color: #DE3E44; border-radius: 5px; height: 30px; width: 70px; margin-left: 5px; display: inline-block; text-align: center; line-height: 30px; color: white; text-decoration: none;cursor: pointer">
                                                Reject
                                            </a>
                                        </c:when>
                                        <c:when test="${a.status eq 'Learning'}">
                                            <a href="endProcess?idRequest=${a.idRequest}" onclick="confirmEnd(${a.idRequest});" style="background-color:  #1BA345; border-radius: 5px; height: 30px; width: 70px; display: inline-block; text-align: center; line-height: 30px; color: white; text-decoration: none;">
                                                Finish
                                            </a>
                                        </c:when>
                                        <c:when test="${a.status eq 'Completed'}">
                                            Wait for Paid
                                        </c:when>
                                    </c:choose>

                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>

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
        </section>
        <footer id="newsletter">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2">
                        <div class="section-heading">
                            <h4>Join our mailing list to receive the news &amp; latest trends</h4>
                        </div>
                    </div>
                    <div class="col-lg-6 offset-lg-3">
                        <form id="search" action="#" method="GET">
                            <div class="row">
                                <div class="col-lg-6 col-sm-6">
                                    <fieldset>
                                        <input type="address" name="address" class="email" placeholder="Email Address..." autocomplete="on" required>
                                    </fieldset>
                                </div>
                                <div class="col-lg-6 col-sm-6">
                                    <fieldset>
                                        <button type="submit" class="main-button">Subscribe Now <i class="fa fa-angle-right"></i></button>
                                    </fieldset>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3">
                        <div class="footer-widget">
                            <h4>Contact Us</h4>
                            <p>Rio de Janeiro - RJ, 22795-008, Brazil</p>
                            <p><a href="#">010-020-0340</a></p>
                            <p><a href="#">info@company.co</a></p>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="footer-widget">
                            <h4>About Us</h4>
                            <ul>
                                <li><a href="#">Home</a></li>
                                <li><a href="#">Services</a></li>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Testimonials</a></li>
                                <li><a href="#">Pricing</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">About</a></li>
                                <li><a href="#">Testimonials</a></li>
                                <li><a href="#">Pricing</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="footer-widget">
                            <h4>Useful Links</h4>
                            <ul>
                                <li><a href="#">Free Apps</a></li>
                                <li><a href="#">App Engine</a></li>
                                <li><a href="#">Programming</a></li>
                                <li><a href="#">Development</a></li>
                                <li><a href="#">App News</a></li>
                            </ul>
                            <ul>
                                <li><a href="#">App Dev Team</a></li>
                                <li><a href="#">Digital Web</a></li>
                                <li><a href="#">Normal Apps</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="footer-widget">
                            <h4>About Our Company</h4>
                            <div class="logo">
                                <img src="assets/images/white-logo.png" alt="">
                            </div>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore.</p>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="copyright-text">
                            <p>Copyright © 2022 Chain App Dev Company. All Rights Reserved. 
                                <br>Design: <a href="https://templatemo.com/" target="_blank" title="css templates">TemplateMo</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
        <script>
            function confirmAccept(event) {
                if (!confirm('Are you sure you want to accept this request?')) {
                    event.preventDefault(); // Prevent the default behavior of the <a> element
                    return false;
                }
                return true;
            }
            function confirmEnd(event) {
                if (!confirm('Are you sure you want to end this request?')) {
                    event.preventDefault(); // Prevent the default behavior of the <a> element
                    return false;
                }
                return true;
            }
            function cancelRejectForm() {
                document.querySelector('.wrapper').style.display = 'none';
            }

            function showRejectForm(idRequest) {
                document.getElementById('idRequest').value = idRequest;
                document.querySelector('.wrapper').style.display = 'block';
            }



            const textarea = document.getElementById("auto-resize-textarea");
            textarea.addEventListener("input", function () {
                this.style.height = "auto";
                this.style.height = (this.scrollHeight) + "px";
            });
        </script>
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/owl-carousel.js"></script>
        <script src="assets/js/animation.js"></script>
        <script src="assets/js/imagesloaded.js"></script>
        <script src="assets/js/popup.js"></script>
        <script src="assets/js/custom.js"></script>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
