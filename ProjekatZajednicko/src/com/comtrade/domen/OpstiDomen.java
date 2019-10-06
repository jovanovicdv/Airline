package com.comtrade.domen;

import java.sql.ResultSet;
import java.util.List;

public interface OpstiDomen {
	public String vratiVrednostiZaInsert();
	public String vratiNazivTabele();
	public List<OpstiDomen> vratiZaSelect(ResultSet rs);
	public String vratiTabeleZaUpdate(OpstiDomen od);
	public String vratiTabeleZaDelete(OpstiDomen od);
	public String vratiNazivKolona();

}
