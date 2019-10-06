package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.Linija;
import com.comtrade.domen.Operacije;
import com.comtrade.domen.Rezervacija;
import com.comtrade.kontroler.Kontroler;
import com.comtrade.transfer.TransferKlasa;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Salter_forma extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfBrojKarata;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Aerodrom> listaero = new ArrayList<>();
	private JComboBox cbOdrediste = new JComboBox();
	private List<Linija> listaPrikaz = new ArrayList<>();
	private List<Aviokompanija> listavio = new ArrayList<>();
	private Administrator admin = new Administrator();
	private List<Linija> listaLinija = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Salter_forma frame = new Salter_forma();
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
	public Salter_forma() {
		setTitle("Mica #1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 812, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 776, 351);
		contentPane.add(scrollPane);
		
		
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		postavidtm();
		
		cbOdrediste.setBounds(10, 96, 143, 20);
		contentPane.add(cbOdrediste);
		postaviUcb();
		uzmiKompanije();
		uzmiLinije();
		
		JLabel lblNewLabel = new JLabel("Odrediste");
		lblNewLabel.setBounds(10, 59, 143, 26);
		contentPane.add(lblNewLabel);
		
		tfBrojKarata = new JTextField();
		tfBrojKarata.setBounds(531, 96, 113, 20);
		contentPane.add(tfBrojKarata);
		tfBrojKarata.setColumns(10);
		
		JButton btnRezervisi = new JButton("Rezervisi");
		btnRezervisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rezervisi();
			}
		});
		btnRezervisi.setBounds(654, 95, 132, 23);
		contentPane.add(btnRezervisi);
		
		JLabel lblNewLabel_1 = new JLabel("Broj karata");
		lblNewLabel_1.setBounds(531, 65, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnOsveziTabelu = new JButton("Osvezi tabelu");
		btnOsveziTabelu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				osveziTabelu();
			}
		});
		btnOsveziTabelu.setBounds(185, 95, 121, 23);
		contentPane.add(btnOsveziTabelu);
	}

	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	private void postavidtm() {
	
			Object [] nazivKolona = {"Datum", "Vreme", "Odrediste", "Cena", "Kapacitet", "Duzina u kilometrima", "Aviokompanija"};
			dtm.addColumn(nazivKolona[0]);
			dtm.addColumn(nazivKolona[1]);
			dtm.addColumn(nazivKolona[2]);
			dtm.addColumn(nazivKolona[3]);
			dtm.addColumn(nazivKolona[4]);
			dtm.addColumn(nazivKolona[5]);
			dtm.addColumn(nazivKolona[6]);
			
			
		
		
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
		cbOdrediste.addItem(a.getAerodrom_naziv());
		}
	}

	private void rezervisi() {
		
			int izabranopolje = table.getSelectedRow();
			if (izabranopolje < 0) {
				JOptionPane.showMessageDialog(null, "Molimo Vas izaberite let.");
			} else {
				int stanje = listaPrikaz.get(table.getSelectedRow()).getKapacitet()
						- Integer.parseInt(tfBrojKarata.getText());
				if (Integer.parseInt(tfBrojKarata.getText()) > 10) {
					JOptionPane.showMessageDialog(null, "Broj karata je ogranicen na 10 po rezervaciji.");
				} else if (stanje<0) {
					JOptionPane.showMessageDialog(null, "Nazalost nema dovoljan broj slobodnih mesta.");
				} else {

					
					TransferKlasa tf = new TransferKlasa();
					Linija l = listaPrikaz.get(table.getSelectedRow());
					int novo = l.getKapacitet()-Integer.parseInt(tfBrojKarata.getText());
					l.setKapacitet(novo);
					try {
						
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
			tfBrojKarata.setText("");
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
	
	private void uzmiLinije() {
		Linija linija = new Linija();
		TransferKlasa tf = new TransferKlasa();
		try {
			tf = Kontroler.getInstanca().posaljiPodatke(linija, Operacije.VratiLinije);
			listaLinija  = (List<Linija>) tf.getServerObjekat_odgovor();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void osveziTabelu() {
		dtm.setRowCount(0);
		
		Object [] red = new Object[8];
		listaPrikaz.clear();
		for(Linija l:listaLinija) {
				
					if (l.getPolazak() == admin.getAerodrom_id()
							&& l.getOdrediste() == listaero.get(cbOdrediste.getSelectedIndex()).getAerodrom_id()) {
						red[0] = l.getDatum();
						red[1] = l.getVreme();
						for (Aerodrom a : listaero) {
							
							if (l.getOdrediste() == a.getAerodrom_id()) {
								red[2] = a.getAerodrom_naziv();
							}
						}

						red[3] = l.getCena_karte();
						red[4] = l.getKapacitet();
						red[5] = l.getDuzina();
						for (Aviokompanija a:listavio) {
							if (l.getAviokompanija_id() == a.getAviokompanija_id()) {
								red[6] = a.getAviokompanija_naziv();
							}
						}
						dtm.addRow(red);
						listaPrikaz.add(l);
					}
				
			
		}
		
		
	}
		
	}

