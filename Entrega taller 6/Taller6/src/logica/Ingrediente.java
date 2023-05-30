package logica;

public class Ingrediente {

	//ATRIBUTOS
		private String nombre;
		private int costoAdicional;
		
	//Constructores
		public Ingrediente(String nombre, int costoAdicional) {
			super();
			this.nombre = nombre;
			this.costoAdicional = costoAdicional;
		}		
	
	//Getters
		public String getNombre() {
			return nombre;
		}
		public int getCostoAdicional() {
			return costoAdicional;
		}
		
}
