package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerIzbrisi;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Administrator;


public class BrisanjeAdministratora extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Administrator a =  (Administrator) mapa.get("administrator");
		IBroker ib = new BrokerIzbrisi();
		ib.obrisi(a, mapa);

	}

}
