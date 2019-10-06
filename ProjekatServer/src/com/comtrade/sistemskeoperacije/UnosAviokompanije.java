package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerSacuvaj;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;

public class UnosAviokompanije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		Aviokompanija a = (Aviokompanija) mapa.get("aviokompanija");
		IBroker ib = new BrokerSacuvaj();
		ib.sacuvaj(a, mapa);

	}

}
