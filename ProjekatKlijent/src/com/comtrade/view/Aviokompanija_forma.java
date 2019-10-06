package com.comtrade.view;


import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.Linija;
import com.comtrade.domen.Operacije;
import com.comtrade.kontroler.Kontroler;
import com.comtrade.transfer.TransferKlasa;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Time;


import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Aviokompanija_forma extends JFrame {

	private JPanel contentPane;
	private JTextField tfCena;
	private JTextField tfKapacitet;
	private JTextField tfDuzina;
	private DefaultTableModel dtm = new DefaultTableModel();
	private Administrator admin = new Administrator();
	private JTable table;
	private List<Aviokompanija> listavio = new ArrayList<>();
	private List<Linija> listaLinija = new ArrayList<>();
	private List<Aerodrom> listaero = new ArrayList<>();
	private JComboBox cbAerodromPolazak = new JComboBox();
	private JComboBox cbAerodromOdrediste = new JComboBox();
	private JSpinner spinner = new JSpinner();
	private JComboBox cbAerodromTabela = new JComboBox();
	private List<Linija> listaPrikaz = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aviokompanija_forma frame = new Aviokompanija_forma();
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
	public Aviokompanija_forma() {
		setTitle("404 not found");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatum = new JLabel("Datum");
		lblDatum.setBounds(35, 94, 46, 14);
		contentPane.add(lblDatum);
		
		JLabel lblVreme = new JLabel("Vreme");
		lblVreme.setBounds(150, 94, 46, 14);
		contentPane.add(lblVreme);
		
		JLabel lblPolazak = new JLabel("Polazak");
		lblPolazak.setBounds(270, 94, 46, 14);
		contentPane.add(lblPolazak);
		
		JLabel lblOdrediste = new JLabel("Odrediste");
		lblOdrediste.setBounds(390, 94, 67, 14);
		contentPane.add(lblOdrediste);
		
		JLabel lblCena = new JLabel("Cena");
		lblCena.setBounds(510, 94, 46, 14);
		contentPane.add(lblCena);
		
		JLabel lblKapacitet = new JLabel("Kapacitet");
		lblKapacitet.setBounds(630, 94, 46, 14);
		contentPane.add(lblKapacitet);
		
		JLabel lblDuzinaUKilometrima = new JLabel("Duzina u kilometrima");
		lblDuzinaUKilometrima.setBounds(750, 94, 100, 14);
		contentPane.add(lblDuzinaUKilometrima);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(35, 119, 100, 20);
		contentPane.add(dateChooser);
		
		cbAerodromPolazak.setBounds(270, 119, 97, 20);
		contentPane.add(cbAerodromPolazak);
		
		cbAerodromOdrediste.setBounds(390, 119, 97, 20);
		contentPane.add(cbAerodromOdrediste);
		
		tfCena = new JTextField();
		tfCena.setBounds(510, 119, 86, 20);
		contentPane.add(tfCena);
		tfCena.setColumns(10);
		
		tfKapacitet = new JTextField();
		tfKapacitet.setColumns(10);
		tfKapacitet.setBounds(630, 119, 86, 20);
		contentPane.add(tfKapacitet);
		
		tfDuzina = new JTextField();
		tfDuzina.setColumns(10);
		tfDuzina.setBounds(750, 119, 86, 20);
		contentPane.add(tfDuzina);
		
		JButton btnDodajLiniju = new JButton("Dodaj liniju");
		btnDodajLiniju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dodajLiniju();
				tfCena.setText("");
				tfKapacitet.setText("");
				tfDuzina.setText("");
				
			}

			private void dodajLiniju() {
				Linija linija = new Linija();
				linija.setAviokompanija_id(admin.getAviokompanija_id());
				linija.setDatum(new java.sql.Date(dateChooser.getDate().getTime()));
				Date datum = (Date) spinner.getValue();
				linija.setVreme(new Time(datum.getTime()));
				linija.setPolazak(listaero.get(cbAerodromPolazak.getSelectedIndex()).getAerodrom_id());
				linija.setOdrediste(listaero.get(cbAerodromOdrediste.getSelectedIndex()).getAerodrom_id());
				linija.setCena_karte(Double.parseDouble(tfCena.getText()));
				linija.setKapacitet(Integer.parseInt(tfKapacitet.getText()));
				linija.setDuzina(Integer.parseInt(tfDuzina.getText()));
				
					TransferKlasa tf = new TransferKlasa();
					try {
						tf = Kontroler.getInstanca().posaljiPodatke(linija, Operacije.UnosLinije);
						JOptionPane.showMessageDialog(null, tf.getServerPoruka_odgovor());

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
			}
		});
		btnDodajLiniju.setBounds(390, 150, 100, 23);
		contentPane.add(btnDodajLiniju);
		
		JLabel lblAerodrom = new JLabel("Aerodrom");
		lblAerodrom.setBounds(40, 218, 85, 14);
		contentPane.add(lblAerodrom);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 274, 820, 200);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		Object [] nazivKolona = {"Datum", "Vreme", "Polazak", "Odrediste", "Cena", "Kapacitet", "Duzina u kilometrima"};
		dtm.addColumn(nazivKolona[0]);
		dtm.addColumn(nazivKolona[1]);
		dtm.addColumn(nazivKolona[2]);
		dtm.addColumn(nazivKolona[3]);
		dtm.addColumn(nazivKolona[4]);
		dtm.addColumn(nazivKolona[5]);
		dtm.addColumn(nazivKolona[6]);
		
		
		
		JButton btnIzbrisiLiniju = new JButton("Izbrisi liniju");
		btnIzbrisiLiniju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				izbrisiLiniju();
			}

			private void izbrisiLiniju() {
				Linija l = listaPrikaz.get(table.getSelectedRow());
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(l, Operacije.izbrisiLiniju);
					JOptionPane.showMessageDialog(null, tf.getServerPoruka_odgovor());
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnIzbrisiLiniju.setBounds(40, 501, 100, 23);
		contentPane.add(btnIzbrisiLiniju);
		
		vratiAviokompanije();
		
		JLabel lblNazivAviokompanije = new JLabel("New label");
		lblNazivAviokompanije.setHorizontalAlignment(SwingConstants.CENTER);
		lblNazivAviokompanije.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNazivAviokompanije.setBounds(270, 30, 326, 14);
		contentPane.add(lblNazivAviokompanije);
		lblNazivAviokompanije.setText(nazivlabele());
		
		Date ddate = new Date();
		SpinnerDateModel sdm = new SpinnerDateModel(ddate, null, null, Calendar.HOUR_OF_DAY);
		spinner = new JSpinner(sdm);
		JSpinner.DateEditor de = new JSpinner.DateEditor(spinner, "HH:mm");
		spinner.setEditor(de);
		spinner.setBounds(150, 119, 85, 20);
		contentPane.add(spinner);
		
		cbAerodromTabela.setBounds(40, 243, 97, 20);
		contentPane.add(cbAerodromTabela);
		cbAerodromTabela.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				postaviPodatkeUTabelu();
				
			}
		});
		
		dodajUcb();
		
		
	}

	private void dodajUcb() {
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
			cbAerodromOdrediste.addItem(a.getAerodrom_naziv());
			cbAerodromPolazak.addItem(a.getAerodrom_naziv());
			cbAerodromTabela.addItem(a.getAerodrom_naziv());
		}
		
	}

	private String nazivlabele() {
		String naziv = null;
		for(Aviokompanija a:listavio) {
			if(a.getAviokompanija_id() == admin.getAviokompanija_id()) {
				naziv = a.getAviokompanija_naziv();
			}
		}
		return naziv;
	}

	private void vratiAviokompanije() {
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

	private void postaviPodatkeUTabelu() {
		
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
		Object [] red = new Object[7];
		listaPrikaz.clear();
		for(Linija l:listaLinija) {
				if (l.getAviokompanija_id() == admin.getAviokompanija_id()) {
					if (l.getPolazak() == listaero.get(cbAerodromTabela.getSelectedIndex()).getAerodrom_id()
							|| l.getOdrediste() == listaero.get(cbAerodromTabela.getSelectedIndex()).getAerodrom_id()) {
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
						dtm.addRow(red);
						listaPrikaz.add(l);
					}
				} 
			
		}
		
		
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
}
