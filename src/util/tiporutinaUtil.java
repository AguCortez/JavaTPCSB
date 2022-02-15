package util;

import java.util.LinkedList;

import data.dataTiporutina;

public class tiporutinaUtil {
	
	
	public void altaTiporutina(int id_tipo, String descripcion) {
		Tiporutina nTiporutina=new Tiporutina(id_tipo, descripcion);
		dataTiporutina ds=new dataTiporutina();
		ds.add(nTiporutina);

	}
	public void bajaTiporutinao(int id_tipo) {
		dataTiporutina ds= new dataTiporutina();
		ds.delete(id_tipo);
	}

	public void modTiporutina(Tiporutina t, int id_tipoviejo) {
		dataTiporutina ds= new dataTiporutina();
		ds.update(t, id_tipoviejo);
	}

	public LinkedList<Tiporutinao> getAll(){
		dataTiporutina ds=new dataTiporutina();
		return ds.getAll();
	}

	public Tiporutina getBydni(int id_tipo) {
		dataTiporutina ds=new dataTiporutina();
		return ds.getOne(id_tipo);
	}