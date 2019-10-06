package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerIzbrisi;
import com.comtrade.broker.IBroker;

import com.comtrade.domen.Aviokompanija;

public class BrisanjeAviokompanije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Aviokompanija a = (Aviokompanija) mapa.get("aviokompanija");
		IBroker ib = new BrokerIzbrisi();
		ib.obrisi(a, mapa);

	}

}
