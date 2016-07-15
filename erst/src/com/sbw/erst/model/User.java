package com.sbw.erst.model;

import java.sql.SQLException;
import java.sql.ResultSet;  

public class User {
	private int UserID;
	private String Email;
	private String UserName;
	private String PassWord;

	public int getUserID() {
		return UserID;
	}


	public void setUserID(int iD) {
		this.UserID = iD;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String Email) {
		this.Email = Email;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		this.UserName = userName;
	}


	public String getPassWord() {
		return PassWord;
	}


	public void setPassWord(String passWord) {
		this.PassWord = passWord;
	}

	
	User(int id) {
		setUserID(id);
        String sql = "select * from user where UserId =" + Integer.toString(UserID); 
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	setUserName(ret.getString(2));
            	setEmail(ret.getString(3));
            	setPassWord(ret.getString(4));
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}

}
