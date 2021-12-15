package util;
import entites.Socio;

import java.util.LinkedList;

import data.dataSocio;

public class sociosUtil {
	
	
	public void altaSocio(int dni, String tipo, String contra, String nombre, String apellido,String celular) {
		Socio nSocio=new Socio(dni, tipo, contra, nombre, apellido, celular);
		dataSocio ds=new dataSocio();
		ds.add(nSocio);

	}
	public void bajaSocio(int dni) {
		dataSocio ds= new dataSocio();
		ds.delete(dni);
	}

	public void modSocio(int dni, Socio s) {
		dataSocio ds= new dataSocio();
		s=ds.getOne(dni);
		ds.update(s);
	}

	public LinkedList<Socio> getAll(){
		dataSocio ds=new dataSocio();
		return ds.getAll();
	}

	public Socio getBydni(int dni) {
		dataSocio ds=new dataSocio();
		return ds.getOne(dni);
	}
	public Socio getByUsuyContra(int dni, String contra) {
		dataSocio ds=new dataSocio();
				return ds.getUsuarioxContra(dni, contra);
			}

	public LinkedList<Socio> buscabyNombre(String nombre){
			dataSocio ds=new dataSocio();
		return ds.buscabyNombre(nombre);
	}
}	
