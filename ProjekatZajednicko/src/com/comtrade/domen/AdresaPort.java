package com.comtrade.domen;

public enum AdresaPort {
	ADRESA("127.0.0.1"), PORT(9000);
	private int port;
	private String adresa;
	private AdresaPort( String adresa) {
		
		this.adresa = adresa;
	}
	private AdresaPort( int port) {
			
			this.port = port;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

}
