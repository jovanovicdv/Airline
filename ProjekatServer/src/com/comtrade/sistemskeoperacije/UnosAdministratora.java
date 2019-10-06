package com.comtrade.sistemskeoperacije;

import java.util.HashMap;

import com.comtrade.broker.BrokerSacuvaj;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Administrator;

public class UnosAdministratora extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
			Administrator a = (Administrator) mapa.get("admin");
			IBroker ib = new BrokerSacuvaj();
			ib.sacuvaj(a,mapa);
		

	}

}
