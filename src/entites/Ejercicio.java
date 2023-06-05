package entites;


public class Ejercicio {

		private int idtipo;
		private String descripcion;
		
		public Ejercicio(int idtipo, String descripcion) {

		this.setDescripcion(descripcion);
		this.setIdtipo(idtipo);
	
		}
		
		
		
		public void setIdtipo(int idtipo) {
			this.idtipo = idtipo;
		}



		public Ejercicio() {
			// TODO Auto-generated constructor stub
		}
		public int getIdtipo() {
			return idtipo;
		}
		
	
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		
	
	
	
	

}
