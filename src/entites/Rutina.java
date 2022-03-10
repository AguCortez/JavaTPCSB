package entites;


public class Rutina {
	private int idtiporutina;
	public int getIdtiporutina() {
		return idtiporutina;
	}

	public void setIdtiporutina(int idtiporutina) {
		this.idtiporutina = idtiporutina;
	}

	private int dni;
	public Rutina(int idtiporutina, String dia2, int idrutina2, int dni2, int dniP, int id_ejer) {
		this.setDia(dia2);
		this.setIdRutina(idrutina2);
		this.setDni(dni2);
		this.setLegajo(dniP);
		this.setId_ejer(id_ejer);
        this.setIdtiporutina(idtiporutina);
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getLegajo() {
		return dniP;
	}

	public void setLegajo(int legajo) {
		this.dniP = legajo;
	}

	private int dniP;
	private int idRutina;
	private String dia;
	private int id_ejer;

	public int getIdRutina() {
		return idRutina;
	}

	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}
	public Rutina() {
	}

	public int getId_ejer() {
		return id_ejer;
	}

	public void setId_ejer(int id_ejer) {
		this.id_ejer = id_ejer;
	}

}
