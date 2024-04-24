package models;

//import java.util.ArrayList;
//import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import managers.ManageUsers;

public class User implements java.io.Serializable {

private static final long serialVersionUID = 1L;
	
	private String user = "";
	private String mail = "";
	private String pwd1 = "";
	private String pwd2 = "";
	private String date = "";
	private String gender = "";
	private int country_id = 0;
	private int admin = 0;
	
	private boolean[] error  = {false,false,false,false,false,false,false};
	
	public User() {
		
	}
	
	public String getUser() {
		return this.user;
	}
	
	public void setUser(String user) {
		/* We can simulate that a user with the same name exists in our DB and mark error[0] as true  */
		//error[0] = true;
		this.user = user;
		//System.out.println(user);
	}
	
	public String getMail() {
		return this.mail;
	}
	
	public void checkUser(ManageUsers manager) {
		if(manager.existUser(this.user)) {
			this.user = "";
			error[0] = true;
		}
	}
	
	public void setMail(String mail) {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mail);
		if (matcher.matches()) {
			this.mail = mail;
			//System.out.println(mail);
		} else {
			error[1]=true;
			//System.out.println(mail);
		}
		
	}
	
	public String getPwd1() {
		return this.pwd1;
	}
	
	public void setPwd1(String pwd1) {
		String regex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pwd1);
		if (matcher.matches()) {
			this.pwd1 = pwd1;
			//System.out.println(pwd1);
		} else {
			error[2]=true;
			//System.out.println(pwd1);
		}
	}
	
	public String getPwd2() {
		return this.pwd2;
	}
	
	public void setPwd2(String pwd2) {
		/* TODO check restriction with pattern and check if pwd1=pwd2*/
		if(this.pwd1.equals(pwd2)) {
			this.pwd2 = pwd2;
			//System.out.println(pwd2);
		}else {
			error[3]=true;
			//System.out.println(pwd2);
		}
	}
	
	public String getDate() {
		return this.date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getGender() {
		return this.gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
		//System.out.println(gender);
	}
	
	public int getCountry() {
		return this.country_id;
	}
	
	public void setCountry(int country) {
		this.country_id = country;
		//System.out.println(country);
	}
	
	public boolean[] getError() {
		return error;
	}
	
	public int getAdmin() {
		return this.admin;
	}
	
	public void setAdmin(int admin) {
		this.admin = admin;
		//System.out.println(country);
	}
	
}
