package entites;


public class Rutina {
	public Rutina(int idtipoej2, String dia2, int idrutina2, int dni2, int dniP2, int dniP3, int series2,
			int repeticiones2) {
		setIdtipoej(idtipoej2);
		setDia(dia2);
		setIdRutina(idrutina2);
		setDni(dni2);
		setDniP(dniP2);
		setDniP(dniP3);
		setSeries(series2);
		
		// TODO Auto-generated constructor stub
	}
	public Rutina() {
		// TODO Auto-generated constructor stub
	}
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
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getDniP() {
		return dniP;
	}
	public void setDniP(int dniP) {
		this.dniP = dniP;
	}
	public int getIdtipoej() {
		return idtipoej;
	}
	public void setIdtipoej(int idtipoej) {
		this.idtipoej = idtipoej;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getRepeticiones() {
		return repeticiones;
	}
	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}
	private int idRutina;
	private String dia;
	private int dni;
	private int dniP;
	private int idtipoej;
	private int series;
	private int repeticiones; 
	
}
