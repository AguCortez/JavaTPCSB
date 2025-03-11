package entites;
import java.sql.*;
import java.sql.Date;

public class Reserva {

	private int codigo;
	private int dni;
	private int id_reserva;
	private String fecha;
	public Reserva(int idReserva,String fecha, int dni, int codclase) {
		this.setCodigo(codclase);
		this.setDni(dni);
		this.setFecha(fecha);
		this.setId_reserva(idReserva);
	}
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	public Reserva() {
		
	}
	public String getDate() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	

}


