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

@WebServlet("/DeleteCustomerServ")
public class DeleteCustomerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session=request.getSession();
		int userid=(int)session.getAttribute("uid");
		
		//when user clicks delete button deletecustomer.jsp data comes to here. so we need to store them in var
		String username = request.getParameter("delete_uname"); //to delete a row in a table we only need unique key in the table so we catching that will be enough
		
		boolean isTrue;
		
		isTrue = Reg_userDBUtil.deleteCustomer(userid); //calling the deleteCustomer method from util page and that method return a boolean value so to store it i have created a isTrue variable
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("reguserinsert.jsp"); //if delete is success, navigates to insert page
			dispatcher.forward(request, response);
		}
		else {
			//if delete is not successful then navigates to useraccount
			//aye useraccount jsp ekta yaddi api user ge account details tika aran yanna onne(data retrieval)
			//to do data retrieval we need to call getCustomerDetails() method from util
			List<reg_userpula> ruDetails = Reg_userDBUtil.getCustomerDetails(userid); //me method ekta pass kale uda declare karapu string variable eka
			request.setAttribute("ruDetails", ruDetails); //1.attribute name 2.value
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("useraccount.jsp");
			dispatcher.forward(request, response);
			
			
		}
		
		
	}

}
