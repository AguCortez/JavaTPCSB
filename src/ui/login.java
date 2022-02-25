package ui;

import java.util.LinkedList;
import java.util.UUID;

import data.DataUsuario;
import data.dataSocio;
<<<<<<< HEAD
import entites.Clase;
import entites.Profesional;
import entites.Socio;
import entites.Usuario;
import util.UsuarioUtil;
import util.claseUtil;
import util.profesionalUtil;
=======
import data.dataProfesional;
import entites.Profesional;
import entites.Socio;
import entites.Ejercicio;
import data.dataEjercicio;
>>>>>>> c2157ec842dcc21143eb0622342f678c987937d5


public class login {

	public static void main(String[] args) {
		dataSocio s=new dataSocio();
		DataUsuario du= new DataUsuario();
		profesionalUtil pu=new profesionalUtil();
		LinkedList<Usuario> sa=du.getAll();
		String nombre="";
		int lvl=0;
		for(Usuario xcv: sa) {
			
			System.out.println(xcv.getNivel()+" "+xcv.getDni()+ " "+ xcv.getContrasenia());
		}
<<<<<<< HEAD
		Usuario su= new Usuario();
=======
		dataProfesional dp= new dataProfesional();	
		LinkedList<Profesional> profes= dp.getAll();
		for(Profesional xcv:profes){
			System.out.println(xcv.toString());}
		
		dataEjercicio de=new dataEjercicio();
		LinkedList <Ejercicio> ejers = de.getAll();
		for (Ejercicio xcv : ejers) {
			System.out.println(xcv.toString());
		}
>>>>>>> c2157ec842dcc21143eb0622342f678c987937d5
		
		
		su=du.getUsuarioxContra(111,"java");
		
		UsuarioUtil uu=new UsuarioUtil();
		// lvl=uu.nivellogin(12, "123");
		System.out.println(lvl+" "+su.getNivel());
		}
	}


