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


@WebServlet("/Loginserv")
public class Loginserv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserName = request.getParameter("user1");//user1 is the name of username text field in login.jsp
		String Password = request.getParameter("pw1");
		//data has been send to servlet(control class) from view till now
		
		//now we have to send the entered data to the view(useraccount.jsp)
		//If these un and pw are correct we need to send these data to another page
		
		
		try {																		//we are going to create list object. These object can get reg_userpula table data
		List<reg_userpula> ruDetails=Reg_userDBUtil.validate(UserName, Password);//call the validate function in util class
		request.setAttribute("ruDetails", ruDetails);//1->attribute name,2->list object
		
		int uid=ruDetails.get(0).getid();
		
		
			HttpSession session=request.getSession();
			session.setAttribute("uid", uid); //setAttribute used to set a session
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//Read happened in useraccount.jsp file
		RequestDispatcher dis = request.getRequestDispatcher("useraccount.jsp");//RequestDispatcher used to navigates to useraccount.jsp(view)
		dis.forward(request, response);//dis is object of RequestDispatcher class
	}

}
