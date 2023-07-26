package entites;
import java.sql.*;

public class TipoClase {

	private int idtipo_clase;
	private String descripcion;
	private String nombre_clase;

public TipoClase(String nombre_clase, String descripcion) {

	this.setNombre_clase(nombre_clase);
	this.setDescripcion(descripcion);	
}
	
	public TipoClase() {
}

	public int getIdtipo_clase() {
		return idtipo_clase;
	}

	public void setIdtipo_clase(int idtipo_clase) {
		this.idtipo_clase = idtipo_clase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre_clase() {
		return nombre_clase;
	}

	public void setNombre_clase(String nombre_clase) {
		this.nombre_clase = nombre_clase;
	}
}
