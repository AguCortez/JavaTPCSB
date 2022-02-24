package util;

import entites.Reserva;
import java.sql.Date;
import java.util.LinkedList;


import data.dataReserva;

public class reservaUtil {
	
	
	public void altaReserva(int id_reserva, String fech, int dni, String codigo) {
		Date f = Date.valueOf(fech);
		Reserva nReserva= new Reserva(id_reserva, f, dni, codigo);
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
