package entites;
import java.sql.*;

public class Cuota {

	private int idCuota;
	private int anio;
	
	
	public Cuota() {
		// TODO Auto-generated constructor stub
	}
	public Cuota(int idCuota2, int anio2, int mes2, int precio2, Date fecha2) {
		// TODO Auto-generated constructor stub
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getIdCuota() {
		return idCuota;
	}
	public void setIdCuota(int idCuota) {
		this.idCuota = idCuota;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Date getFecha_pago() {
		
		return fecha;
	}
	public void setFecha_pago(String fecha_pago) {
		Date fecha = Date.valueOf(fecha_pago);

		this.fecha = fecha;
	}
	private int mes;
	private int precio;
	private Date fecha;
}
