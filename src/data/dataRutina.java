package data;

import java.util.ArrayList;

import entites.Rutina;


public class dataRutina {
	
	
	public ArrayList<Rutina> getAll()
	{
		return null;
		
	}
	public Rutina getOne(int id)
	{
		Rutina c=new Rutina();
		String getone="select * from Rutinas where id=id";
		return c;
	}
	
	public void add(Rutina r) {}
	
	public void borrar(int id) {}
	
	public void modificar(int id) {}


}
