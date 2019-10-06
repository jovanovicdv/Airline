package com.comtrade.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.comtrade.domen.Administrator;
import com.comtrade.domen.Operacije;
import com.comtrade.kontroler.Kontroler;
import com.comtrade.transfer.TransferKlasa;

import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;

import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Administrator_login_forma {

	private JFrame frmLogin;
	private JTextField tfUsername;
	private JPasswordField pfPassword;
	private static Administrator_login_forma window;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Administrator_login_forma();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Administrator_login_forma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setResizable(false);
		frmLogin.setBounds(100, 100, 450, 550);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(164, 118, 232, 20);
		frmLogin.getContentPane().add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(50, 121, 81, 14);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(50, 193, 81, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = tfUsername.getText();
				char[] pass = pfPassword.getPassword();
				String password = String.valueOf(pass);
				Administrator admin = new Administrator(0, user, password, (short) 0, 0, 0);
				TransferKlasa tf = new TransferKlasa();
				try {
					tf = Kontroler.getInstanca().posaljiPodatke(admin, Operacije.VratiZaAdminLogin);
					admin=  (Administrator) tf.getServerObjekat_odgovor();
					IProxy ip = new ProxyLogin();
					ip.login(admin);
					
				 
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (admin.getStatus()>0) {
					window.frmLogin.setVisible(false);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(175, 275, 100, 23);
		frmLogin.getContentPane().add(btnNewButton);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(164, 192, 232, 20);
		frmLogin.getContentPane().add(pfPassword);
	}
}
