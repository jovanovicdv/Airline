package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerIzbrisi;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Linija;


public class BrisanjeLinije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Linija a = (Linija) mapa.get("linija");
		IBroker ib = new BrokerIzbrisi();
		ib.obrisi(a, mapa);

	}

}
