package util;

import entites.Ejercicio;
import entites.Reserva;
import java.sql.Date;
import java.util.LinkedList;

import data.dataEjercicio;
import data.dataReserva;

public class reservaUtil {
	
	public LinkedList<Reserva> getxDNI(int dni)
	{
		LinkedList<Reserva> reservas=new LinkedList<Reserva>();
		LinkedList<Reserva> susreservas=new LinkedList<Reserva>();
		reservas=getAll();
		for(Reserva r : reservas) {
			if(r.getDni()==dni) {
				susreservas.add(r);
			}
		}
		return reservas;
	}
	public void altaReserva(String dia, int dni, String codigo) {
		
		Reserva nReserva= new Reserva( dia, dni, codigo);
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
	
	public LinkedList<Reserva> buscaDNI(int dni){
		dataReserva de=new dataReserva();
	return de.buscabyId(dni);
	}
}
