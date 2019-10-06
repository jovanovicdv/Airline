package com.comtrade.broker;

import java.util.List;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.OpstiDomen;

public interface IBroker {
	public void sacuvaj(OpstiDomen od, Object obj);
	public void izmeni(OpstiDomen od, Object obj);
	public void obrisi(OpstiDomen od, Object obj);
	public List<OpstiDomen> vratiSve(OpstiDomen od);
	public Administrator vratiAdminLogovanje(String username, String password);
	public OpstiDomen  vratiKorisnikLogovanje(String username, String password);

}
