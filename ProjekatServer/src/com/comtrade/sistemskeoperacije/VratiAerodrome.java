package com.comtrade.sistemskeoperacije;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.BrokerVrati;
import com.comtrade.broker.IBroker;

import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.OpstiDomen;

public class VratiAerodrome extends OpstaSistemskaOperacija {

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		IBroker ib = new BrokerVrati();
		List<OpstiDomen> listaAerodroma= ib.vratiSve(new Aerodrom());
		mapa.put("lista_objekata", listaAerodroma);

	}

}
