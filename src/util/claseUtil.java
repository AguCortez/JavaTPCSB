package util;
import entites.Clase;

import java.sql.*;

import java.util.LinkedList;



import data.dataClase;

public class claseUtil {
	
	
	public void altaClase(int total_cupo, int id, String nombre, int actual_cupos, String dia, String hora, String descripcion, int legajo_prof) {
		
		Time hs=Time.valueOf(hora);		
		Clase nClase=new Clase(total_cupo, id, nombre, actual_cupos, dia, hs, descripcion, legajo_prof);
		dataClase ds=new dataClase();
		ds.add(nClase);

	}
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
}