<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pulacss/pulaupdatestyle.css">
<title>Edit your account</title>
</head>
<body>

	<!-- we need to catch the data which are send as parameters from useraccount.jsp-->
	<% //we used '<%' tag to write java code inside jsp file
		String username = request.getParameter("name"); //pass the given name which we are given in useraccount page for getParameter method
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String phonenum = request.getParameter("pnum");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("cpassword");
				
	%>

	<div id="sd">
	<form action="update" method="POST" > <!-- action eke api denne me form eken data transmission wenna onna servlet eka(xml file)  -->
	<h3 class="form-title">Update Your Account</h3>
      <div class="flex">
        <div class="inputBox">
        <label>Username:</label>
        <input type="text" name="update_uname" value="<%= username %>" class="box"><br> <!-- to display java code inside value jsp we used this notation -->
        <label>First name:</label>
        <input type="text" name="update_fname" value="<%= firstname %>" class="box"><br>
        <label>Last name:</label>
        <input type="text" name="update_lname" value="<%= lastname %>" class="box"><br>
        <label>Phone number:</label>
        <input type="text" name="update_pnum" pattern="[0-9]{10}" value="<%= phonenum %>" class="box"><br>
        <label>Gender:</label>
        <input type="text" name="update_gender" value="<%= gender %>" class="box"><br>
        <label>Email:</label>
        <input type="text" name="update_email" pattern="[a-z0-9._%+\-]+@[a-z0-9.\-]+\.[a-z]{2,}$" value="<%= email %>" class="box"><br>


        </div>
        <div class="inputBox">
            
            <label>new password :</label>
            <input type="password" name="new_pass" placeholder="enter new password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" value="<%= password %>" class="box" ><br>
            <label>confirm password :</label>
            <input type="password" name="confirm_pass" placeholder="confirm new password" value="<%= confirmpassword %>" class="box"><br>
         </div>
      </div>
         <input type="submit" value="Save" name="update_profile" class="btn"> <br>
         
   </form>
   </div>

</body>
</html>