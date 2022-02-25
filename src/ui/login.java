package ui;

import java.util.LinkedList;

import data.dataSocio;
import data.dataProfesional;
import entites.Profesional;
import entites.Socio;
import entites.Ejercicio;
import data.dataEjercicio;


public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		LinkedList<Socio> sa=s.getAll();
	
		for(Socio xcv: sa) {
			
			System.out.println(xcv.toString());
		}
		dataProfesional dp= new dataProfesional();	
		LinkedList<Profesional> profes= dp.getAll();
		for(Profesional xcv:profes){
			System.out.println(xcv.toString());}
		
		dataEjercicio de=new dataEjercicio();
		LinkedList <Ejercicio> ejers = de.getAll();
		for (Ejercicio xcv : ejers) {
			System.out.println(xcv.toString());
		}
		
		
	}

}
