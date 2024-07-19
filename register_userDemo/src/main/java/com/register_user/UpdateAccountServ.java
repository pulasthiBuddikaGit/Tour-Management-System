package com.register_user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateAccountServ")
public class UpdateAccountServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//need sevaral variables to save data which are send from updatecustomer.jsp file
		String username = request.getParameter("update_uname"); //pass the name of html form in updatecustomer.jsp as parameter
		String firstname = request.getParameter("update_fname");
		String lastname = request.getParameter("update_lname");
		String phonenum = request.getParameter("update_pnum");
		String gender = request.getParameter("update_gender");
		String email = request.getParameter("update_email");
		String password = request.getParameter("new_pass");
		String confirmpassword = request.getParameter("confirm_pass");
		
		HttpSession session=request.getSession();
		int userid=(int)session.getAttribute("uid");
				
		
		//creating a boolean value to catch the result return from util 
		boolean isTrue;
		
		isTrue = Reg_userDBUtil.updatecustomer(userid ,username, firstname, lastname, phonenum, gender, email, password, confirmpassword);
		//data retrieval part
		if(isTrue == true) {
			//we need to give what should bring to useraccount.jsp file when update is successful
			List<reg_userpula> ruDetails = Reg_userDBUtil.getCustomerDetails(userid);
			request.setAttribute("ruDetails", ruDetails); //why ruDetails given? bcz useraccount.jsp item is ruDetails
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
		else {
			//update nounath account eke tyenna tika e widihata pennana tma methana useraccount.jsp page ekta navigate karala tyenne
			List<reg_userpula> ruDetails = Reg_userDBUtil.getCustomerDetails(userid);
			request.setAttribute("ruDetails", ruDetails);
			
			RequestDispatcher dis=request.getRequestDispatcher("useraccount.jsp");
			dis.forward(request, response);
		}
			
		//web.xml file is the one who connect servlet and jsp file
		
	}

}
