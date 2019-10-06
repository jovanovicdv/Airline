package com.comtrade.domen;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Rezervacija implements OpstiDomen,Serializable{
	private int rezervacija_id;
	private Date rezervacija_datum;
	private Time rezervacija_vreme;
	private double rezervacija_cena;
	private int linija_id;
	private int korisnik_id;
	private short broj_karata;
	
	
	
	public Rezervacija(int rezervacija_id, Date rezervacija_datum, Time rezervacija_vreme, double rezervacija_cena,
			int let_id, int korisnik_id, short broj_karata) {
		super();
		this.rezervacija_id = rezervacija_id;
		this.rezervacija_datum = rezervacija_datum;
		this.rezervacija_vreme = rezervacija_vreme;
		this.rezervacija_cena = rezervacija_cena;
		this.linija_id = let_id;
		this.korisnik_id = korisnik_id;
		this.broj_karata = broj_karata;
	}
	
	
	
	public Rezervacija() {
		// TODO Auto-generated constructor stub
	}



	public int getRezervacija_id() {
		return rezervacija_id;
	}



	public void setRezervacija_id(int rezervacija_id) {
		this.rezervacija_id = rezervacija_id;
	}



	public Date getRezervacija_datum() {
		return rezervacija_datum;
	}



	public void setRezervacija_datum(Date rezervacija_datum) {
		this.rezervacija_datum = rezervacija_datum;
	}



	public Time getRezervacija_vreme() {
		return rezervacija_vreme;
	}



	public void setRezervacija_vreme(Time rezervacija_vreme) {
		this.rezervacija_vreme = rezervacija_vreme;
	}



	public double getRezervacija_cena() {
		return rezervacija_cena;
	}



	public void setRezervacija_cena(double rezervacija_cena) {
		this.rezervacija_cena = rezervacija_cena;
	}



	public int getLinija_id() {
		return linija_id;
	}



	public void setLinija_id(int let_id) {
		this.linija_id = let_id;
	}



	public int getKorisnik_id() {
		return korisnik_id;
	}



	public void setKorisnik_id(int korisnik_id) {
		this.korisnik_id = korisnik_id;
	}



	public short getBroj_karata() {
		return broj_karata;
	}



	public void setBroj_karata(short broj_karata) {
		this.broj_karata = broj_karata;
	}



	@Override
	public String vratiVrednostiZaInsert() {
		return " '"+getRezervacija_datum()+"','"+getRezervacija_vreme()+"','"+getRezervacija_cena()+"','"+getLinija_id()+"','"+getKorisnik_id()+"','"+getBroj_karata()+"' ";
	}



	@Override
	public String vratiNazivTabele() {
		
		return "rezervacija";
	}



	@Override
	public List<OpstiDomen> vratiZaSelect(ResultSet rs) {
		List<OpstiDomen> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Rezervacija rezervacija = new Rezervacija(rs.getInt("rezervacija_id"), rs.getDate("rezervacija_datum"), rs.getTime("rezervacija_vreme"), rs.getDouble("rezervacija_cena"), rs.getInt("linija_id"), rs.getInt("korisnik_id"), rs.getShort("broj_karata"));
				lista.add(rezervacija);
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "rezervacija klasa vrati select");
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
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String vratiNazivKolona() {
		return " (rezervacija_datum, rezervacija_vreme, rezervacija_cena, linija_id, korisnik_id, broj_karata) ";
	}



	

}
