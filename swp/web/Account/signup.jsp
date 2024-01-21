<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Happy Programming</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    </head>
    <body>
        <div class="wapper">
            <div class="back"><a href="home.jsp"><i class="fa fa-home" style="font-size: 24px;color: black;"></i></a></div>
            <form action="signup" method="post">
                <h1>Sign up</h1>
                You are: 
                <select name="role">
                    <option value="Mentor">Mentor</option>
                    <option value="Mentee">Mentee</option>
                </select>
                <div class="input-box">
                    <input type="text" name="username" placeholder="Username" required>   
                </div>    
                <div class="input-box">
                    <input type="password"name="pass" placeholder="Password" required>   
                </div> 
                <div class="input-box">
                    <input type="password" name="repass" placeholder="Re-enter Password" required>   
                </div>
                <div class="input-box">
                    <input type="email"  name="email" placeholder="Email" required>   
                </div> 
                <div class="input-box">
                    <input type="text"  name="fullname" placeholder="Fullname" required>   
                </div> 
                <div class="input-box">
                    <input type="number"  name="phone" placeholder="Phone" required>   
                </div> 
                <div class="input-box">
                    <input type="date"  name="birth" placeholder="Birthday" required>   
                </div> 
                <div class="input-box">
                    <input type="text"  name="address" placeholder="Address" required>   
                </div>
                <p style="font-size: large">Gender:</p>
                <div class="row">
                    <div class="col-md-4">
                        <input type="radio" name="gender" value="Male"> Male
                    </div>
                    <div class="col-md-4">
                        <input type="radio" name="gender" value="Female"> Female
                    </div>
                    <div class="col-md-4">
                        <input type="radio" name="gender" value="Other"> Other
                    </div>
                </div>
                <br>
                <p style="color: red;font-size: large">${err}</p>


                <button class="button" type="submit" >
                    SIGN UP
                </button>
                <div class="resiter-link">
                    <p>You had account ? </p>
                    <a ><a href="#" >Sign in</a>
                </div>

            </form>

        </div>
    </body>
</html>
