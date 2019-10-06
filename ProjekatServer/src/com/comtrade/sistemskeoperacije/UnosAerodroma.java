package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerSacuvaj;
import com.comtrade.broker.IBroker;

import com.comtrade.domen.Aerodrom;

public class UnosAerodroma extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Aerodrom a = (Aerodrom) mapa.get("aerodrom");
		IBroker ib = new BrokerSacuvaj();
		ib.sacuvaj(a, mapa);

	}

}
