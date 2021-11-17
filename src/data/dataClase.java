package data;

import java.util.ArrayList;

import entites.Clase;

public class dataClase {
	
	public ArrayList<Clase> getAll()
	{
		return null;
		
	}
	public Clase getOne(int id)
	{
		Clase c=new Clase();
		String getone="select * from clases where id=id";
		return c;
	}
	
	public void add(Clase c) {}
	
	public void borrar(int id) {}
	
	public void modificar(int id) {}

}
