package entites;
import java.sql.*;

public class Clase {

	private int total_cupo;
	private int cupos_actuales;
	private int codigo;
	private String dia;
	private String hora;
	private String Descripcion;
	private int legajo_prof;
	private int  idtipo_clase;
	
	public int getCupos_actuales() {
		return cupos_actuales;
	}
	public void setCupos_actuales(int cupos_actuales) {
		this.cupos_actuales = cupos_actuales;
	}
	public int getIdtipo_clase() {
		return idtipo_clase;
	}
	public void setIdtipo_clase(int idtipo_clase) {
		this.idtipo_clase = idtipo_clase;
	}

	public int getLegajo_prof() {
		return legajo_prof;
	}
	public void setLegajo_prof(int legajo_prof) {
		this.legajo_prof = legajo_prof;
	}

	public int getidtipo_clase() {
		return idtipo_clase;
	}
	public void setidtipo_clase(int idtipo_clase) {
		this.idtipo_clase = idtipo_clase;
	}
	public int getTotal_cupo() {
		return total_cupo;
	}
	public void setTotal_cupo(int total_cupo) {
		this.total_cupo = total_cupo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDia() {
		return dia;
	}
	public void setDia(String dia) {
		this.dia = dia;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String Descripcion) {
		this.Descripcion = Descripcion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public Clase(int total_cupo, int actual_cupos, 
			String dia,  String hora,String descripcion, 
			int legajo_prof,
			int idtipo_clase) {
		this.setTotal_cupo(total_cupo);
		this.setCupos_actuales(actual_cupos);
		this.setDia(dia);
		this.setHora(hora);
		this.setLegajo_prof(legajo_prof);
		this.setidtipo_clase(idtipo_clase);
		this.setDescripcion(descripcion);
	}
	
	public Clase() {
}
}
