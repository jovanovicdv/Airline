package com.comtrade.view;


import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Aerodrom;
import com.comtrade.domen.Aviokompanija;
import com.comtrade.domen.Operacije;
import com.comtrade.kontroler.Kontroler;
import com.comtrade.transfer.TransferKlasa;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;


public class Master_admin_forma extends JFrame {

	private JPanel contentPane;
	private JTextField tfAerodrom;
	private JTextField tfAviokompanija;
	private JTextField tfUsername;
	private JTextField tfPassword;
	private JComboBox cbAerodrom;
	private JComboBox cbAviokompanija;
	private ButtonGroup bg=new ButtonGroup();
	private JRadioButton rdbtnAerodrom;
	private JRadioButton rdbtnAviokompanija;
	private List<Aviokompanija> listavio = new ArrayList<>();
	private List<Aerodrom> listaero = new ArrayList<>();
	private JComboBox cbAdmin;
	private List<Administrator> listadmin = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Master_admin_forma frame = new Master_admin_forma();
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
	public Master_admin_forma() {
		setTitle("Notice me Deki senpai!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cbAerodrom = new JComboBox();
		cbAerodrom.setBounds(23, 159, 168, 20);
		contentPane.add(cbAerodrom);
		osvezi_cbaerodrom();
		
		
		cbAviokompanija = new JComboBox();
		cbAviokompanija.setBounds(463, 159, 168, 20);
		contentPane.add(cbAviokompanija);
		osvezi_cbaviokompanija();
		
		JLabel lblAerodrom = new JLabel("Aerodrom");
		lblAerodrom.setBounds(23, 134, 89, 14);
		contentPane.add(lblAerodrom);
		
		JLabel lblAviokompanija = new JLabel("Aviokompanija");
		lblAviokompanija.setBounds(463, 134, 89, 14);
		contentPane.add(lblAviokompanija);
		
		JButton btnIzbrisiAerodrom = new JButton("Izbrisi aerodrom");
		btnIzbrisiAerodrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izbrisiAerodrom();
				osvezi_cbaerodrom();
			}

			private void izbrisiAerodrom() {
				Aerodrom a = listaero.get(cbAerodrom.getSelectedIndex());
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(a, Operacije.izbrisiAerodrom);
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
		btnIzbrisiAerodrom.setBounds(23, 340, 168, 23);
		contentPane.add(btnIzbrisiAerodrom);
		
		JButton btnIzbrisiAviokompaniju = new JButton("Izbrisi aviokompaniju");
		btnIzbrisiAviokompaniju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izbrisiAviokompaniju();
				osvezi_cbaviokompanija();
			}

			private void izbrisiAviokompaniju() {
				Aviokompanija a = listavio.get(cbAviokompanija.getSelectedIndex());
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(a, Operacije.izbrisiAviokompaniju);
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
		btnIzbrisiAviokompaniju.setBounds(463, 340, 168, 23);
		contentPane.add(btnIzbrisiAviokompaniju);
		
		tfAerodrom = new JTextField();
		tfAerodrom.setBounds(23, 50, 168, 20);
		contentPane.add(tfAerodrom);
		tfAerodrom.setColumns(10);
		
		tfAviokompanija = new JTextField();
		tfAviokompanija.setColumns(10);
		tfAviokompanija.setBounds(463, 50, 168, 20);
		contentPane.add(tfAviokompanija);
		
		JButton btnDodajAerodrom = new JButton("Dodaj aerodrom");
		btnDodajAerodrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajAerodrom();
				osvezi_cbaerodrom();
				tfAerodrom.setText("");
			}

			private void dodajAerodrom() {
				
				Aerodrom aero = new Aerodrom();
				aero.setAerodrom_naziv(tfAerodrom.getText());
					TransferKlasa tf = new TransferKlasa();
					try {
						tf = Kontroler.getInstanca().posaljiPodatke(aero, Operacije.UnosAerodroma);
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
		btnDodajAerodrom.setBounds(23, 100, 168, 23);
		contentPane.add(btnDodajAerodrom);
		
		JButton btnDodajAviokompaniju = new JButton("Dodaj aviokompaniju");
		btnDodajAviokompaniju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajAviokompaniju();
				osvezi_cbaviokompanija();
				tfAviokompanija.setText("");
			}

			private void dodajAviokompaniju() {
				Aviokompanija ak = new Aviokompanija();
				ak.setAviokompanija_naziv(tfAviokompanija.getText());
				
					TransferKlasa tf = new TransferKlasa();
					try {
						tf = Kontroler.getInstanca().posaljiPodatke(ak, Operacije.UnosAviokompanije);
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
		btnDodajAviokompaniju.setBounds(463, 100, 168, 23);
		contentPane.add(btnDodajAviokompaniju);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(201, 47, 254, 20);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(201, 19, 89, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(201, 78, 89, 14);
		contentPane.add(lblPassword);
		
		tfPassword = new JTextField();
		tfPassword.setBounds(201, 103, 254, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		JButton btnDodajAdmina = new JButton("Dodaj admina");
		btnDodajAdmina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajAdmina();
				tfUsername.setText("");
				tfPassword.setText("");
				osvezicbAdmin();
			}

			private void dodajAdmina() {
				Administrator admin = new Administrator();
				admin.setUsername(tfUsername.getText());
				admin.setPassword(tfPassword.getText());
				TransferKlasa tf = new TransferKlasa();
				if (rdbtnAerodrom.isSelected()) {
					admin.setAerodrom_id(aerodromID());
					admin.setStatus((short) 2);
				}else if (rdbtnAviokompanija.isSelected()) {
					admin.setAviokompanija_id(aviokompanijaID());
					admin.setStatus((short) 3);
				}
				try {
						tf = Kontroler.getInstanca().posaljiPodatke(admin, Operacije.UnosAdmina);
						JOptionPane.showMessageDialog(null, tf.getServerPoruka_odgovor());

					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				
			}

			private int aviokompanijaID() {
				Aviokompanija a = (Aviokompanija) listavio.get(cbAviokompanija.getSelectedIndex());
				return a.getAviokompanija_id();
			}

			private int aerodromID() {
				Aerodrom a = (Aerodrom) listaero.get(cbAerodrom.getSelectedIndex());
				return a.getAerodrom_id();
			}
		});
		btnDodajAdmina.setBounds(201, 226, 254, 23);
		contentPane.add(btnDodajAdmina);
		
		rdbtnAerodrom = new JRadioButton("Aerodrom");
		rdbtnAerodrom.setBounds(201, 130, 109, 23);
		contentPane.add(rdbtnAerodrom);
		bg.add(rdbtnAerodrom);
		
		rdbtnAviokompanija = new JRadioButton("Aviokompanija");
		rdbtnAviokompanija.setBounds(201, 180, 109, 23);
		contentPane.add(rdbtnAviokompanija);
		bg.add(rdbtnAviokompanija);
		
		cbAdmin = new JComboBox();
		cbAdmin.setBounds(201, 409, 254, 20);
		contentPane.add(cbAdmin);
		osvezicbAdmin();
		
		JButton btnIzbrisiAdmina = new JButton("Izbrisi admina");
		btnIzbrisiAdmina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				izbrisiAdmina();
				osvezicbAdmin();
			}

			private void izbrisiAdmina() {
				Administrator a = listadmin.get(cbAdmin.getSelectedIndex()+1);
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(a, Operacije.izbrisiAdministratora);
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
		btnIzbrisiAdmina.setBounds(201, 461, 254, 23);
		contentPane.add(btnIzbrisiAdmina);
	}

	private void osvezicbAdmin() {
		Administrator a = new Administrator();
		TransferKlasa tf = new TransferKlasa();
		cbAdmin.removeAllItems();
		try {
			tf = Kontroler.getInstanca().posaljiPodatke(a, Operacije.VratiAdministratore);
			listadmin  = (List<Administrator>) tf.getServerObjekat_odgovor();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Administrator ad:listadmin) {
			if (!ad.getUsername().equals("dejan")) {
				cbAdmin.addItem(ad.getUsername());
			}
		}
		
	}

	private void osvezi_cbaviokompanija() {
		Aviokompanija av = new Aviokompanija();
		TransferKlasa tf = new TransferKlasa();
		cbAviokompanija.removeAllItems();
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
		for(Aviokompanija a:listavio)
		cbAviokompanija.addItem(a.getAviokompanija_naziv());
		
	}

	private void osvezi_cbaerodrom() {
		Aerodrom ae = new Aerodrom();
		TransferKlasa tf = new TransferKlasa();
		cbAerodrom.removeAllItems();
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
		for(Aerodrom a:listaero)
		cbAerodrom.addItem(a.getAerodrom_naziv());
		
	}
}
