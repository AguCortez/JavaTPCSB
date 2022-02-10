package entites;


public class Ejercicio {

		private int idEjercicio;
		
		public Ejercicio(int repeticiones, int peso, int series, String descripcion, String nombre_maquina,
				int idejercicio) {
		this.setRepeticiones(repeticiones);
		this.setPeso(peso);
		this.setSeries(series);
		this.setDescripcion(descripcion);
		this.setNombre_maquina(nombre_maquina);
		this.setIdEjercicio(idejercicio);
		
		}
		public Ejercicio() {
			// TODO Auto-generated constructor stub
		}
		public int getIdEjercicio() {
			return idEjercicio;
		}
		public void setIdEjercicio(int idEjercicio) {
			this.idEjercicio = idEjercicio;
		}
		private int repeticiones;
		public int getRepeticiones() {
			return repeticiones;
		}
		public void setRepeticiones(int repeticiones) {
			this.repeticiones = repeticiones;
		}
		public int getPeso() {
			return peso;
		}
		public void setPeso(int peso) {
			this.peso = peso;
		}
		public int getSeries() {
			return series;
		}
		public void setSeries(int series) {
			this.series = series;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getNombre_maquina() {
			return nombre_maquina;
		}
		public void setNombre_maquina(String nombre_maquina) {
			this.nombre_maquina = nombre_maquina;
		}
		private int peso;
		private int series;
		private String descripcion;
		private String nombre_maquina;
	

}
