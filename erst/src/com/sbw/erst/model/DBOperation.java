package com.sbw.erst.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBOperation {
	private DBOperation() {}
	private static DBOperation dbo = null;
	public static DBOperation getInstance() {
		if (dbo == null) {
			dbo = new DBOperation();
		}
		return dbo;
	}
	public String quote(String input) {
		String ret = "\"" + input + "\"";
		return ret;
	}
	
//insert
	public boolean InsertFilm(String FilmName,String Description,double Rank) {
        String sql = "insert film (FilmName,Description,Rank) value("+quote(FilmName)+","+quote(Description)+","+Rank+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	
	public boolean InsertUser(String UserName,String Email,String PassWord) {
        String sql = "insert user (UserName,Email,PassWord) value("+quote(UserName)+","+quote(Email)+","+quote(PassWord)+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	public boolean InsertCinema(String CinemaName,String Location,String PhoneNum) {
        String sql = "insert cinema (CinemaName,Location,PhoneNum) value("+quote(CinemaName)+","+quote(Location)+","+quote(PhoneNum)+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	public boolean InsertSeat(int SeatId, int RoomId, int isValid) {
        String sql = "insert seat(SeatId,RoomId,isValid) value("+SeatId+","+RoomId+","+isValid+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	public boolean InsertRoom(int RoomId, int CinemaId, String RoomName, int Rows, int Columns) {
        String sql = "insert room (RoomId,CinemaId,RoomName,Rows,Columns) value("+RoomId+","+CinemaId+","+quote(RoomName)+","+Rows+","+Columns+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	for (int i = 0; i < Rows; i++) {
        		for (int j = 0; j < Columns; j++) {
        			getInstance().InsertSeat(RoomId*10000+i*100+j, RoomId, 1);
        		}
        	}
        	return true;
        } else {
        	return false;
        }
	}
	public boolean InsertSession(int FilmId, int RoomId, String BeginTime, String EndTime, double Price) {
        String sql = "insert session(FilmId, RoomId, BeginTime, EndTime, Price) value("+FilmId+","+RoomId+","+quote(BeginTime)+","+quote(EndTime)+","+Price+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	public boolean InsertReservation(int UserId, int SeatId, int SessionId) {
        String sql = "insert reservation(UserId, SeatId, SessionId) value("+UserId+","+SeatId+","+SessionId+")";
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	

//delete
	public boolean DeleteFilm(int FilmID) {
        String sql = "delete from film where FilmId =" +FilmID;
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate(); 
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}
	
	public boolean DeleteUser(int UserID) {
        String sql = "delete from user where UserId =" +UserID;
        Starter db1 = new Starter(sql);
        int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate();
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt == 1) {
        	return true;
        } else {
        	return false;
        }
	}

//update
	public boolean UpdateFilm(Film f) {
		String sql = "update film set " + "FilmName=" + quote(f.getFilmName()) + ",Description=" + quote(f.getDescription()) + ",Rank=" + f.getRank() + " where FilmId =" + f.getFilmID();
		Starter db1 = new Starter(sql);
	    int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate(); 
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt > 0) {
        	return true;
        } else {
        	return false;
        }
	}

	public boolean UpdateUser(User f) {
		String sql = "update user set " + "UserName=" + quote(f.getUserName()) + ",Email=" + quote(f.getEmail()) + ",PassWord=" + quote(f.getPassWord()) + " where UserId =" + f.getUserID();
		Starter db1 = new Starter(sql);
	    int cnt = 0;
        try {  
            cnt = db1.pst.executeUpdate(); 
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        if (cnt > 0) {
        	return true;
        } else {
        	return false;
        }
	}
	
	
//query
	public ArrayList<Film> QueryFilm(String FilmName) {
        String sql = "select FilmId from film where locate("+quote(FilmName)+", FilmName)>0";
        ArrayList<Film> list = new ArrayList<Film>();
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	Film tmp = new Film(ret.getInt(1));
            	list.add(tmp);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;
	}
	public ArrayList<Film> QueryFilm(int filmID) {
        String sql = "select FilmId from film where FilmID="+Integer.valueOf(filmID).toString();
        ArrayList<Film> list = new ArrayList<Film>();
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	Film tmp = new Film(ret.getInt(1));
            	list.add(tmp);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;
	}
	public ArrayList<User> QueryUserByUserName(String UserName) {
        String sql = "select UserId from user where UserName =" +quote(UserName);
        ArrayList<User> list = new ArrayList<User>();
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	User tmp = new User(ret.getInt(1));
            	list.add(tmp);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;
	}
	
	public ArrayList<User> QueryUserByEmail(String Email) {
        String sql = "select UserId from user where Email =" +quote(Email);
        ArrayList<User> list = new ArrayList<User>();
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	User tmp = new User(ret.getInt(1));
            	list.add(tmp);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;
	}
	public ArrayList<Integer> getThreeFilms() {
		String sql = "select FilmId from film order by Rank desc limit 0,3";
        ArrayList<Integer> list = new ArrayList<Integer>();
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	Integer tmp = ret.getInt(1);
            	list.add(tmp);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;
	}
	public ArrayList<Integer> getAllSession(int Filmid) {
        String sql = "select s.sessionid from session s where s.filmid=" + Integer.toString(Filmid) + " order by s.price";
        ArrayList<Integer> list = new ArrayList<Integer>();
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	Integer tmp = ret.getInt(1);
            	list.add(tmp);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return list;
	}
	public int getRoomSize(int RoomId) {
		int rsize = 0;
		String sql = "select Rows,Columns from room where RoomId="+RoomId;
		Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            if (ret.next()) {  
            	Integer tmp = ret.getInt(1);
            	rsize += tmp*100;
            	tmp = ret.getInt(2);
            	rsize += tmp;
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
		return rsize;
	}
	public String getRoomName(int RoomId) {
		String name = "";
		String sql = "select RoomName from room where RoomId="+RoomId;
		Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            if (ret.next()) {  
            	name = ret.getString(1);
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
		return name;
	}
	public boolean isReservationValid(int SessionId, int SeatId) {
		boolean isValid = false;
		String sql = "select * from reservation where SessionId="+SessionId+" and SeatId="+SeatId;
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            if (ret != null && ret.next()) {  
            	isValid = false;
            } else {
            	isValid = true;
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }
        return isValid;
	}
}
