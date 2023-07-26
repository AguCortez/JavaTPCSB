package entites;
import java.sql.*;


public class Clase {
	private int codigo;
	private String dia;
	private String hora;
	private int legajo_prof;
	private int  idtipo_clase;
	private int total_cupo;
	
	

public Clase(int codigo, int total_cupo, String dia, String hora, int legajo_prof , int idtipo_clase) {
	this.setCodigo(codigo);
	this.setTotal_cupo(total_cupo);
	this.setDia(dia);
	this.setHora(hora);
	this.setLegajo_prof(legajo_prof);
	this.setIdtipo_clase(idtipo_clase);
	
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



public String getHora() {
	return hora;
}



public void setHora(String hora) {
	this.hora = hora;
}



public int getLegajo_prof() {
	return legajo_prof;
}



public void setLegajo_prof(int legajo_prof) {
	this.legajo_prof = legajo_prof;
}



public int getIdtipo_clase() {
	return idtipo_clase;
}



public void setIdtipo_clase(int idtipo_clase) {
	this.idtipo_clase = idtipo_clase;
}



public int getTotal_cupo() {
	return total_cupo;
}



public void setTotal_cupo(int total_cupo) {
	this.total_cupo = total_cupo;
}

public Clase() {
}
}
