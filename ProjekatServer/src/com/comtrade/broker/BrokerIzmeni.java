package com.comtrade.broker;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Linija;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.konekcije.Konekcija;

public class BrokerIzmeni implements IBroker{

	@Override
	public void sacuvaj(OpstiDomen od, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void izmeni(OpstiDomen od, Object obj) {
		String sqlIzmeni = "update linija set kapacitet = ?  where linija_id  = ?";
		PreparedStatement ps;
		Linija l = (Linija) od;
		try {
			ps = Konekcija.vratiObjekat().getCon().prepareStatement(sqlIzmeni);
			ps.setInt(1, l.getKapacitet());
			ps.setInt(2, l.getLinija_id());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void obrisi(OpstiDomen od, Object obj) {
		// TODO Auto-generated method stub
		
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
