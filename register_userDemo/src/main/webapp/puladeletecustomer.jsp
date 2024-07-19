<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pulacss/puladeletestyle.css">
<script src="pulajs/puladel.js"></script>

<title>Customer Account Delete</title>
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
	<form action="delete" method="POST" >
	<h1>Customer account delete</h1>
      <div class="flex">
        <div class="inputBox">
        <label>Username:</label>
        <input type="text" name="delete_uname" value="<%= username %>" class="box" readonly><br> <!-- to display java code inside value jsp we used this notation -->
        <label>First name:</label>
        <input type="text" name="delete_fname" value="<%= firstname %>" class="box" readonly><br>
        <label>Last name:</label>
        <input type="text" name="delete_lname" value="<%= lastname %>" class="box" readonly><br>
        <label>Phone number:</label>
        <input type="text" name="delete_pnum" value="<%= phonenum %>" class="box" readonly><br>
        <label>Gender:</label>
        <input type="text" name="delete_gender" value="<%= gender %>" class="box" readonly><br>
        <label>Email:</label>
        <input type="text" name="delete_email" value="<%= email %>" class="box" readonly><br>


        </div>
      </div>
         <input type="submit" value="Delete my account" name="update_profile" id="deleteButton" class="btn"> <br>
         
   </form>
	</div>
</body>
</html>