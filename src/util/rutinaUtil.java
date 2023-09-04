package util; 
import entites.Rutina;

import java.util.LinkedList;

import data.dataRutina;

public class rutinaUtil {
	
	
	public void altaRutina(int idtipoej, String dia, int idrutina, int dni, int dniP, int series, int repeticiones) {
		Rutina nRutina=new Rutina(idtipoej, dia, idrutina, dni, dniP, dniP, series, repeticiones);
		dataRutina ds=new dataRutina();
		ds.add(nRutina);

	}
	public void bajaRutina(int idrutina) {
		dataRutina ds= new dataRutina();
		ds.delete(idrutina);
	}

	public void modRutina(Rutina r, int idrutinaviejo) {
		dataRutina ds= new dataRutina();
		ds.update(r, idrutinaviejo);
	}

	public LinkedList<Rutina> getAll(){
		dataRutina ds=new dataRutina();
		return ds.getAll();
	}

	public Rutina getByidRutina(int idRutina) {
		dataRutina ds=new dataRutina();
		return ds.getOne(idRutina);
	}
}
