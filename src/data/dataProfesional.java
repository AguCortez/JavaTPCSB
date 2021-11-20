package data;

import java.util.ArrayList;

import entites.Profesional;

public class dataProfesional {
	
	
	public ArrayList<Profesional> getAll()
	{
		return null;
		
	}
	public Profesional getOne(int id)
	{
		Profesional p=new Profesional();
		String getone="select * from clases where id=id";
		return p;
	}
	
	public void add(Profesional p) {}
	
	public void borrar(int id) {}
	
	public void modificar(int id) {}

}
