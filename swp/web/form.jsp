<%-- 
    Document   : form
    Created on : Jan 13, 2024, 7:53:20 PM
    Author     : trang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style_form.css">

        <!----===== Iconscout CSS ===== -->
        <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    </head>
    <body>

        <div class="container">
            <header>Create request</header>

            <form action="re" method="post">
                <div class="form first">
                    <div class="details personal">
                        <span class="title">Details</span>

                        <div class="fields">
                            <div class="input-field">
                                <label>Title(subject)</label>
                                <input type="text" name="title" placeholder="Enter your title(subject)" required>
                            </div>

                            <div class="input-field">
                                <label>Deadline date</label>
                                <input type="date" name="ddate" placeholder="Enter deadline date" required>
                            </div>

                            <div class="input-field">
                                <label>Deadline hour</label>
                                <input type="number" name="dhour" placeholder="Enter your deadline hour" required>
                            </div>

                            <div class="input-field">
                                <label>Content of request</label>
                                <input type="text" name="content" placeholder="Enter content of request " required>
                            </div>

                            <div class="input-field">
                                <label>Select skill</label>
                                <select name="skill" required>
                                    <option disabled selected>Select programing language</option>
                                    <option>Java OOP</option>
                                    <option>JavaScript</option>
                                    <option>Nodejs</option>
                                </select>
                            </div>

                            <div class="input-field">
                                <label>Status</label>
                                <select name="status" required>
                                    <option disabled selected>Select status</option>
                                    <option>Open</option>
                                    <option>Processing</option>
                                    <option>Cancel</option>
                                    <option>Close</option>
                                </select>
                            </div>
                        </div>
                    </div>



                    <div class="buttons">
                        <div class="backBtn">
                            <i class="uil uil-navigator"></i>
                            <span class="btnText">Back</span>
                        </div>

                        <button class="sumbit">
                            <span class="btnText">Submit</span>
                            <i class="uil uil-navigator"></i>
                        </button>
                    </div>
                </div> 
        </div>
    </form>
</div>

<script src="script.js"></script>

</body>
</html>
