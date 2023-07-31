package util; 
import entites.Profesional;
import entites.TipoClase;

import java.util.LinkedList;

import data.dataProfesional;
import data.dataTipoClase;

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
	public boolean existeProf(int dni) {
		dataProfesional ds=new dataProfesional();
		boolean rta;
		if(ds.getOne(dni)==null) {
			rta=false;
		}else rta=true;
		return rta;
	}
	public LinkedList<Profesional> buscaNom(String nombre) {
		dataProfesional ds=new dataProfesional();
		return ds.buscabyNombre(nombre);
	}
}