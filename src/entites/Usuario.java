package entites;

public class Usuario {
	private int dni;
	private String contrasenia;
	private int nivel;
	
	public Usuario(int dni, String pass) {
		this.setDni(dni);
		this.setContrasenia(pass);
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
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

	public void setContrasenia(String password) {
		this.contrasenia = password;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
