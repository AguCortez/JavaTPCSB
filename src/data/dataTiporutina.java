package data;

import java.util.ArrayList;

import entites.TipoRutina;

public class dataTiporutina {

	
	public ArrayList<TipoRutina> getAll()
	{
		return null;
		
	}
	public TipoRutina getOne(int id)
	{
		TipoRutina tp=new TipoRutina();
		String getone="select * from clases where id=id";
		return tp;
	}
	
	public void add(TipoRutina tp) {}
	
	public void borrar(int id) {}
	
	public void modificar(int id) {}
}
