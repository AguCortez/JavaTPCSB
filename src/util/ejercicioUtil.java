package util;
import java.util.LinkedList;

import data.dataEjercicio;
import entites.Ejercicio;


public class ejercicioUtil {

	public void NuevoEjercicio(int repeticiones, int peso, int series, String descripcion, String nombre_maquina,int idejercicio, int idrutina) {
		Ejercicio nEjercicio=new Ejercicio(repeticiones,  peso, series, descripcion, nombre_maquina,  idejercicio, idrutina);
		dataEjercicio de=new dataEjercicio();
		de.add(nEjercicio);
		

	}
	
	public void bajaEjercicio(int idejercicio) {
		dataEjercicio de= new dataEjercicio();
		de.delete(idejercicio );
	}
	
	public void modEjercicio(Ejercicio e, int idejercicio) {
		dataEjercicio de= new dataEjercicio();
		de.update(e, idejercicio);
	}
	
	public LinkedList<Ejercicio> getAll(){
		dataEjercicio de=new dataEjercicio();
		return de.getAll();
	}
	public Ejercicio getByID(int idejercicio) {
		dataEjercicio de=new dataEjercicio();
		return de.getOne(idejercicio);
	}
	
	public LinkedList<Ejercicio> buscabyID(int id){
		dataEjercicio de=new dataEjercicio();
	return de.buscabyID(id);
}
}