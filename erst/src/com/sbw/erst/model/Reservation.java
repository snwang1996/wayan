package com.sbw.erst.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Reservation {
	private int ReservationId;
	private int UserId;
	private int SeatId;
	private int SessionId;
	private boolean isPaid;
	public int getReservationId() {
		return ReservationId;
	}
	public void setReservationId(int reservationId) {
		ReservationId = reservationId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getSeatId() {
		return SeatId;
	}
	public void setSeatId(int seatId) {
		SeatId = seatId;
	}
	public int getSessionId() {
		return SessionId;
	}
	public void setSessionId(int sessionId) {
		SessionId = sessionId;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	
	Reservation(int id) {
		setReservationId(id);
        String sql = "select * from reservation where reservationId =" + Integer.toString(id);
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	setUserId(ret.getInt(2));
            	setSeatId(ret.getInt(3));
            	setPaid(ret.getBoolean(4));
            	setSessionId(ret.getInt(5));
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
	}
	
	
}
