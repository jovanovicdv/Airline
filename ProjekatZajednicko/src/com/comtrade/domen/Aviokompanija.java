package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Aviokompanija implements OpstiDomen,Serializable{
	private int aviokompanija_id;
	private String aviokompanija_naziv;
	
	
	
	public int getAviokompanija_id() {
		return aviokompanija_id;
	}
	public void setAviokompanija_id(int aviokompanija_id) {
		this.aviokompanija_id = aviokompanija_id;
	}
	public String getAviokompanija_naziv() {
		return aviokompanija_naziv;
	}
	public void setAviokompanija_naziv(String aviokompanija_naziv) {
		this.aviokompanija_naziv = aviokompanija_naziv;
	}
	
	public Aviokompanija(int aviokompanija_id, String aviokompanija_naziv) {
		super();
		this.aviokompanija_id = aviokompanija_id;
		this.aviokompanija_naziv = aviokompanija_naziv;
		
	}
	public Aviokompanija() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String vratiVrednostiZaInsert() {
		
		return " '"+getAviokompanija_naziv()+"' ";
	}
	@Override
	public String vratiNazivTabele() {
		
		return "aviokompanija";
	}
	@Override
	public List<OpstiDomen> vratiZaSelect(ResultSet rs) {
		List<OpstiDomen> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Aviokompanija ak = new Aviokompanija(rs.getInt("aviokompanija_id"), rs.getString("aviokompanija_naziv"));
				lista.add(ak);
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "aero klasa vrati select");
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
		
		return "aviokompanija_id ='"+getAviokompanija_id()+"'";
	}
	@Override
	public String vratiNazivKolona() {
		
		return " (aviokompanija_naziv) ";
	}
	
	
	

}
