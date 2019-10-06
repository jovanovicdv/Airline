package com.comtrade.niti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.Korisnik;
import com.comtrade.domen.Linija;
import com.comtrade.domen.Operacije;
import com.comtrade.domen.Rezervacija;
import com.comtrade.kontroler.Kontroler;
import com.comtrade.transfer.TransferKlasa;


public class NitObrade extends Thread {
	private Socket soket;
	
	public Socket getSoket() {
		return soket;
	}

	public void setSoket(Socket soket) {
		this.soket = soket;
	}
	
	public void run () {
		
		while (true) {
			try {
				ObjectInputStream inSoket= new ObjectInputStream(soket.getInputStream());
				TransferKlasa tf = (TransferKlasa) inSoket.readObject();
				obradiZahtev(tf);
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	private void obradiZahtev(TransferKlasa tf) {
		switch (tf.getOperacija()) {
		case Operacije.VratiZaAdminLogin:
			Administrator a1 = (Administrator) tf.getKlijent_objekat();
			TransferKlasa tf1 = new TransferKlasa();
			try {
				tf1 = Kontroler.getInstanca().vratiZaAdminLogin(a1);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			posalji(tf1);
			break;
			
		
			
		case Operacije.UnosAdmina:
			Administrator a2 = (Administrator) tf.getKlijent_objekat();
			TransferKlasa tf2 = new TransferKlasa();
			try {
				
				tf2 = Kontroler.getInstanca().unesiAdmina(a2);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf2);
			break;
			
		case Operacije.VratiAerodrome:
			TransferKlasa odgovor = new TransferKlasa();
			try {
				List<Aerodrom> listaAerodroma = Kontroler.getInstanca().vratiAerodrome();
				odgovor.setServerObjekat_odgovor(listaAerodroma);
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(odgovor);
			break;
		
		case Operacije.UnosAerodroma:
			Aerodrom a3 =  (Aerodrom) tf.getKlijent_objekat();
			TransferKlasa tf3 = new TransferKlasa();
			try {
				
				tf3 = Kontroler.getInstanca().unesiAerodrom(a3);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf3);
			break;
			
		case Operacije.UnosAviokompanije:
			Aviokompanija a4 =   (Aviokompanija) tf.getKlijent_objekat();
			TransferKlasa tf4 = new TransferKlasa();
			try {
				
				tf4 = Kontroler.getInstanca().unesiAviokompaniju(a4);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf4);
			break;
			
		case Operacije.VratiAviokompanije:
			TransferKlasa tf5 = new TransferKlasa();
			try {
				List<Aviokompanija> listaAviokompanija = Kontroler.getInstanca().vratiAviokompanije();
				tf5.setServerObjekat_odgovor(listaAviokompanija);
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf5);
			break;
			
		case Operacije.izbrisiAerodrom:
			Aerodrom a6 =  (Aerodrom) tf.getKlijent_objekat();
			TransferKlasa tf6 = new TransferKlasa();
			try {
				
				tf6 = Kontroler.getInstanca().izbrisiAerodrom(a6);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf6);
			break;
			
		case Operacije.izbrisiAviokompaniju:
			Aviokompanija a7 =   (Aviokompanija) tf.getKlijent_objekat();
			TransferKlasa tf7 = new TransferKlasa();
			try {
				
				tf7 = Kontroler.getInstanca().izbrisiAviokompaniju(a7);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf7);
			break;	
		
		case Operacije.VratiAdministratore:
			TransferKlasa tf8 = new TransferKlasa();
			try {
				List<Administrator> listaAviokompanija = Kontroler.getInstanca().vratiAdmine();
				tf8.setServerObjekat_odgovor(listaAviokompanija);
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf8);
			break;	
			
		case Operacije.izbrisiAdministratora:
			Administrator a9 =   (Administrator) tf.getKlijent_objekat();
			TransferKlasa tf9 = new TransferKlasa();
			try {
				
				tf9 = Kontroler.getInstanca().izbrisiAdministratora(a9);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf9);
			break;
			
		case Operacije.VratiLinije:
			TransferKlasa tf10 = new TransferKlasa();
			try {
				List<Linija> listaLinija = Kontroler.getInstanca().vratiLinije();
				tf10.setServerObjekat_odgovor(listaLinija);
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf10);
			break;
			
		case Operacije.UnosLinije:
			Linija a11 =   (Linija) tf.getKlijent_objekat();
			TransferKlasa tf11 = new TransferKlasa();
			try {
				
				tf11 = Kontroler.getInstanca().unesiLiniju(a11);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf11);
			break;
			
		case Operacije.izbrisiLiniju:
			Linija a12 =   (Linija) tf.getKlijent_objekat();
			TransferKlasa tf12 = new TransferKlasa();
			try {
				
				tf12 = Kontroler.getInstanca().izbrisiLiniju(a12);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf12);
			break;
			
		case Operacije.UnosKorisnika:
			Korisnik a13 = (Korisnik) tf.getKlijent_objekat();
			TransferKlasa tf13 = new TransferKlasa();
			try {
				
				tf13 = Kontroler.getInstanca().unesiKorisnika(a13);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf13);
			break;
			
		case Operacije.UnosRezervacije:
			Rezervacija a14 =  (Rezervacija) tf.getKlijent_objekat();
			TransferKlasa tf14 = new TransferKlasa();
			try {
				
				tf14 = Kontroler.getInstanca().unesiRezervaciju(a14);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf14);
			break;
			
		case Operacije.VratiRezervacije:
			TransferKlasa tf15 = new TransferKlasa();
			try {
				List<Rezervacija> listaRezervacija = Kontroler.getInstanca().vratiRezervacije();
				tf15.setServerObjekat_odgovor(listaRezervacija);
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf15);
			break;
			
		case Operacije.VratiZaKorisnikLogin:
			Korisnik a16 =  (Korisnik) tf.getKlijent_objekat();
			TransferKlasa tf16 = new TransferKlasa();
			try {
				tf16 = Kontroler.getInstanca().vratiZaKorisnikLogin(a16);
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			posalji(tf16);
			break;
			
		case Operacije.izmeniLiniju:
			Linija a17 =   (Linija) tf.getKlijent_objekat();
			TransferKlasa tf17= new TransferKlasa();
			try {
				
				tf17 = Kontroler.getInstanca().izmeniLiniju(a17);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			posalji(tf17);
			break;

		default:
			break;
		}
		
	}

	private void posalji(TransferKlasa tf1) {
		try {
			ObjectOutputStream outSoket = new ObjectOutputStream(soket.getOutputStream());
			outSoket.writeObject(tf1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
