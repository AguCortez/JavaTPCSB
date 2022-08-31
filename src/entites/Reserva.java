package entites;
import java.sql.*;
import java.sql.Date;

public class Reserva {

	private String codigo;
	private int dni;
	private int id_reserva;
	private Date fecha;
	public Reserva(int id_reserva2, int dni2, String codigo2) {
		// TODO Auto-generated constructor stub
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
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public Reserva() {
		
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	

}


