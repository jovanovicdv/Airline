package com.comtrade.kontroler;

import java.io.IOException;

import javax.swing.JOptionPane;

import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Operacije;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.komunikacija.Komunikacija;
import com.comtrade.transfer.TransferKlasa;

public class Kontroler {
	public static Kontroler instanca;
	private Kontroler() {
		
	}
	public static Kontroler getInstanca() {
		if(instanca == null)
			instanca = new Kontroler();
		
		return instanca;
	}
	public TransferKlasa posaljiPodatke(OpstiDomen op, int operacija) throws ClassNotFoundException, IOException {
		TransferKlasa tf = new TransferKlasa();
		tf.setOperacija(operacija);
		tf.setKlijent_objekat(op);
		Komunikacija.getInstanca().posalji(tf);
		TransferKlasa odgovor = Komunikacija.getInstanca().procitaj();
		return odgovor;
		
	}
	
	
	

}
