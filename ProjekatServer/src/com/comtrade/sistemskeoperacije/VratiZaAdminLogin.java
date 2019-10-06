package com.comtrade.sistemskeoperacije;

import java.util.HashMap;
import java.util.List;

import com.comtrade.broker.BrokerAdminLogin;
import com.comtrade.broker.IBroker;
import com.comtrade.domen.Administrator;
import com.comtrade.domen.OpstiDomen;

public class VratiZaAdminLogin extends OpstaSistemskaOperacija{

	@Override
	public void izvrsiKonkretnuOperaciju(Object obj) {
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		IBroker ib = new BrokerAdminLogin();
		Administrator a = (Administrator) mapa.get("admin");
		Administrator a1 = ib.vratiAdminLogovanje(a.getUsername(), a.getPassword());
		mapa.put("admin_odgovor", a1);
		
	}

}
