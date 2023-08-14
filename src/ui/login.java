package ui;

import java.util.LinkedList;
import java.util.UUID;

import data.DataUsuario;
import data.dataSocio;
import data.dataTipoClase;
import entites.Clase;
import entites.Profesional;
import entites.Rutina;
import entites.Socio;
import entites.TipoClase;
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

import util.reservaUtil;
import entites.Reserva;
import data.dataReserva;

public class login {

	public static void main(String[] args) {
		dataEjercicio d =new dataEjercicio();
		Ejercicio e= d.getOne(15);
		e.setDescripcion("Si edito");
		d.update(e, 15);
		System.out.println(e.getDescripcion()+ " "+ e.getIdtipo());
		
	}
}


