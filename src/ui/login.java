package ui;

import java.util.LinkedList;
import java.util.UUID;

import data.DataUsuario;
import data.dataClase;
import data.dataSocio;

import entites.Clase;
import entites.Profesional;
import entites.Rutina;
import entites.Socio;
import entites.Usuario;
import util.UsuarioUtil;
import util.claseUtil;
import util.profesionalUtil;

import data.dataProfesional;
import data.dataRutina;
import entites.Profesional;
import entites.Socio;
import entites.Ejercicio;
import data.dataEjercicio;



public class login {

	public static void main(String[] args) {
		dataClase dc = new dataClase();
		LinkedList<Clase> cl=new LinkedList<Clase>();
		cl=dc.getAll();
		for(Clase c : cl) {
			System.out.println(c.getDescripcion());
		}
	}
	}


