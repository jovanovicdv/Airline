package com.comtrade.transfer;

import java.io.Serializable;

public class TransferKlasa implements Serializable {
	private int operacija;
	private Object klijent_objekat;
	private Object serverObjekat_odgovor;
	private String serverPoruka_odgovor;
	public int getOperacija() {
		return operacija;
	}
	public void setOperacija(int operacija) {
		this.operacija = operacija;
	}
	public Object getKlijent_objekat() {
		return klijent_objekat;
	}
	public void setKlijent_objekat(Object klijent_objekat) {
		this.klijent_objekat = klijent_objekat;
	}
	public Object getServerObjekat_odgovor() {
		return serverObjekat_odgovor;
	}
	public void setServerObjekat_odgovor(Object serverObjekat_odgovor) {
		this.serverObjekat_odgovor = serverObjekat_odgovor;
	}
	public String getServerPoruka_odgovor() {
		return serverPoruka_odgovor;
	}
	public void setServerPoruka_odgovor(String serverPoruka_odgovor) {
		this.serverPoruka_odgovor = serverPoruka_odgovor;
	}
	

}

