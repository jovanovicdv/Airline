package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Administrator implements OpstiDomen,Serializable{
	private int administrator_id;
	private String username;
	private String password;
	private short status;
	private int aerodrom_id;
	private int aviokompanija_id;
	public Administrator(int administrator_id, String username, String password, short status, int aerodrom_id,
			int aviokompanija_id) {
		super();
		this.administrator_id = administrator_id;
		this.username = username;
		this.password = password;
		this.status = status;
		this.aerodrom_id = aerodrom_id;
		this.aviokompanija_id = aviokompanija_id;
	}
	public Administrator() {
		// TODO Auto-generated constructor stub
	}
	public int getAdministrator_id() {
		return administrator_id;
	}
	public void setAdministrator_id(int administrator_id) {
		this.administrator_id = administrator_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public int getAerodrom_id() {
		return aerodrom_id;
	}
	public void setAerodrom_id(int aerodrom_id) {
		this.aerodrom_id = aerodrom_id;
	}
	public int getAviokompanija_id() {
		return aviokompanija_id;
	}
	public void setAviokompanija_id(int aviokompanija_id) {
		this.aviokompanija_id = aviokompanija_id;
	}
	
	
	@Override
	public String vratiNazivTabele() {
		
		return "administrator";
	}
	
	
	@Override
	public String vratiVrednostiZaInsert() {
		if(getAerodrom_id() == 0) {
			return " '"+getUsername()+"','"+getPassword()+"','"+getStatus()+"','"+getAviokompanija_id()+"' ";
		}else if(getAviokompanija_id() == 0){
			return " '"+getUsername()+"','"+getPassword()+"','"+getStatus()+"','"+getAerodrom_id()+"' ";
		}else {
			return " '"+getUsername()+"','"+getPassword()+"','"+getStatus()+"','"+getAerodrom_id()+"','"+getAviokompanija_id()+"' ";
		}
		
	}
	@Override
	public List<OpstiDomen> vratiZaSelect(ResultSet rs) {
		List<OpstiDomen> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Administrator admin = new Administrator(rs.getInt("administrator_id"), rs.getString("username"),
						rs.getString("password"), rs.getShort("status"), rs.getInt("aerodrom_id"),
						rs.getInt("aviokompanija_id"));
				lista.add(admin);
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "admin klasa vrati select");
		}
		return lista;
	}
	@Override
	public String vratiTabeleZaUpdate(OpstiDomen od) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String vratiTabeleZaDelete(OpstiDomen od) {
		
		return "administrator_id ='"+getAdministrator_id()+"'";
	}
	@Override
	public String vratiNazivKolona() {
		
		if(getAerodrom_id() == 0) {
			return " (username, password, status, aviokompanija_id) ";
		}else if(getAviokompanija_id() == 0){
			return " (username, password, status, aerodrom_id) ";
		}else {
			return " (username, password, status, aerodrom_id, aviokompanija_id) ";
		}
		
	}
	
	

}
