package util;
import java.util.LinkedList;

import data.dataEjercicio;
import entites.Ejercicio;


public class ejercicioUtil {

	public void NuevoEjercicio(Ejercicio nEjercicio) {
		
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
	
	public LinkedList<Ejercicio> buscaDesc(String id){
		dataEjercicio de=new dataEjercicio();
	return de.buscabyDesc(id);
}
}