package util;
import entites.*;

import java.util.LinkedList;

import data.DataUsuario;
import data.dataSocio;

public class sociosUtil {
	
	
	public void altaSocio(int dni, String tipo, String contra, String nombre, String apellido,String celular) {
		Socio nSocio=new Socio(dni, tipo, contra, nombre, apellido, celular);
		
		
		dataSocio ds=new dataSocio();
		ds.add(nSocio);
		

	}
	public void bajaSocio(int dni) {
		dataSocio ds= new dataSocio();
		DataUsuario du= new DataUsuario();
		du.delete(dni);
		ds.delete(dni);
	}

	public void modSocio(Socio s, int dniviejo) {
		dataSocio ds= new dataSocio();
		ds.update(s, dniviejo);
		DataUsuario du= new DataUsuario();
		du.update(s, dniviejo);
	}

	public LinkedList<Socio> getAll(){
		dataSocio ds=new dataSocio();
		return ds.getAll();
	}

	public Socio getBydni(int dni) {
		dataSocio ds=new dataSocio();
		return ds.getOne(dni);
	}
	/*Exclusiva de socio */
	
	public Socio getByUsuyContra(int dni, String contra) {
		dataSocio ds=new dataSocio();
				return ds.getUsuarioxContra(dni, contra);
			}

	public LinkedList<Socio> buscabyNombre(String nombre){
			dataSocio ds=new dataSocio();
		return ds.buscabyNombre(nombre);
	}
	/*Exclusiva de socio*/
	public boolean validaSocio(int dni, String pass) {
		Socio s=this.getBydni(dni);
		if(s!=null) {
			if(s.getContrasenia().equals(pass))
			{return true;}
			else return false;
		}else return false;
	}
	

	
}	

