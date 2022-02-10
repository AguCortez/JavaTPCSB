package entites;
import java.sql.*;

public class Clase {

	private int total_cupo;
	
	public int getTotal_cupo() {
		return total_cupo;
	}
	public void setTotal_cupo(int total_cupo) {
		this.total_cupo = total_cupo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getActual_cupos() {
		return actual_cupos;
	}
	public void setActual_cupos(int actual_cupos) {
		this.actual_cupos = actual_cupos;
	}
	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	private int id;
	private String nombre;
	private int actual_cupos;
	private String dia;
	private Time hora;
	private String descripcion;
	private int legajo_prof;

	public int getLegajo_prof() {
		return legajo_prof;
	}
	public void setLegajo_prof(int legajo_prof) {
		this.legajo_prof = legajo_prof;
	}
	

}
