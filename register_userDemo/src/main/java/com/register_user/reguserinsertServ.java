package com.register_user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/reguserinsertServ")
public class reguserinsertServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("name");
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String phonenum = request.getParameter("pnum");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmpassword = request.getParameter("cpassword");
		
		boolean isTrue;
		
		isTrue = Reg_userDBUtil.insertreguser(username, firstname, lastname, phonenum, gender, email, password, confirmpassword);//calling the insertreguser()method passing above data which user inserted to form 
		//check the insertreguser return value whether it return value=1 or 0
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");//if all are okey then navigate to success.jsp page
			dis.forward(request, response); 
		}
		else
		{
			RequestDispatcher dis2 = request.getRequestDispatcher("pulaunsuccess.jsp");
			dis2.forward(request, response);
		}
		
	}

}
