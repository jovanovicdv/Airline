 package com.comtrade.sistemskeoperacije;

import javax.swing.JOptionPane;

import com.comtrade.konekcije.Konekcija;

public abstract class OpstaSistemskaOperacija {
	
	public void izvrsiSistemskuOperaciju (Object obj) {
		try {
			pokreniTransakciju();
			izvrsiKonkretnuOperaciju(obj);
			potvrdiTransakciju();
		} catch (Exception e) {
			ponistiTransakciju();
			JOptionPane.showMessageDialog(null, "transakcija nije uspela");
		}finally {
			zatvoriKonekciju();
		}
	}

	

	private void zatvoriKonekciju() {
		Konekcija.vratiObjekat().zatvoriKonekciju();
		
	}



	private void ponistiTransakciju() {
		Konekcija.vratiObjekat().ponistiTransakciju();
		
	}



	private void potvrdiTransakciju() {
		Konekcija.vratiObjekat().potvrdiTransakciju();
		
	}



	public abstract void izvrsiKonkretnuOperaciju(Object obj);
	
	private void pokreniTransakciju() {
		Konekcija.vratiObjekat().pokreniTransakciju();
		
		
	}
	
	
}