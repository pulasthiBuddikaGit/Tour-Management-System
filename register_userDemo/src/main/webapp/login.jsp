<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="pulacss/pulaloginstyle.css"> 
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		
		<div id="f1">
      <form action="log" method="post"><!-- action eke denne meken call karanna file eka. submit click karama web.xml file eka check karanaw log kiyala file ekk tiyanwd kiyla.tyenwa nm ekata adala class ekata geniyanaw -->
         <fieldset class="login1">
            <h1 class="h1">LOGIN</h1>
            
               <label><b>Username:</b></label><br>
               <input type="text" name="user1" placeholder="Username" id="upw1"><br>
               <label><b>Password:</b></label><br>
               <input type="password" name="pw1" placeholder="Password" id="upw2">
               <span id="show" onclick="togglePasswordVisibility()">Show</span><br>
            
            <label class="rem1">Remember me<input type="checkbox" name="remember"></label><br>
            <button class="but2">Forgot</button>
            <button type="submit" name="submit" class="but1">Login</button><br>

            <label class="reg1">Don't have an account?<a href="http://localhost:8090/register_userDemo/reguserinsert.jsp">Register</a></label><br>

      
         </fieldset>
      </form>
   </div>
   <script src="pulajs/pulapwtoggle.js"></script>
		
</body>
</html>