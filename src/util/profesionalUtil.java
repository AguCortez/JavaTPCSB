package util; 
import entites.Profesional;

import java.util.LinkedList;

import data.dataProfesional;

public class profesionalUtil {
	
	
	public void altaProfesional(String nombre, String apellido, int legajo, String contrasenia) {
		Profesional nProfesional=new Profesional(nombre, apellido, legajo, contrasenia);
		dataProfesional ds=new dataProfesional();
		ds.add(nProfesional);

	}
	public void bajaProfesional(int legajo) {
		dataProfesional ds= new dataProfesional();
		ds.delete(legajo);
	}

	public void modProfesional(Profesional p, int  legajoviejo) {
		dataProfesional ds= new dataProfesional();
		ds.update(p, legajoviejo);
	}

	public LinkedList<Profesional> getAll(){
		dataProfesional ds=new dataProfesional();
		return ds.getAll();
	}

	public Profesional getBylegajo(int legajo) {
		dataProfesional ds=new dataProfesional();
		return ds.getOne(legajo);
	}
}