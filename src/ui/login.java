package ui;

import java.util.LinkedList;
import java.util.UUID;

import data.DataUsuario;
import data.dataSocio;

import entites.Clase;
import entites.Profesional;
import entites.Socio;
import entites.Usuario;
import util.UsuarioUtil;
import util.claseUtil;
import util.profesionalUtil;

import data.dataProfesional;
import entites.Profesional;
import entites.Socio;
import entites.Ejercicio;
import data.dataEjercicio;



public class login {

	public static void main(String[] args) {
		dataProfesional dp= new dataProfesional();
		LinkedList<Profesional> pr= new LinkedList<>();
		pr=dp.getAll();
		for (Profesional p: pr) {
			System.out.println(p.getDni());
		}
	}
	}


