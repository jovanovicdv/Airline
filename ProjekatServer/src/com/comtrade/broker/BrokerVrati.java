package com.comtrade.broker;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.konekcije.Konekcija;

public class BrokerVrati implements IBroker{

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OpstiDomen> vratiSve(OpstiDomen od) {
		String upit ="select * from "+od.vratiNazivTabele();
		List<OpstiDomen>list = null;
		try {
			Statement st = Konekcija.vratiObjekat().getCon().createStatement();
			st.execute(upit);
			ResultSet rs = st.executeQuery(upit);
			list = od.vratiZaSelect(rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "broker vrati problem");
		}
		return list;
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
