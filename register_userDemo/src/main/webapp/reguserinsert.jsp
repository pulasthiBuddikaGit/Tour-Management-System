<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pulacss/pularegstyle.css">
<title>Insert title here</title>
</head>
<body>

	<div class="form-container">
   <form action="insert" method="post" class="registration-form"> <!-- xml files connect the jsp file with its servlet -->
      <h3 class="form-title">Register now</h3>
      <div class="input-container">
         <input type="text" name="name" placeholder="Username" class="box" required>
      </div>
      <div class="input-container">
         <input type="text" name="fname" placeholder="First Name" class="box" required>
      </div>
      <div class="input-container">
         <input type="text" name="lname" placeholder="Last Name" class="box" required>
      </div>
      <div class="input-container">
         <input type="tel" name="pnum" pattern="[0-9]{10}" placeholder="Phone number" class="box">
      </div>
      <div class="input-container">
         <input type="text" name="gender" placeholder="Gender" class="box" required>
      </div>
      <div class="input-container">
         <input type="email" name="email" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" placeholder="Email" class="box" required>
      </div>
      <div class="input-container">
         <input type="password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" placeholder="Password" class="box" required>
      </div>
      <div class="input-container">
         <input type="password" name="cpassword" placeholder="Confirm Password" class="box" required>
      </div>
      <!-- <div class="input-container">
         <input type="file" name="image" class="box" accept="image/jpg, image/jpeg, image/png">
      </div> -->
      <div class="input-container">
         <button type="submit" name="submit" value="register now" class="box submit-button">
            <b class="btn">Submit</b>
         </button>
      </div>
      <p>Already have an account? <a href="login.jsp">Login now</a></p>
   </form>
</div>

</body>
</html>