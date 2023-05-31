package util;
import entites.TipoClase;

import java.sql.*;

import java.util.LinkedList;



import data.dataTipoClase;

public class tipoclaseUtil {
	
	/*public void modcupo(int id){
		dataClase dc=new dataClase();
		Clase laclase=new Clase();
		laclase=dc.getOne(id);
		int cupo=0;
		cupo=laclase.getActual_cupos();
		cupo=cupo-1;
		laclase.setActual_cupos(cupo);
		dc.update(laclase, id);
	}

	public LinkedList<Clase> getAllconcupo(){
		dataClase dc=new dataClase();
		LinkedList<Clase> concupo=new LinkedList<Clase>();
		LinkedList<Clase> clases=dc.getAll();
		for(Clase c: clases ) {
			if(c.getActual_cupos()>0) {
				concupo.add(c);
			}
		}
		
		return concupo;
	}*/
	
	public void bajaTipoClase(int id) {
		dataTipoClase ds= new dataTipoClase();
		ds.delete(id);
	}

	public void modClase(Clase c, int idviejo) {
		dataClase ds= new dataClase();
		ds.update(c, idviejo);
	}

	public LinkedList<TipoClase> getAll(){
		dataTipoClase ds=new dataTipoClase();
		return ds.getAll();
	}
	
	public void altaTipoClase(int idtipo_clase, String nombre_clase, String descripcion) {
		
		TipoClase nClase=new TipoClase(idtipo_clase, nombre_clase, descripcion);
		dataTipoClase ds=new dataTipoClase();
		ds.add(nClase);

	}

	public Clase getByid(int id) {
		dataClase ds=new dataClase();
		return ds.getOne(id);
	}
}