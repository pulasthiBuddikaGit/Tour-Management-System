package com.register_user;

public class reg_userpula {
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String phonenum;
	private String gender;
	private String email;
	private String password;
	private String confirmpassword;
	public reg_userpula(int id ,String username, String firstname, String lastname, String phonenum, String gender,
			String email, String password, String confirmpassword) {
		
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phonenum = phonenum;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}
	public int getid() {
		return id;
	}
	public String getusername() {
		return username;
	}
	public String getfirstname() {
		return firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public String getphonenum() {
		return phonenum;
	}
	public String getgender() {
		return gender;
	}
	public String getemail() {
		return email;
	}
	public String getpassword() {
		return password;
	}
	public String getconfirmpassword() {
		return confirmpassword;
	}
	
	
	
	
}
