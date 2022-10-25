package entites;
import java.sql.*;
import java.sql.Date;

public class Reserva {

	private String codigo;
	private int dni;
	private int id_reserva;
	private String fecha;
	public Reserva(int dni, String codigo, String fecha) {
		// TODO Auto-generated constructor stub
		this.setCodigo(codigo);
		this.setDni(dni);
		this.setFecha(fecha);
	}

	public Reserva() {
		// TODO Auto-generated constructor stub
	}

	public int getId_reserva() {
		return id_reserva;
	}
	
	
	
	
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


}


