package com.comtrade.sistemskeoperacije;

import java.util.HashMap;


import com.comtrade.broker.BrokerIzmeni;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Linija;

public class IzmenaLinije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Linija a = (Linija) mapa.get("linija");
		IBroker ib = new BrokerIzmeni();
		ib.izmeni(a, mapa);

	}

}
