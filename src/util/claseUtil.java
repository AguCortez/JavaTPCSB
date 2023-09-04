package util;
import entites.Clase;
import entites.TipoClase;

import java.sql.*;

import java.util.LinkedList;



import data.dataClase;
import data.dataTipoClase;

public class claseUtil {
	
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
	public void altaClase(int total_cupo, int id, String nombre, int actual_cupos, String dia, String hora, String descripcion, int legajo_prof) {
		
		Clase nClase=new Clase(total_cupo, id, nombre, actual_cupos, dia, hora, descripcion, legajo_prof);
		dataClase ds=new dataClase();
		ds.add(nClase);

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
	public void bajaClase(int id) {
		dataClase ds= new dataClase();
		ds.delete(id);
	}

	public void modClase(Clase c, int idviejo) {
		dataClase ds= new dataClase();
		ds.update(c, idviejo);
	}

	public LinkedList<Clase> getAll(){
		dataClase ds=new dataClase();
		return ds.getAll();
	}

	public Clase getByid(int id) {
		dataClase ds=new dataClase();
		return ds.getOne(id);
	}
	
	public LinkedList<Clase> buscaNom(String nombre) {
		dataClase ds=new dataClase();
		return ds.buscabyCodigo(nombre);
	}
	public void altaClase (Clase c)
	{
		dataClase dc= new dataClase();
		dc.add(c);
		
	}
}