<%-- 
    Document   : CreateCV
    Created on : Jan 18, 2024, 10:09:37 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style_4.css"/>
<!--        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style4.css"/>-->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/js1.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" integrity="sha512-....." crossorigin="anonymous" />
        <style>
            .fieldlabels {
                width: 100px;
                text-align:justify;
                margin-right: 10px;
            }
            section {

                max-width: 500px;

            }
            .form-group {
                margin-bottom: 1rem;
                display: grid;
                align-items: center;
            }

            .fieldlabels {
                width: 120px; /* Điều chỉnh chiều rộng của nhãn (labels) */
            }
            .form-group select{
                padding: 7px;
            }
            .form-check {
                display: inline-block; /* Hiển thị các phần tử theo hàng ngang */
                margin-right: 1rem; /* Khoảng cách giữa các checkbox */
            }
            .submit{
                color: white;
                background: green;
                border-radius: 5px;
                padding: 15px 25px;
                display: inline-block;
                margin: 10px;
                font-weight: bold;
                color: white;
                cursor: pointer;
                box-shadow: 0px 2px 5px rgb(0,0,0,0.5);
            }


        </style>


    </head>
    <body>
        <div>
            <a href="home" style=" text-decoration: none; color: white; display: flex; align-items: center; margin-top: 30px;">
                <i class="fa fa-home" style="font-size: 24px; margin-right: 10px;"></i>
                Home
            </a>
        </div>
        <div id="svg_wrap"></div>      
        <h1>Update CV</h1>

        <form id="msform" method="POST" action="createcv?idMentor=${cx.getId()}" enctype="multipart/form-data" style="margin-top: 30px" onsubmit="return submitForm();">
            <section>
                <div class="form-group">
                    <label class="fieldlabels" for="photo">Image:</label>
                    <input type="file" id="photo" name="image" value="${mentor.avatar}">
                </div>
                <div class="form-group">
                    <label class="fieldlabels" for="emailInput">Email: </label> 
                    <input type="email" id="emailInput" name="email" placeholder="Email" value="${cx.email}" readonly/> 
                </div>
                <div class="form-group">
                    <label class="fieldlabels" for="fullname">Fullname: </label> 
                    <input type="text" id="fullname" name="uname" placeholder="FullName" value="${mentor.fullname}" />                                      
                </div>


            </section>


            <section>
                <div class="form-group">
                    <label   class="fieldlabels">Date: </label> 
                    <input id="dateInput" type="date" name="date" placeholder="Date" value="${mentor.dob}"/> 
                </div>
                <div class="form-group">
                    <label class="fieldlabels" for="gender">Sex: </label> 
                    <select class="fieldlabels" id="gender" name="gender">
                        <option value="Male" > Male</option>
                        <option value="Female">Female</option>
                        <option value="Others">Others</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="fieldlabels">Address: </label> 
                    <input type="text" name="address" placeholder="Address" value="${mentor.address}"/>
                </div>            



            </section>

            <section>
                <div class="form-group">
                    <label class="fieldlabels">Phone:</label>
                    <input type="text" id="phone" name="phone" placeholder="Phone" value="${mentor.phone}" />
                    <span id="phoneError" style="color: red; display: none;">Please enter a 10-digit phone number</span>
                </div>
                <div class="form-group">
                    <label class="fieldlabels">Profession: </label> 
                    <input  type="text" name="pwd" placeholder="Profession" value = "${mentor.profession}"/>  
                </div>
                <div class="form-group">
                    <label class="fieldlabels">Introduction: </label> 
                    <input type="text" name="intro" placeholder="Introduction" value="${mentor.pro_introduc}"/> 
                </div>
            </section>

            <section>
                <div class="form-group">
                    <label class="fieldlabels">Experience: </label> 
                    <input type="text" name="experience" placeholder="Experience" value="${mentor.experience}" />    
                </div>
                <div class="form-group">
                    <label class="fieldlabels">My Services: </label> 
                    <input type="text" name="service" placeholder="My Services" value="${mentor.myservice}"/>
                </div>
                <div class="form-group">
                    <label class="fieldlabels">Education: </label> 
                    <input type="text" name="education" placeholder="Education" value="${mentor.education}"/> 
                </div>
            </section>

            <section>
                <div class="form-group">
                    <label class="fieldlabels">Achivement: </label> 
                    <input type="text" name="achivement" placeholder="Achivement" value="${mentor.archivement_sescition}"/> 
                </div>
                <div class="form-group">
                    <label class="fieldlabels">Framework: </label> 
                    <input type="text" name="framework" placeholder="Framework" value="${mentor.framework}"/>
                </div>
                <div class="form-group">
                    <label class="fieldlabels">$/1h: </label> 
                    <input type="text" name="cost" placeholder="$/1h" value="${mentor.cost}"/>
                </div>
            </section>
            <section>
                <div class="form-group">
                    <label class="fieldlabels">STK: </label> 
                    <input type="text" name="STK" placeholder="BIDV: &&&" value="${mentor.STK}"/>
                </div>

                <h3>Skills: </h3>
                <c:forEach var="e" items="${skill}">
                    <div class="form-check" style = "padding-top: 30px;">
                        <input class="form-check-input skillCheckbox" type="checkbox" name="skills" value="${e.id}" id="skill1">
                        <label class="form-check-label" for="skill1">${e.skillName}</label>
                    </div>
                </c:forEach>


            </section>

            <div class="button" id="prev">&larr; Previous</div>
            <div class="button" id="next">Next &rarr;</div>
            <button class="submit next action-button" type="submit" onclick="return confirm('Are you sure to update')">Send</button>
            <button class="cancel action-button" onclick="return false;" style="display: none;"></button>          

            ${mess}
        </form>
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

        <script>

            function setMaxDate() {
                var today = new Date();
                var dd = String(today.getDate()).padStart(2, '0');
                var mm = String(today.getMonth() + 1).padStart(2, '0');
                var yyyy = today.getFullYear();

                today = yyyy + '-' + mm + '-' + dd;

                document.getElementById('dateInput').max = today;
            }


            setMaxDate();

            const phoneInput = document.getElementById('phone');
            const phoneError = document.getElementById('phoneError');

            phoneInput.addEventListener('input', function () {
                const phone = this.value.trim();
                if (phone.length !== 10 || !/^\d+$/.test(phone)) {
                    phoneError.style.display = 'inline';
                } else {
                    phoneError.style.display = 'none';
                }
            });
            function validateSkills() {
                var checkboxes = document.querySelectorAll('.skillCheckbox');
                var checked = false;

                checkboxes.forEach(function (checkbox) {
                    if (checkbox.checked) {
                        checked = true;
                    }
                });

                return checked;
            }

            // Gắn hàm kiểm tra vào sự kiện onSubmit của form
            document.getElementById('msform').addEventListener('submit', function (event) {
                if (!validateSkills()) {
                    alert('Vui lòng chọn ít nhất một kỹ năng.');
                    event.preventDefault(); // Ngăn chặn việc gửi biểu mẫu nếu không có kỹ năng được chọn
                }
            });
        </script>
    </body>
</html>
