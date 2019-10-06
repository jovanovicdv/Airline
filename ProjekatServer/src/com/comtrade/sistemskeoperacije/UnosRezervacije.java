package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerSacuvaj;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Rezervacija;


public class UnosRezervacije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Rezervacija a =  (Rezervacija) mapa.get("rezervacija");
		IBroker ib = new BrokerSacuvaj();
		ib.sacuvaj(a, mapa);

	}

}
