package com.sbw.erst.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Session {
	private int SessionId;
	private int FilmId;
	private int RoomId;
	private String BeginTime;
	private String EndTime;
	private double price;
	public int getSessionId() {
		return SessionId;
	}
	public void setSessionId(int sessionId) {
		SessionId = sessionId;
	}
	public int getFilmId() {
		return FilmId;
	}
	public void setFilmId(int filmId) {
		FilmId = filmId;
	}
	public int getRoomId() {
		return RoomId;
	}
	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	public String getBeginTime() {
		return BeginTime;
	}
	public void setBeginTime(String time) {
		this.BeginTime = time;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Session(int id) {
		setSessionId(id);
        String sql = "select * from session where SessionId =" + Integer.toString(id);
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	setFilmId(ret.getInt(2));
            	setRoomId(ret.getInt(3));
            	setBeginTime(ret.getString(4));
            	setEndTime(ret.getString(5));
            	setPrice(ret.getDouble(6));
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}
	
	
	
	@SuppressWarnings("unused")
	public int[][] AvaliableSeats() {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
        String sql = "select * from room r, session s where s.sessionid =" + Integer.toString(SessionId) + " and r.roomid = s.roomid";
        Starter db1 = new Starter(sql);
        int roomid = 0, roomrow = 0, roomcolumn = 0;
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	roomid = ret.getInt(1);
            	roomrow = ret.getInt(4);
            	roomcolumn = ret.getInt(5);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
		
        String sql2 = "select s.SeatId from Seat s, Room r where s.roomid = r.roomid and s.isvalid = 1";
        Starter db2 = new Starter(sql2);
        ResultSet ret2 = null;
        try {  
            ret2 = db2.pst.executeQuery();
            while (ret2.next()) {  
            	tmp.add(ret2.getInt(1));
            }
            ret2.close();  
            db2.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        int[][] ar = new int[roomrow][roomcolumn];
        for (int x : tmp) {
        	ar[x%10000/100][x%100] = 1;
        }
        return ar;
		
	}
}
