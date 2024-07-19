<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="pulacss/pulauseraccstyle.css">
<title>User account</title>
</head>
<body>

		<c:forEach var="reg" items="${ruDetails}"> <!-- data which are send from servlet come to this item -->
		
		<!-- assign below data to variabels -->
		<!-- why we declare these variabels inside the forloop? bcz data which are send from servlet have inside this loop -->
		<c:set var="username" value="${reg.username}" />
		<c:set var="firstname" value="${reg.firstname}" />
		<c:set var="lastname" value="${reg.lastname}" />
		<c:set var="phonenum" value="${reg.phonenum}" />
		<c:set var="gender" value="${reg.gender}" />
		<c:set var="email" value="${reg.email}" />
		<c:set var="password" value="${reg.password}" />
		<c:set var="confirmpassword" value="${reg.confirmpassword}" />
		
		 <div class="c-wrapper">
        <table>
            <tr>
                <th colspan="2">User Account Details:</th>
                
            </tr>
            <tr>
                <td>Username:</td>
                <td>${reg.username}</td>
            </tr>
            <tr>
                <td>First Name:</td>
                <td>${reg.firstname}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>${reg.lastname}</td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td>${reg.phonenum}</td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>${reg.gender}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>${reg.email}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>${reg.password}</td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <td>${reg.confirmpassword}</td>
            </tr>
        </table>

        <!-- Rest of your code, such as the "Update" and "Delete" buttons, can remain the same -->
    </div>
		
		</c:forEach>
		<!-- this is how you can pass parameters from url -->
		<c:url value="pulaupdatecustomer.jsp" var="cusupdate"> <!-- after clicking button this url tag send the data to updatecustomer.jsp page. useraccount.jsp ekai updatecustomer.jsp ekai athara loop ekak tyenne -->
			<c:param name="name" value="${username}"/> <!-- this param tag use to give what data should be brought to updatecustomer.jsp -->
			<c:param name="fname" value="${firstname}"/> <!-- pass the above var as value -->
			<c:param name="lname" value="${lastname}"/>
			<c:param name="pnum" value="${phonenum}"/>
			<c:param name="gender" value="${gender}"/>
			<c:param name="email" value="${email}"/>
			<c:param name="password" value="${password}"/>
			<c:param name="cpassword" value="${confirmpassword}"/>
		</c:url>
		
		<a href="${cusupdate}"> <!--we have given the updatecustomer.jsp var 'cusupdate' as where to go next after clicking update button-->
		<input type="button" name="update" value="Update my account" class="ab">
		</a>
		
		<br>
		<!-- after click delete button this url tag lead the customer to deletecustomer.jsp page -->
		<c:url value="puladeletecustomer.jsp" var="cusdelete">
			<c:param name="name" value="${username}"/> <!-- me value tag eka athule denne api uda set eke variables athule dipu name eka -->
			<c:param name="fname" value="${firstname}"/>
			<c:param name="lname" value="${lastname}"/> 
			<c:param name="pnum" value="${phonenum}"/> 
			<c:param name="gender" value="${gender}"/> 
			<c:param name="email" value="${email}"/> 
			<c:param name="password" value="${password}"/> 
			<c:param name="cpassword" value="${confirmpassword}"/> 
				
		</c:url>
		<a href="${cusdelete}"> <!-- this cusdelete var holds the deletecustomer.jsp link -->
		<input type="button" name="delete" value="Delete my account" class="cd">
		</a>
		
				
</body>
</html>