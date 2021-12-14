package entites;

public class Usuario {
	private int dni;
	private String password;
	
	public Usuario(int dni, String pass) {
		this.setDni(dni);
		this.setPassword(pass);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
