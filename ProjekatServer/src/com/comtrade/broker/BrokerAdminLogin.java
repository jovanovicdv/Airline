package com.comtrade.broker;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.konekcije.Konekcija;

public class BrokerAdminLogin implements IBroker {

	
	

	@Override
	public List<OpstiDomen> vratiSve(OpstiDomen od) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator vratiAdminLogovanje(String username, String password) {
		String sql ="select * from administrator where username = ? and password = ?";
		PreparedStatement ps;
		ResultSet rs = null;
		Administrator a = new Administrator();
		try {
			ps  = Konekcija.vratiObjekat().getCon().prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.first()) {
					a.setAdministrator_id(rs.getInt("administrator_id"));
					a.setAerodrom_id(rs.getInt("aerodrom_id"));
					a.setAviokompanija_id(rs.getInt("aviokompanija_id"));
					a.setUsername(rs.getString("username"));
					a.setPassword(rs.getString("password"));
					a.setStatus(rs.getShort("status"));
			}else {
				JOptionPane.showMessageDialog(null, "broker admin login problem");
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return a;
	}

	@Override
	public OpstiDomen vratiKorisnikLogovanje(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

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

	

}
