package ui;

import java.util.LinkedList;
import java.util.UUID;

import data.DataUsuario;
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
		dataRutina dp= new dataRutina();
		LinkedList<Rutina> pr= new LinkedList<>();
		pr=dp.getAll();
		for (Rutina p: pr) {
			System.out.println(p.getIdRutina());
		}
	}
	}


