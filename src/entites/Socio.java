package entites;


public class Socio {

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre_soc() {
		return nombre_soc;
	}
	public void setNombre_soc(String nombre_soc) {
		this.nombre_soc = nombre_soc;
	}
	public String getApellido_soc() {
		return apellido_soc;
	}
	public void setApellido_soc(String apellido_soc) {
		this.apellido_soc = apellido_soc;
	}
	public String getCelu() {
		return celu;
	}
	public void setCelu(String celu) {
		this.celu = celu;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	private String nombre_soc;
	private String apellido_soc;
	private String celu;
	private int dni;
	private String tipo;
	private String contrasenia;
	@Override
	public String toString() {
		return "\n Persona [id=" + id_socio+ ", nombre= "+ nombre_soc+" ]";
	}

}
