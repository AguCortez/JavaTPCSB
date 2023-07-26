package entites;
import java.sql.*;

public class TipoClase {
<<<<<<< Updated upstream

	private int idtipo_clase;
	private String descripcion;
	private String nombre_clase;

public TipoClase(int idtipo_clase,String nombre_clase, String descripcion) {
	this.setIdtipo_clase(idtipo_clase);
	this.setNombre_clase(nombre_clase);
	this.setDescripcion(descripcion);	
}
	
	public TipoClase() {
}
=======
	
	private int idtipo_clase ;
	private String nombre_clase ;
	private String descripcion;
		
	public TipoClase(int idtipo_clase,  String nombre_clase, String descripcion) {
		this.setIdtipo_clase(idtipo_clase);
		this.setNombre_clase(nombre_clase);
		this.setDescripcion(descripcion);
	}
>>>>>>> Stashed changes

	public int getIdtipo_clase() {
		return idtipo_clase;
	}

	public void setIdtipo_clase(int idtipo_clase) {
		this.idtipo_clase = idtipo_clase;
	}

<<<<<<< Updated upstream
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

=======
>>>>>>> Stashed changes
	public String getNombre_clase() {
		return nombre_clase;
	}

	public void setNombre_clase(String nombre_clase) {
		this.nombre_clase = nombre_clase;
	}
<<<<<<< Updated upstream
}
=======

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}

>>>>>>> Stashed changes
