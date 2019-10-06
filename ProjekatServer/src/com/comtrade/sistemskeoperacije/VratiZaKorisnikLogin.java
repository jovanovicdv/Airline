package com.comtrade.sistemskeoperacije;

import java.util.HashMap;


import com.comtrade.broker.BrokerKorisnikLogin;
import com.comtrade.broker.IBroker;

import com.comtrade.domen.Korisnik;
import com.comtrade.domen.OpstiDomen;

public class VratiZaKorisnikLogin extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		IBroker ib = new BrokerKorisnikLogin();
		Korisnik a = (Korisnik) mapa.get("korisnik");
		OpstiDomen a1 = ib.vratiKorisnikLogovanje(a.getEmail(), a.getPassword());
		mapa.put("korisnik_odgovor", a1);

	}

}
