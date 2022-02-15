package util;
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
