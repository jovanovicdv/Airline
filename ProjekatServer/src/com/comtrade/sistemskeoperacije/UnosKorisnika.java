package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerSacuvaj;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Korisnik;


public class UnosKorisnika extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Korisnik a =  (Korisnik) mapa.get("korisnik");
		IBroker ib = new BrokerSacuvaj();
		ib.sacuvaj(a,mapa);

	}

}
