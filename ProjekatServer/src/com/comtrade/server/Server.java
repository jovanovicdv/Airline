package com.comtrade.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import com.comtrade.domen.AdresaPort;
import com.comtrade.niti.NitObrade;

public class Server extends Thread { 
	public void run() {
		pokreniServer();
	}

	private void pokreniServer() {
		try {
			ServerSocket ss= new ServerSocket(AdresaPort.PORT.getPort());
			while(true) {
				Socket soket =ss.accept();
				NitObrade no = new NitObrade();
				no.setSoket(soket);
				no.start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
