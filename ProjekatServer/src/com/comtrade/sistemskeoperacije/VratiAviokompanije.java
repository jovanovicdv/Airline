package com.comtrade.sistemskeoperacije;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.BrokerVrati;
import com.comtrade.broker.IBroker;

import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.OpstiDomen;

public class VratiAviokompanije extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		IBroker ib = new BrokerVrati();
		List<OpstiDomen> listaAviokompanija= ib.vratiSve(new Aviokompanija());
		mapa.put("lista_objekata", listaAviokompanija);

	}

}
