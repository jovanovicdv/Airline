package com.comtrade.sistemskeoperacije;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.BrokerVrati;
import com.comtrade.broker.IBroker;

import com.comtrade.domen.OpstiDomen;
import com.comtrade.domen.Rezervacija;

public class VratiRezervacije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		IBroker ib = new BrokerVrati();
		List<OpstiDomen> listaLinija= ib.vratiSve(new Rezervacija());
		mapa.put("lista_objekata", listaLinija);

	}

}
