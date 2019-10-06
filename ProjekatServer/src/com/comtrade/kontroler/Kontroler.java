package com.comtrade.kontroler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.Korisnik;
import com.comtrade.domen.Linija;
import com.comtrade.domen.OpstiDomen;
import com.comtrade.domen.Rezervacija;
import com.comtrade.sistemskeoperacije.BrisanjeAdministratora;
import com.comtrade.sistemskeoperacije.BrisanjeAerodroma;
import com.comtrade.sistemskeoperacije.BrisanjeAviokompanije;
import com.comtrade.sistemskeoperacije.BrisanjeLinije;
import com.comtrade.sistemskeoperacije.IzmenaLinije;
import com.comtrade.sistemskeoperacije.OpstaSistemskaOperacija;
import com.comtrade.sistemskeoperacije.UnosAdministratora;
import com.comtrade.sistemskeoperacije.UnosAerodroma;
import com.comtrade.sistemskeoperacije.UnosAviokompanije;
import com.comtrade.sistemskeoperacije.UnosKorisnika;
import com.comtrade.sistemskeoperacije.UnosLinije;
import com.comtrade.sistemskeoperacije.UnosRezervacije;
import com.comtrade.sistemskeoperacije.VratiAdmine;
import com.comtrade.sistemskeoperacije.VratiAerodrome;
import com.comtrade.sistemskeoperacije.VratiAviokompanije;
import com.comtrade.sistemskeoperacije.VratiLinije;
import com.comtrade.sistemskeoperacije.VratiRezervacije;
import com.comtrade.sistemskeoperacije.VratiZaAdminLogin;
import com.comtrade.sistemskeoperacije.VratiZaKorisnikLogin;
import com.comtrade.transfer.TransferKlasa;

public class Kontroler {
	private static volatile Kontroler instanca;
	private static Object mutex = new Object();
	public synchronized static Kontroler getInstanca() {
		Kontroler result = instanca;
		synchronized (mutex) {
			result = instanca;
			if (result == null) {
				instanca = result = new Kontroler();
			}
		}
		return result;
	}
	
	public List<Administrator> vratiAdmine() {
		Map<String, Object> mapa = new HashMap<>();
		OpstaSistemskaOperacija oso = new VratiAdmine();
		List<Administrator>list = new ArrayList<>();
		oso.izvrsiSistemskuOperaciju(mapa);
		list = (List<Administrator>) mapa.get("lista_objekata");
		return list;
	}
	
	public TransferKlasa unesiAdmina (OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("admin", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new UnosAdministratora();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public TransferKlasa vratiZaAdminLogin(Administrator a1) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("admin", a1);
		OpstaSistemskaOperacija oso = new VratiZaAdminLogin();
		oso.izvrsiSistemskuOperaciju(mapa);
		TransferKlasa tf = new TransferKlasa();
		tf.setServerObjekat_odgovor(mapa.get("admin_odgovor"));
		
		
		return tf;
		
	}
	
	public List<Aerodrom> vratiAerodrome() {
		Map<String, Object> mapa = new HashMap<>();
		OpstaSistemskaOperacija oso = new VratiAerodrome();
		List<Aerodrom>list = new ArrayList<>();
		oso.izvrsiSistemskuOperaciju(mapa);
		list = (List<Aerodrom>) mapa.get("lista_objekata");
		return list;
	}

	public TransferKlasa unesiAerodrom(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("aerodrom", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new UnosAerodroma();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
		
	}

	public TransferKlasa unesiAviokompaniju(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("aviokompanija", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new UnosAviokompanije();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
		
	}

	public List<Aviokompanija> vratiAviokompanije() {
		Map<String, Object> mapa = new HashMap<>();
		OpstaSistemskaOperacija oso = new VratiAviokompanije();
		List<Aviokompanija>list = new ArrayList<>();
		oso.izvrsiSistemskuOperaciju(mapa);
		list =  (List<Aviokompanija>) mapa.get("lista_objekata");
		return list;
	}

	public TransferKlasa izbrisiAerodrom(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("aerodrom", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new BrisanjeAerodroma();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public TransferKlasa izbrisiAviokompaniju(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("aviokompanija", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new BrisanjeAviokompanije();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public TransferKlasa izbrisiAdministratora(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("administrator", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new BrisanjeAdministratora();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public List<Linija> vratiLinije() {
		Map<String, Object> mapa = new HashMap<>();
		OpstaSistemskaOperacija oso = new VratiLinije();
		List<Linija>list = new ArrayList<>();
		oso.izvrsiSistemskuOperaciju(mapa);
		list =  (List<Linija>) mapa.get("lista_objekata");
		return list;
	}

	public TransferKlasa unesiLiniju(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("linija", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new UnosLinije();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public TransferKlasa izbrisiLiniju(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("linija", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new BrisanjeLinije();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public TransferKlasa unesiKorisnika(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("korisnik", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new UnosKorisnika();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public TransferKlasa unesiRezervaciju(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("rezervacija", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new UnosRezervacije();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

	public List<Rezervacija> vratiRezervacije() {
		Map<String, Object> mapa = new HashMap<>();
		OpstaSistemskaOperacija oso = new VratiRezervacije();
		List<Rezervacija>list = new ArrayList<>();
		oso.izvrsiSistemskuOperaciju(mapa);
		list =   (List<Rezervacija>) mapa.get("lista_objekata");
		return list;
	}

	public TransferKlasa vratiZaKorisnikLogin(Korisnik k) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("korisnik", k);
		OpstaSistemskaOperacija oso = new VratiZaKorisnikLogin();
		oso.izvrsiSistemskuOperaciju(mapa);
		TransferKlasa tf = new TransferKlasa();
		tf.setServerObjekat_odgovor(mapa.get("korisnik_odgovor"));
		
		
		return tf;
	}

	public TransferKlasa izmeniLiniju(OpstiDomen od) {
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("linija", od);
		TransferKlasa tf = new TransferKlasa();
		OpstaSistemskaOperacija oso = new IzmenaLinije();
		oso.izvrsiSistemskuOperaciju(mapa);
		return tf = (TransferKlasa) mapa.get("odgovor");
	}

}
