package com.comtrade.sistemskeoperacije;


import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.BrokerVrati;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Administrator;
import com.comtrade.domen.OpstiDomen;


public class VratiAdmine extends OpstaSistemskaOperacija {

	
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		IBroker ib = new BrokerVrati();
		List<OpstiDomen> listaAdmina= ib.vratiSve(new Administrator());
		mapa.put("lista_objekata", listaAdmina);
	}

}
