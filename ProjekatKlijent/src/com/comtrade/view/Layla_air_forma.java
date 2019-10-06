package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.Korisnik;
import com.comtrade.domen.Linija;
import com.comtrade.domen.Operacije;
import com.comtrade.domen.Rezervacija;
import com.comtrade.kontroler.Kontroler;
import com.comtrade.transfer.TransferKlasa;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.print.attribute.standard.DateTimeAtProcessing;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioPermission;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Layla_air_forma extends JFrame {

	private JPanel contentPane;
	private JTable tableGost;
	private JTextField tfLoginEmail;
	private JPasswordField pfLoginPassword;
	private JTextField tfRegIme;
	private JTextField tfRegPrezime;
	private JTextField tfRegEmail;
	private JPasswordField pfRegPassword;
	private JTable tableRezervacije;
	private List<Aerodrom> listaero = new ArrayList<>();
	private JComboBox cbPolazak = new JComboBox();
	private JComboBox cbOdrediste = new JComboBox();
	private DefaultTableModel dtmGost = new DefaultTableModel();
	private DefaultTableModel dtmRezervacije = new DefaultTableModel();
	private List<Linija> listaLinija = new ArrayList<>();
	private List<Linija> listaPrikaz = new ArrayList<>();
	private List<Aviokompanija> listavio = new ArrayList<>();
	private JLayeredPane layeredPane = new JLayeredPane();
	private JButton btnLetovi = new JButton("Letovi");
	private JButton btnRegistracija = new JButton("Registracija");
	private JButton btnPrijava = new JButton("Prijavite se");
	private Korisnik korisnik;
	private JTextField tfBrojKarata;
	private List<Rezervacija> listaRezervacija = new ArrayList<>();
	private JLabel lblSlika = new JLabel("");
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Layla_air_forma frame = new Layla_air_forma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Layla_air_forma() {
		setTitle("Layla air");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane.setBounds(10, 70, 614, 440);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Ghost_panel = new JPanel();
		layeredPane.add(Ghost_panel, "name_24165843080700");
		Ghost_panel.setLayout(null);
		layeredPane.setBackground(new Color(0, 0, 0, 0));
		Ghost_panel.setBackground(new Color(0, 0, 0, 0));
		
		
		uzmiLinije();
		
		
		JLabel lblPolazak = new JLabel("Polazak");
		lblPolazak.setForeground(Color.MAGENTA);
		lblPolazak.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPolazak.setBounds(10, 11, 419, 14);
		Ghost_panel.add(lblPolazak);
		
		cbPolazak.setBounds(10, 36, 125, 20);
		Ghost_panel.add(cbPolazak);
		
		postaviUcb();
		
		JLabel lblOdrediste = new JLabel("Odrediste");
		lblOdrediste.setForeground(Color.MAGENTA);
		lblOdrediste.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOdrediste.setBounds(10, 67, 136, 14);
		Ghost_panel.add(lblOdrediste);
		
		cbOdrediste.setBounds(10, 92, 125, 20);
		Ghost_panel.add(cbOdrediste);
		
		
		
		
		JLabel lblImeIPrezime = new JLabel("");
		lblImeIPrezime.setForeground(Color.MAGENTA);
		lblImeIPrezime.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblImeIPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		lblImeIPrezime.setBounds(268, 15, 156, 19);
		contentPane.add(lblImeIPrezime);
		lblImeIPrezime.setVisible(false);
		
		JPanel Rezervacije_panel = new JPanel();
		layeredPane.add(Rezervacije_panel, "name_27556463534500");
		Rezervacije_panel.setLayout(null);
		Rezervacije_panel.setBackground(new Color(0, 0, 0, 0));
		
		JButton btnMojeRezervacije = new JButton("Moje rezervacije");
		btnMojeRezervacije.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				btnLetovi.setVisible(true);
				btnRegistracija.setVisible(true);
				btnPrijava.setVisible(true);
				promenaPanela(Rezervacije_panel);
				postaviUTabeluMoje();
			}

			private void postaviUTabeluMoje() {
				Rezervacija rez = new Rezervacija();
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(rez, Operacije.VratiRezervacije);
					listaRezervacija = (List<Rezervacija>) tf.getServerObjekat_odgovor();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dtmRezervacije.setRowCount(0);
				
				Object [] red = new Object[9];
				
				for(Rezervacija r:listaRezervacija) {
						
							if (r.getKorisnik_id() == korisnik.getKorisnik_id()) {
								for (Linija l:listaLinija) {
									if (l.getLinija_id() == r.getLinija_id()) {
										red[0] = l.getDatum();
										red[1] = l.getVreme();
										for (Aerodrom a:listaero) {
											if (l.getPolazak() == a.getAerodrom_id()) {
												red[2] = a.getAerodrom_naziv();
											}
											if (l.getOdrediste() == a.getAerodrom_id()) {
												red[3] = a.getAerodrom_naziv();
											}
										}
										for (Aviokompanija av:listavio) {
											if (l.getAviokompanija_id() == av.getAviokompanija_id()) {
												red[4] = av.getAviokompanija_naziv();
											} 
										}
									}
								}
								
								red[5] = r.getRezervacija_cena();
								red[6] = r.getBroj_karata();
								red[7] = r.getRezervacija_datum();
								red[8] = r.getRezervacija_vreme();
								dtmRezervacije.addRow(red);
								
							}
						
					
				}
				
			}
		});
		btnMojeRezervacije.setBounds(458, 35, 146, 23);
		Ghost_panel.add(btnMojeRezervacije);
		
		JButton btnRezervisi = new JButton("Rezervisite");
		btnRezervisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unosRezervacije();
			}

			private void unosRezervacije() {
				if (korisnik == null) {
					JOptionPane.showMessageDialog(null, "Niste prijavljeni.");
				}else {
					int izabranopolje = tableGost.getSelectedRow();
					if (izabranopolje < 0) {
						JOptionPane.showMessageDialog(null, "Molimo Vas izaberite let.");
					} else {
						int stanje = listaPrikaz.get(tableGost.getSelectedRow()).getKapacitet()
								- Integer.parseInt(tfBrojKarata.getText());
						if (Integer.parseInt(tfBrojKarata.getText()) > 10) {
							JOptionPane.showMessageDialog(null, "Broj karata je ogranicen na 10 po rezervaciji.");
						} else if (stanje<0) {
							JOptionPane.showMessageDialog(null, "Nazalost nema dovoljan broj slobodnih mesta.");
						} else {

							Rezervacija r = new Rezervacija();
							r.setRezervacija_datum(new Date(System.currentTimeMillis()));
							r.setRezervacija_vreme(new Time(System.currentTimeMillis()));
							r.setRezervacija_cena(listaPrikaz.get(tableGost.getSelectedRow()).getCena_karte()
									* Integer.parseInt(tfBrojKarata.getText()));
							r.setBroj_karata((short) Integer.parseInt(tfBrojKarata.getText()));
							r.setLinija_id(listaPrikaz.get(tableGost.getSelectedRow()).getLinija_id());
							r.setKorisnik_id(korisnik.getKorisnik_id());
							TransferKlasa tf = new TransferKlasa();
							Linija l = listaPrikaz.get(tableGost.getSelectedRow());
							int novo = l.getKapacitet()-Integer.parseInt(tfBrojKarata.getText());
							l.setKapacitet(novo);
							try {
								tf = Kontroler.getInstanca().posaljiPodatke(r, Operacije.UnosRezervacije);
								JOptionPane.showMessageDialog(null, tf.getServerPoruka_odgovor());
								tf = Kontroler.getInstanca().posaljiPodatke(l, Operacije.izmeniLiniju);
								osveziTabelu();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					} 
				}
				
			}
		});
		btnRezervisi.setBounds(458, 91, 146, 23);
		Ghost_panel.add(btnRezervisi);
		
		JScrollPane scrollPaneGost = new JScrollPane();
		scrollPaneGost.setBounds(10, 150, 594, 279);
		Ghost_panel.add(scrollPaneGost);
		
		tableGost = new JTable(dtmGost);
		scrollPaneGost.setViewportView(tableGost);
		postavidtmgost();
		
		
		JButton btnOsveziTabelu = new JButton("Osvezite tabelu");
		btnOsveziTabelu.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				uzmiLinije();
				osveziTabelu();
			}

			
		});
		btnOsveziTabelu.setBounds(161, 91, 118, 23);
		Ghost_panel.add(btnOsveziTabelu);
		
		tfBrojKarata = new JTextField();
		tfBrojKarata.setBounds(328, 92, 118, 20);
		Ghost_panel.add(tfBrojKarata);
		tfBrojKarata.setColumns(10);
		
		JLabel lblBrojKarata = new JLabel("Broj karata:");
		lblBrojKarata.setForeground(Color.MAGENTA);
		lblBrojKarata.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBrojKarata.setBounds(345, 67, 101, 14);
		Ghost_panel.add(lblBrojKarata);
		
		JPanel Login_panel = new JPanel();
		layeredPane.add(Login_panel, "name_24168012020300");
		Login_panel.setLayout(null);
		Login_panel.setBackground(new Color(0, 0, 0, 0));
		
		tfLoginEmail = new JTextField();
		tfLoginEmail.setBounds(115, 169, 300, 20);
		Login_panel.add(tfLoginEmail);
		tfLoginEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setForeground(Color.MAGENTA);
		lblEmail.setBounds(210, 144, 110, 14);
		Login_panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(Color.MAGENTA);
		lblPassword.setBounds(210, 200, 110, 14);
		Login_panel.add(lblPassword);
		
		pfLoginPassword = new JPasswordField();
		pfLoginPassword.setBounds(115, 225, 300, 20);
		Login_panel.add(pfLoginPassword);
		
		JLabel lblLoginOdgovor = new JLabel("Dobrodosli!");
		lblLoginOdgovor.setForeground(Color.MAGENTA);
		lblLoginOdgovor.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblLoginOdgovor.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginOdgovor.setBounds(115, 283, 300, 42);
		lblLoginOdgovor.setVisible(false);
		Login_panel.add(lblLoginOdgovor);
		
		JButton btnLoginPrijava = new JButton("Prijavite se");
		btnLoginPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				korisnikPrijava();
			}

			private void korisnikPrijava() {
				Korisnik k = new Korisnik();
				k.setEmail(tfLoginEmail.getText());
				char[] pass = pfLoginPassword.getPassword();
				k.setPassword(String.valueOf(pass));
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(k, Operacije.VratiZaKorisnikLogin);
					korisnik = (Korisnik) tf.getServerObjekat_odgovor();
					lblLoginOdgovor.setVisible(true);
					lblImeIPrezime.setText(korisnik.getIme()+" "+korisnik.getPrezime());
					lblImeIPrezime.setVisible(true);
					tfLoginEmail.setText("");
					pfLoginPassword.setText("");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "pogresni podaci");
					e.printStackTrace();
				}
				
			}
		});
		btnLoginPrijava.setBounds(210, 256, 110, 23);
		Login_panel.add(btnLoginPrijava);
		
		
		
		JPanel Registracija_panel = new JPanel();
		layeredPane.add(Registracija_panel, "name_24264616689000");
		Registracija_panel.setLayout(null);
		Registracija_panel.setBackground(new Color(0, 0, 0, 0));
		
		JLabel lblRegIme = new JLabel("Ime");
		lblRegIme.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegIme.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegIme.setForeground(Color.MAGENTA);
		lblRegIme.setBounds(210, 40, 110, 14);
		Registracija_panel.add(lblRegIme);
		
		tfRegIme = new JTextField();
		tfRegIme.setBounds(147, 65, 235, 20);
		Registracija_panel.add(tfRegIme);
		tfRegIme.setColumns(10);
		
		JLabel lblRegPrezime = new JLabel("Prezime");
		lblRegPrezime.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegPrezime.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegPrezime.setForeground(Color.MAGENTA);
		lblRegPrezime.setBounds(210, 96, 110, 14);
		Registracija_panel.add(lblRegPrezime);
		
		tfRegPrezime = new JTextField();
		tfRegPrezime.setColumns(10);
		tfRegPrezime.setBounds(147, 121, 235, 20);
		Registracija_panel.add(tfRegPrezime);
		
		JLabel lblRegEmail = new JLabel("E-mail");
		lblRegEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegEmail.setForeground(Color.MAGENTA);
		lblRegEmail.setBounds(210, 152, 110, 14);
		Registracija_panel.add(lblRegEmail);
		
		tfRegEmail = new JTextField();
		tfRegEmail.setBounds(147, 177, 235, 20);
		Registracija_panel.add(tfRegEmail);
		tfRegEmail.setColumns(10);
		
		JLabel lblRegPassword = new JLabel("Password");
		lblRegPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegPassword.setForeground(Color.MAGENTA);
		lblRegPassword.setBounds(210, 208, 110, 14);
		Registracija_panel.add(lblRegPassword);
		
		pfRegPassword = new JPasswordField();
		pfRegPassword.setBounds(147, 233, 235, 20);
		Registracija_panel.add(pfRegPassword);
		
		JButton btnRegRegistracija = new JButton("Registracija");
		btnRegRegistracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unesiKorisnika();
			}

			private void unesiKorisnika() {
				Korisnik k = new Korisnik();
				k.setIme(tfRegIme.getText());
				k.setPrezime(tfRegPrezime.getText());
				k.setEmail(tfRegEmail.getText());
				k.setPassword(String.valueOf(pfRegPassword.getPassword()));
				k.setPredjeno_kilometara(0);
				
					TransferKlasa tf = new TransferKlasa();
					try {
						tf = Kontroler.getInstanca().posaljiPodatke(k, Operacije.UnosKorisnika);
						JOptionPane.showMessageDialog(null, tf.getServerPoruka_odgovor());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				tfRegIme.setText("");
				tfRegPrezime.setText("");
				tfRegEmail.setText("");
				pfRegPassword.setText("");
			}
		});
		btnRegRegistracija.setBounds(210, 336, 110, 23);
		Registracija_panel.add(btnRegRegistracija);
		
		
		
		JLabel lblRezVaseRezervacije = new JLabel("Vase rezervacije:");
		lblRezVaseRezervacije.setForeground(Color.MAGENTA);
		lblRezVaseRezervacije.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRezVaseRezervacije.setBounds(10, 11, 123, 14);
		Rezervacije_panel.add(lblRezVaseRezervacije);
		
		JScrollPane scrollPaneRezervacije = new JScrollPane();
		scrollPaneRezervacije.setBounds(10, 70, 594, 359);
		Rezervacije_panel.add(scrollPaneRezervacije);
		
		tableRezervacije = new JTable(dtmRezervacije);
		scrollPaneRezervacije.setViewportView(tableRezervacije);
		postavidtmrezervacije();
		btnLetovi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLetovi.setVisible(false);
				btnRegistracija.setVisible(true);
				btnPrijava.setVisible(true);
				promenaPanela(Ghost_panel);
			}
		});
		
		btnLetovi.setBounds(10, 11, 89, 23);
		contentPane.add(btnLetovi);
		
		btnRegistracija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLetovi.setVisible(true);
				btnRegistracija.setVisible(false);
				btnPrijava.setVisible(true);
				promenaPanela(Registracija_panel);
			}
		});
		btnRegistracija.setBounds(521, 11, 103, 23);
		contentPane.add(btnRegistracija);
		
		btnPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLetovi.setVisible(true);
				btnPrijava.setVisible(false);
				btnRegistracija.setVisible(true);
				promenaPanela(Login_panel);
				
			}
		});
		btnPrijava.setBounds(408, 11, 103, 23);
		contentPane.add(btnPrijava);
		
		JLabel lblNewLabel = new JLabel("Layla air");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(441, 26, 149, 44);
		contentPane.add(lblNewLabel);
		
		lblSlika.setBounds(0, 0, 635, 520);
		Image slika = new ImageIcon(this.getClass().getResource("/konj.jpg")).getImage();
		lblSlika.setIcon(new ImageIcon(slika));
		contentPane.add(lblSlika);
		
		
		uzmiKompanije();
		btnLetovi.setVisible(false);
		muzikaaa();
	}

	private void muzikaaa() {
		File f = new File(this.getClass().getResource("/tanananananana.wav").getFile());
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(f);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void uzmiLinije() {
		Linija linija = new Linija();
		TransferKlasa tf = new TransferKlasa();
		try {
			tf = Kontroler.getInstanca().posaljiPodatke(linija, Operacije.VratiLinije);
			listaLinija = (List<Linija>) tf.getServerObjekat_odgovor();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void uzmiKompanije() {
		Aviokompanija av = new Aviokompanija();
		TransferKlasa tf = new TransferKlasa();
		try {
			tf = Kontroler.getInstanca().posaljiPodatke(av, Operacije.VratiAviokompanije);
			listavio = (List<Aviokompanija>) tf.getServerObjekat_odgovor();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void postavidtmrezervacije() {
		Object [] nazivKolona = {"Datum", "Vreme", "Polazak", "Odrediste", "Aviokompanija", "Cena", "Broj karata", "Datum rezervacije", "Vreme rezervacije"};
		dtmRezervacije.addColumn(nazivKolona[0]);
		dtmRezervacije.addColumn(nazivKolona[1]);
		dtmRezervacije.addColumn(nazivKolona[2]);
		dtmRezervacije.addColumn(nazivKolona[3]);
		dtmRezervacije.addColumn(nazivKolona[4]);
		dtmRezervacije.addColumn(nazivKolona[5]);
		dtmRezervacije.addColumn(nazivKolona[6]);
		dtmRezervacije.addColumn(nazivKolona[7]);
		dtmRezervacije.addColumn(nazivKolona[8]);
		
	}

	private void postavidtmgost() {
		Object [] nazivKolona = {"Datum", "Vreme", "Polazak", "Odrediste", "Cena", "Kapacitet", "Duzina u kilometrima", "Aviokompanija"};
		dtmGost.addColumn(nazivKolona[0]);
		dtmGost.addColumn(nazivKolona[1]);
		dtmGost.addColumn(nazivKolona[2]);
		dtmGost.addColumn(nazivKolona[3]);
		dtmGost.addColumn(nazivKolona[4]);
		dtmGost.addColumn(nazivKolona[5]);
		dtmGost.addColumn(nazivKolona[6]);
		dtmGost.addColumn(nazivKolona[7]);
		
	}

	private void postaviUcb() {
		Aerodrom ae = new Aerodrom();
		TransferKlasa tf = new TransferKlasa();
		try {
			tf = Kontroler.getInstanca().posaljiPodatke(ae, Operacije.VratiAerodrome);
			listaero = (List<Aerodrom>) tf.getServerObjekat_odgovor();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Aerodrom a:listaero) {
		cbPolazak.addItem(a.getAerodrom_naziv());
		cbOdrediste.addItem(a.getAerodrom_naziv());
		}
	}
	private void promenaPanela(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	private void osveziTabelu() {
		dtmGost.setRowCount(0);
		
		Object [] red = new Object[8];
		listaPrikaz.clear();
		for(Linija l:listaLinija) {
				
					if (l.getPolazak() == listaero.get(cbPolazak.getSelectedIndex()).getAerodrom_id()
							&& l.getOdrediste() == listaero.get(cbOdrediste.getSelectedIndex()).getAerodrom_id()) {
						red[0] = l.getDatum();
						red[1] = l.getVreme();
						for (Aerodrom a : listaero) {
							if (l.getPolazak() == a.getAerodrom_id()) {
								red[2] = a.getAerodrom_naziv();
							}
							if (l.getOdrediste() == a.getAerodrom_id()) {
								red[3] = a.getAerodrom_naziv();
							}
						}

						red[4] = l.getCena_karte();
						red[5] = l.getKapacitet();
						red[6] = l.getDuzina();
						for (Aviokompanija a:listavio) {
							if (l.getAviokompanija_id() == a.getAviokompanija_id()) {
								red[7] = a.getAviokompanija_naziv();
							}
						}
						dtmGost.addRow(red);
						listaPrikaz.add(l);
					}
				
			
		}
		
		
	}
}
