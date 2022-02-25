package entites;



public class Profesional extends Usuario{
	
	private String nombre;	
	private String apellido;
	private  int dni;
	private String contrasenia;
	
	@Override
	public String toString() {
		return "\n Profesional [dni=" + dni + ", nombre= "+ nombre +", apellido= "+getApellido()+ "]";
		
	}
	
	public Profesional(String nombre2, String apellido2, int legajo2, String contrasenia2) {
		this.setNombre(nombre2);
		this.setApellido(apellido2);
		this.setDni(legajo2);
		this.setContrasenia(contrasenia2);
		setNivel(1);
	}
	public Profesional() {
		// TODO Auto-generated constructor stub
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
