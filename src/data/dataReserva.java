package data;

import java.util.ArrayList;

import entites.Reserva;

public class dataReserva {

	public ArrayList<Reserva> getAll()
	{
		return null;
		
	}
	public Reserva getOne(int id)
	{
		Reserva r=new Reserva();
		String getone="select * from clases where id=id";
		return r;
	}
	
	public void add(Reserva r) {}
	
	public void borrar(int id) {}
	
	public void modificar(int id) {}
	
	
	
	
}
