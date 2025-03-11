package util;


import java.util.LinkedList;

import data.dataCuota;
import entites.Cuota;

public class cuotaUtil {

public void altaCuota(int mes,int precio,int idcuota, int dni, int anio, String fecha_pago) {
	
	Cuota Cuota = new Cuota(mes,precio,idcuota,dni,anio,fecha_pago);
	dataCuota dc = new dataCuota();
	dc.add(Cuota);
	}

	public void bajaCuota (int idcuota) {
		dataCuota dc = new dataCuota ();
		dc.delete(idcuota);
		
	}
	public void modCuota(Cuota c, int idcuota) {
		dataCuota dc= new dataCuota();
		dc.update(c, idcuota);
		
	}
	public LinkedList<Cuota> getAll(){
		dataCuota dc=new dataCuota();
		return dc.getAll();
	}
	
	public Cuota getbyID(int idcuota) {
		dataCuota dc=new dataCuota();
		return dc.getOne(idcuota);
	}


}
