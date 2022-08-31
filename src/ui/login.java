package ui;

import java.util.LinkedList;
import java.util.UUID;
import data.dataTiporutina;
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
import entites.TipoRutina;
import util.reservaUtil;
import entites.Reserva;
import data.dataReserva;

public class login {

	public static void main(String[] args) {
		reservaUtil ru=new reservaUtil(); 
		dataReserva dr=new dataReserva();
		Reserva r=new Reserva();
		r.setCodigo("4");
		r.setDni(3);
		r.setId_reserva(50);
		dr.add(r);
		}
	}
	


