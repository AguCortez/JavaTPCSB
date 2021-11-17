package data;

import java.util.ArrayList;

import entites.Socio;

public class dataSocio {


	
	public ArrayList<Socio> getAll()
	{
		return null;
		
	}
	public Socio getOne(int id)
	{
		Socio c=new Socio();
		String getone="select * from clases where id=id";
		return c;
	}
	
	void add(Socio c) {}
	
	public void borrar(int id) {}
	
	public void modificar(int id) {}

		
}
