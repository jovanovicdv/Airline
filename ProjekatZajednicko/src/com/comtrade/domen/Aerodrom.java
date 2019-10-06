package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Aerodrom implements OpstiDomen,Serializable{
	private int aerodrom_id;
	private String aerodrom_naziv;

	public Aerodrom(int aerodrom_id, String aerodrom_naziv) {
		super();
		this.aerodrom_id = aerodrom_id;
		this.aerodrom_naziv = aerodrom_naziv;
	}
	public Aerodrom() {
		// TODO Auto-generated constructor stub
	}
	public int getAerodrom_id() {
		return aerodrom_id;
	}
	public void setAerodrom_id(int aerodrom_id) {
		this.aerodrom_id = aerodrom_id;
	}
	public String getAerodrom_naziv() {
		return aerodrom_naziv;
	}
	public void setAerodrom_naziv(String aerodrom_naziv) {
		this.aerodrom_naziv = aerodrom_naziv;
	}

	

	@Override
	public String vratiVrednostiZaInsert() {
		
		return " '"+getAerodrom_naziv()+"' ";
	}
	@Override
	public String vratiNazivTabele() {
		
		return "aerodrom";
	}
	@Override
	public List<OpstiDomen> vratiZaSelect(ResultSet rs) {
		List<OpstiDomen> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Aerodrom aero = new Aerodrom(rs.getInt("aerodrom_id"), rs.getString("aerodrom_naziv"));
				lista.add(aero);
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
		
		return "aerodrom_id ='"+getAerodrom_id()+"'";
	}
	@Override
	public String vratiNazivKolona() {
		
		return " (aerodrom_naziv) ";
	}
	
	
	

}
