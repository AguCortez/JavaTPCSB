package util;

import java.sql.Date;
import java.util.LinkedList;

import data.dataCuota;
import entites.Cuota;

public class cuotaUtil {

public void altaCuota(int idCuota,int anio,int mes,int precio,String fecha_pago) {
	Date fecha = Date.valueOf(fecha_pago);
	Cuota xCuota = new Cuota(idCuota,anio,mes,precio,fecha);
	dataCuota dc = new dataCuota();
	dc.add(xCuota);
	}

	public void bajaCuota (int idCuota) {
		dataCuota dc = new dataCuota ();
		dc.delete(idCuota);
		
	}
	public void modCuota(Cuota c, int idCuota) {
		dataCuota dc= new dataCuota();
		dc.update(c, idCuota);
		
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
