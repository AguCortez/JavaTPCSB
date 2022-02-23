package util;
import data.*;
import entites.*;

public class UsuarioUtil {
	public int nivellogin (int dni, String pass) {
		DataUsuario du=new DataUsuario();
		Usuario elusu=null;
		int lvl=0;
		elusu=du.getUsuarioxContra(dni, pass);
		lvl=elusu.getNivel();
		return lvl;
	}

}
