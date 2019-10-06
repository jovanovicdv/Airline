package com.comtrade.broker;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Korisnik;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.konekcije.Konekcija;

public class BrokerKorisnikLogin implements IBroker {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administrator vratiAdminLogovanje(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpstiDomen vratiKorisnikLogovanje(String email, String password) {
		String sql ="select * from korisnik where email = ? and password = ?";
		PreparedStatement ps;
		ResultSet rs = null;
		Korisnik k = new Korisnik();
		try {
			ps  = Konekcija.vratiObjekat().getCon().prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.first()) {
					k.setKorisnik_id(rs.getInt("korisnik_id"));
					k.setIme(rs.getString("ime"));
					k.setPrezime(rs.getString("prezime"));
					k.setEmail(rs.getString("email"));
					k.setPassword(rs.getString("password"));
					k.setPredjeno_kilometara(rs.getInt("predjeno_kilometara"));
			}else {
				JOptionPane.showMessageDialog(null, "broker korisnik login problem");
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return k;
	}

}
