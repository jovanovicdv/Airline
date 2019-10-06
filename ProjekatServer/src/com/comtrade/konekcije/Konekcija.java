package com.comtrade.konekcije;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Konekcija {
	public static Konekcija objekat;
	private Connection con;
	private Konekcija () {
		ucitajDriver();
	}
	private void ucitajDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Konekcija vratiObjekat() {
		if(objekat == null) {
			objekat = new Konekcija();
		}
		return objekat;
	}
	
	public void pokreniTransakciju() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/baza_podataka", "root", "");
			con.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void potvrdiTransakciju() {
		try {
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ponistiTransakciju() {
		try {
			con.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void zatvoriKonekciju() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Konekcija getObjekat() {
		return objekat;
	}
	public static void setObjekat(Konekcija objekat) {
		Konekcija.objekat = objekat;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	
	

}
