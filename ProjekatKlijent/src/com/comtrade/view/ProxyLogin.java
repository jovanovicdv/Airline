 package com.comtrade.view;

import javax.swing.JOptionPane;

import com.comtrade.domen.Administrator;

public class ProxyLogin implements IProxy {

	@Override
	public void login(Administrator a) {
		if(a.getStatus() == 1) {
			Master_admin_forma maf = new Master_admin_forma();
			maf.setVisible(true);
		}else if(a.getStatus() == 3){
			Aviokompanija_forma af = new Aviokompanija_forma();
			af.setAdmin(a);
			af.setVisible(true);
		}else if(a.getStatus() == 2){
			Salter_forma sf = new Salter_forma();
			sf.setAdmin(a);
			sf.setVisible(true);
			
			
		}else {
			JOptionPane.showMessageDialog(null, "proxy login ne postoji taj korisnik");
		}
		
	}

	

	

}
