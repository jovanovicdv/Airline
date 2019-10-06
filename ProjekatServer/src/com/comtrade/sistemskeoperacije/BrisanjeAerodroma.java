package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerIzbrisi;

import com.comtrade.broker.IBroker;
import com.comtrade.domen.Aerodrom;

public class BrisanjeAerodroma extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Aerodrom a = (Aerodrom) mapa.get("aerodrom");
		IBroker ib = new BrokerIzbrisi();
		ib.obrisi(a, mapa);

	}

}
