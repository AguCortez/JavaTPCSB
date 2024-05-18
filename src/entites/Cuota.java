package entites;
import java.sql.*;

public class Cuota {

	private int idCuota;
	private int anio;
	private int dni;
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Cuota() {
		// TODO Auto-generated constructor stub
	}
	public Cuota(int mes2, int precio2, int idcuota2, int dni2, int anio2, String fecha2) {
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
	public String getFecha_pago() {
		
		return fecha;
	}
	public void setFecha_pago(String fecha_pago) {
				this.fecha = fecha_pago;
	}
	private int mes;
	private int precio;
	private String fecha;
}
