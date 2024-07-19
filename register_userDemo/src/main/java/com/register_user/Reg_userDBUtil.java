package com.register_user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class Reg_userDBUtil {
	
	private static boolean isSuccess; //variabels which are not creating inside methods called instance variables. these kind of variables can be use in any method.
	//creating objects from Connection,Statment,ResultSet classes
	private static Connection con= null;
	private static Statement stmt= null;
	private static ResultSet rs= null;
	
	public static List<reg_userpula> validate(String UserName1,String Password1){//validate is a static method which returns reg_userpula table data(take the un and pw from loginservlet as parameters) no need to match the parameters with loginserv bcz same validate() has called in loginserv
		
		//going to create data base connection
		//if the data base connection is success, pull all the data in reg_userpula table into this util class and send it to reg_userpula.java class
		
		ArrayList<reg_userpula> reg = new ArrayList<>();//ArrayList is a class and we create a object from that
		
		//validate
		//if some error occurs it will display error instead terminating the program bcz of try catch block
		try {
			con = DBconnect.getConnection();//calling the DBconnect.java
			stmt = con.createStatement();//creating the statment
			
			/*note - select **/String sql="select * from reg_userpula where UserName='"+UserName1+"'and Password='"+Password1+"'";
			rs = stmt.executeQuery(sql);//excuting the sql query
			
			//if the un and pw valid fetch the data of reg_user
			if(rs.next()) { //next check true or not
				int User_Id = rs.getInt(1);//pass the column number to getInt function 
				String UserName = rs.getString(2);
				String FirstName = rs.getString(3);
				String LastName = rs.getString(4);
				String PhoneNum = rs.getString(5);
				String Gender = rs.getString(6);
				String Email = rs.getString(7);
				String Password = rs.getString(8);
				String ConfirmPassword = rs.getString(9);
				
				reg_userpula r=new reg_userpula(User_Id,UserName,FirstName,LastName,PhoneNum,Gender,Email,Password,ConfirmPassword);
				reg.add(r);
			}
		}
		catch(Exception e) {
			e.printStackTrace();//print the error
		}
		
		
		return reg;
	}
	
	public static boolean insertreguser(String username,String firstname,String lastname,String phonenum,String gender,String email,String password,String confirmpassword) {//take the un and pw from insertservlet as parameters 
		
		boolean isSuccess = false; //this insertreguser return a boolean value
		
		//create database connection
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			
			String sql="insert into reg_userpula values(0,'"+username+"','"+firstname+"','"+lastname+"','"+phonenum+"','"+gender+"','"+email+"','"+password+"','"+confirmpassword+"')" ;//pass the insertreguser parameters
			int rs= stmt.executeUpdate(sql); //insert,update,delete nm excuteUpdate()
											//ResultSet kiyala class ekk meke nathi nisa object ekk uda eka wage hadanna onne na excute karanna
				//if data insert into table correctly executeUpdate() method will return 1 unless 0(unsuccessful)
			if(rs>0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		
		return isSuccess; //return whether data inserting is success or not
	}
	
	
	public static boolean updatecustomer(int uid,String username,String firstname,String lastname,String phonenum,String gender,String email,String password,String confirmpassword) { //why we made these methods static? bcz we can called them from its class name without creating object.now we need to give updateaccount servlet values as parameters
		
		//creating database connection
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			//++ athule denne parameters updatecustomer method eke. set eka issarahin liyanne ape actual column names
			String sql= "update reg_userpula set UserName='"+username+"',FirstName='"+firstname+"',LastName='"+lastname+"',PhoneNum='"+phonenum+"',Gender='"+gender+"',Email='"+email+"',Password='"+password+"',ConfirmPassword='"+confirmpassword+"'"
						+"where User_Id='"+uid+"'";
			int rs = stmt.executeUpdate(sql); //excute query
			
			if(rs > 0) {
				isSuccess = true;
			}
			else
			{
				isSuccess= false;
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	} 
	
	//data retrieval part.getCustomerDetails() used to data retrieval part
	public static List<reg_userpula> getCustomerDetails(int userid){ //why we gave reg_userpula.java class as a data type. bcz the data which we are taken from database need to be send to the that java class
		
		ArrayList<reg_userpula> cus = new ArrayList<>(); //the reason I create arraylist is , from this method we are returning a ArrayList
		
		try {
			
			con = DBconnect.getConnection();
			stmt = con.createStatement();
			//retrieve the data from database
			String sql = "select * from reg_userpula where User_Id='"+userid+"'"; 
			rs = stmt.executeQuery(sql); //select nm excuteQuery
			
			while(rs.next()) {
				//creating variables to store retrieve data from db
				int User_Id = rs.getInt(1);
				String UserName=rs.getString(2);
				String FirstName = rs.getString(3);
				String LastName = rs.getString(4);
				String PhoneNum = rs.getString(5);
				String Gender = rs.getString(6);
				String Email = rs.getString(7);
				String Password = rs.getString(8);
				String ConfirmPassword = rs.getString(9);
				
				//select all from the table but while calling call without User_id
				reg_userpula user = new reg_userpula(User_Id,UserName,FirstName,LastName,PhoneNum,Gender,Email,Password,ConfirmPassword);
				//add elements to array without User_id
				cus.add(user);
				
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return cus;
			
	}
	
	
	public static boolean deleteCustomer(int userid) {
		
		try {
			
			con=DBconnect.getConnection();
			stmt = con.createStatement();
			
			String sql="delete from reg_userpula where User_Id='"+userid+"'";
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}
	
	
	
	
}
