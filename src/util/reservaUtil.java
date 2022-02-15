package util;
import entites.Reserva; 

import java.util.LinkedList;

import data.dataReserva;

public class reservasUtil {
	
	
	public void altaReserva(int id_reserva, date fecha, int dni, String codigo) {
		Reserva nReserva=new Reserva(id_reserva, fecha, dni, codigo );
		dataReserva ds=new dataReserva();
		ds.add(nReserva);

	}
	public void bajaReserva(int id_reserva) {
		dataReserva ds= new dataReserva();
		ds.delete(id_reserva);
	}

	public void modReserva(Reserva r, int id_reservaviejo) {
		dataReserva ds= new dataReserva();
		ds.update(r, id_reservaviejo);
	}

	public LinkedList<Reserva> getAll(){
		dataReserva ds=new dataReserva();
		return ds.getAll();
	}

	public Reserva getByIdreserva(int id_reserva) {
		dataReserva ds=new dataReserva();
		return ds.getOne(id_reserva);
	}