package com.comtrade.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

public class Korisnik implements OpstiDomen,Serializable{
	private int korisnik_id;
	private String ime;
	private String prezime;
	private String email;
	private String password;
	private int predjeno_kilometara;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Korisnik(int korisnik_id, String ime, String prezime, String email, String password,
			int predjeno_kilometara) {
		super();
		this.korisnik_id = korisnik_id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.password = password;
		this.predjeno_kilometara = predjeno_kilometara;
	}
	public Korisnik() {
		// TODO Auto-generated constructor stub
	}
	
	public int getKorisnik_id() {
		return korisnik_id;
	}
	public void setKorisnik_id(int korisnik_id) {
		this.korisnik_id = korisnik_id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	public int getPredjeno_kilometara() {
		return predjeno_kilometara;
	}
	public void setPredjeno_kilometara(int predjeno_kilometara) {
		this.predjeno_kilometara = predjeno_kilometara;
	}
	
	@Override
	public String vratiVrednostiZaInsert() {
		return " '"+getIme()+"','"+getPrezime()+"','"+getEmail()+"','"+getPassword()+"','"+getPredjeno_kilometara()+"' ";
	}
	@Override
	public String vratiNazivTabele() {
		
		return "korisnik";
	}
	@Override
	public List<OpstiDomen> vratiZaSelect(ResultSet rs) {
		// TODO Auto-generated method stub
		return null;
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
		return " (ime, prezime, email, password, predjeno_kilometara) ";
	}
	
	

}
