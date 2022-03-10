package util;

import java.util.LinkedList;

import data.dataTiporutina;
import entites.TipoRutina;

public class tiporutinaUtil {
	
	
	public void altaTiporutina(int id_tipo, String descripcion) {
		TipoRutina nTiporutina=new TipoRutina();
		dataTiporutina ds=new dataTiporutina();
		ds.add(nTiporutina);

	}
	public void bajaTiporutinao(int id_tipo) {
		dataTiporutina ds= new dataTiporutina();
		ds.delete(id_tipo);
	}

	public void modTiporutina(TipoRutina t, int id_tipoviejo) {
		dataTiporutina ds= new dataTiporutina();
		ds.update(t, id_tipoviejo);
	}

	public LinkedList<TipoRutina> getAll(){
		dataTiporutina ds=new dataTiporutina();
		return ds.getAll();
	}

	public TipoRutina getByID(int id_tipo) {
		dataTiporutina ds=new dataTiporutina();
		return ds.getOne(id_tipo);
	}
}