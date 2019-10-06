package com.comtrade.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;


import com.comtrade.server.Server;


import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class ServerForma {

	private JFrame frame;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForma window = new ServerForma();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServerForma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 444, 416);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnPokreniServer = new JButton("Pokreni server");
		btnPokreniServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pokreniServer();
				btnPokreniServer.setEnabled(false);
			}

			
		});
		btnPokreniServer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPokreniServer.setBounds(140, 11, 150, 25);
		frame.getContentPane().add(btnPokreniServer);
		
	}

	

	protected void pokreniServer() {
		Server s= new Server();
		s.start();
		
	}
}
