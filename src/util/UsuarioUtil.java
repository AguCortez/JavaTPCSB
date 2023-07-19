package util;
import data.*;
import entites.*;

public class UsuarioUtil {
	public int nivellogin (int dni, String pass) {
		DataUsuario du=new DataUsuario();
		Usuario elusu=null;
		int lvl=0;
		elusu=du.getUsuarioxContra(dni, pass);
		if(elusu==null) {return 0;}
		lvl=elusu.getNivel();
		return lvl;
	}
	public void altaSocioU(int dni, String contra) {
		Usuario usu=new Usuario(dni, contra);
		DataUsuario du=new DataUsuario();
		du.addSocio(usu);
	}
	public void altaProfesional(String dni, String contra) {
		Usuario usu= new Usuario (Integer.parseInt(dni),contra);
		DataUsuario du = new DataUsuario();
		du.addProf(usu);
	}

}
