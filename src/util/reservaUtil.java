package util;
<<<<<<< HEAD
import java.sql.Date;
import java.util.LinkedList;
import data.dataReserva;
import entites.Reserva;

public class reservaUtil {
	

	public void altaReserva(int id_reserva, Date fecha, int dni, String codigo) {
		Reserva nReserva=new Reserva();
		dataReserva ds=new dataReserva();
		ds.add(nReserva);
				}
	public void bajaReserva(int id_reserva) {
		dataReserva ds= new dataReserva();
		ds.delete(id_reserva);	
	   }
		
		public LinkedList<Reserva> getAll(){
			dataReserva ds=new dataReserva();
			return ds.getAll();
		}
		public Reserva getByID(int id_reserva) {
			dataReserva ds=new dataReserva();
			return ds.getOne(id_reserva);
		}
		
}}
=======
import entites.Reserva;

import java.util.Date;
import java.util.LinkedList;

import data.dataReserva;

public class reservaUtil {
	
	
	public void altaReserva(int id_reserva, Date fecha, int dni, String codigo) {
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
}
>>>>>>> 214f6c3699446a914e6f8d1b6b7e8de48979ec0b
