package com.sbw.erst.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Cinema {
    private int CinemaId;
    private String CinemaName;
    private String PhoneNum;
    private String Location;
    public Cinema(int id) {
		setCinemaId(id);
        String sql = "select * from cinema where CinemaId =" + Integer.toString(id);
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	setCinemaName(ret.getString(2));
            	setLocation(ret.getString(3));
            	setPhoneNum(ret.getString(4));
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}
	public int getCinemaId() {
		return CinemaId;
	}
	public void setCinemaId(int cinemaId) {
		this.CinemaId = cinemaId;
	}
	public String getCinemaName() {
		return CinemaName;
	}
	public void setCinemaName(String cinemaName) {
		this.CinemaName = cinemaName;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.PhoneNum = phoneNum;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		this.Location = location;
	}
    
}
