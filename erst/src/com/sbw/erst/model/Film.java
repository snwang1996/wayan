package com.sbw.erst.model;

import java.sql.SQLException;
import java.sql.ResultSet;  

public class Film {
	private int FilmID;
	private String FilmName;
	private String Description;
	private double Rank;
	
	public int getFilmID() {
		return FilmID;
	}


	public void setFilmID(int filmID) {
		FilmID = filmID;
	}


	public String getFilmName() {
		return FilmName;
	}


	public void setFilmName(String filmName) {
		FilmName = filmName;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public double getRank() {
		return Rank;
	}


	public void setRank(double rank) {
		Rank = rank;
	}


	public Film(int id) {
		setFilmID(id);
        String sql = "select * from film where FilmId =" + Integer.toString(FilmID);
        Starter db1 = new Starter(sql);
        ResultSet ret = null;
        try {  
            ret = db1.pst.executeQuery();
            while (ret.next()) {  
            	setFilmName(ret.getString(2));
            	setDescription(ret.getString(3));
            	setRank(ret.getDouble(4));
            }
            ret.close();  
            db1.close();
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}
	
	
	
}
