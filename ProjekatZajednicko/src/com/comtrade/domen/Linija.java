package com.comtrade.domen;

import java.io.Serializable;

import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.swing.JOptionPane;

public class Linija implements OpstiDomen,Serializable{
	private int linija_id;
	private int duzina;
	private Date datum;
	private Time vreme;
	private int polazak;
	private int odrediste;
	private double cena_karte;
	private int kapacitet;
	private int aviokompanija_id;
	
	
	
	
	
	
	
	public Linija(int linija_id, int duzina, Date datum, Time vreme, int polazak, int odrediste, double cena_karte,
			int kapacitet, int aviokompanija_id) {
		super();
		this.linija_id = linija_id;
		this.duzina = duzina;
		this.datum = datum;
		this.vreme = vreme;
		this.polazak = polazak;
		this.odrediste = odrediste;
		this.cena_karte = cena_karte;
		this.kapacitet = kapacitet;
		this.aviokompanija_id = aviokompanija_id;
	}



	public Linija() {
		// TODO Auto-generated constructor stub
	}



	public int getLinija_id() {
		return linija_id;
	}



	public void setLinija_id(int linija_id) {
		this.linija_id = linija_id;
	}



	public int getDuzina() {
		return duzina;
	}



	public void setDuzina(int duzina) {
		this.duzina = duzina;
	}



	public Date getDatum() {
		return datum;
	}



	public void setDatum(Date datum) {
		this.datum = datum;
	}



	public Time getVreme() {
		return vreme;
	}



	public void setVreme(Time vreme) {
		this.vreme = vreme;
	}



	public int getPolazak() {
		return polazak;
	}



	public void setPolazak(int polazak) {
		this.polazak = polazak;
	}



	public int getOdrediste() {
		return odrediste;
	}



	public void setOdrediste(int odrediste) {
		this.odrediste = odrediste;
	}

	


	public double getCena_karte() {
		return cena_karte;
	}



	public void setCena_karte(double cena_karte) {
		this.cena_karte = cena_karte;
	}



	public int getKapacitet() {
		return kapacitet;
	}



	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	



	public int getAviokompanija_id() {
		return aviokompanija_id;
	}



	public void setAviokompanija_id(int aviokompanija_id) {
		this.aviokompanija_id = aviokompanija_id;
	}



	@Override
	public String vratiVrednostiZaInsert() {
		
		return " '"+getDuzina()+"','"+getDatum()+"','"+getVreme()+"','"+getPolazak()+"','"+getOdrediste()+"','"+getCena_karte()+"','"+getKapacitet()+"','"+getAviokompanija_id()+"' ";
	}



	@Override
	public String vratiNazivTabele() {
		
		return "linija";
	}



	@Override
	public List<OpstiDomen> vratiZaSelect(ResultSet rs) {
		List<OpstiDomen> lista = new ArrayList<>();
		try {
			while (rs.next()) {
				Linija linija = new Linija(rs.getInt("linija_id"), rs.getInt("duzina"), rs.getDate("datum"), rs.getTime("vreme"), rs.getInt("polazak"), rs.getInt("odrediste"), rs.getDouble("cena_karte"), rs.getInt("kapacitet"), rs.getInt("aviokompanija_id"));
				lista.add(linija);
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "linija klasa vrati select");
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
		
		return "linija_id ='"+getLinija_id()+"'";
	}



	@Override
	public String vratiNazivKolona() {
		
		return " (duzina, datum, vreme, polazak, odrediste, cena_karte, kapacitet, aviokompanija_id) ";
	}



	

}
