package com.comtrade.broker;

import java.sql.Statement;
import java.util.HashMap;
import java.util.List;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.konekcije.Konekcija;
import com.comtrade.transfer.TransferKlasa;

public class BrokerIzbrisi implements IBroker {

	@Override
	public void sacuvaj(OpstiDomen od, Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void izmeni(OpstiDomen od, Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void obrisi(OpstiDomen od, Object obj) {
		String upit ="delete from "+od.vratiNazivTabele()+" where "+od.vratiTabeleZaDelete(od)+"";
		HashMap<String, Object> mapa = (HashMap<String, Object>) obj;
		TransferKlasa tf = new TransferKlasa();
		try {
			Statement st = Konekcija.vratiObjekat().getCon().createStatement();
			st.execute(upit);
			tf.setServerPoruka_odgovor(od.vratiNazivTabele()+" obrisano");
			
		} catch (Exception e) {
			e.printStackTrace();
			tf.setServerPoruka_odgovor(od.vratiNazivTabele()+" ne postoji");
		}
		mapa.put("odgovor", tf);

	}

	@Override
	public List<OpstiDomen> vratiSve(OpstiDomen od) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator vratiAdminLogovanje(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpstiDomen vratiKorisnikLogovanje(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
