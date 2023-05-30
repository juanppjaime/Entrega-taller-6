package logica;

import java.util.ArrayList;

public class ProductoAjustado implements Producto{
		//ATRIBUTOS
	private String nombre;
	private int precio;
	private ArrayList<Ingrediente> listaAgregados;
	private ArrayList<Ingrediente> listaEliminados;
	
	//Funcion para calcular el precio 
	public int calcularPrecio(ArrayList<Ingrediente> agregados, int precio_base) {
		int precioFinal= precio_base;
		for (int i=0; i<agregados.size(); i++) {
			Ingrediente ingrediente_actual= agregados.get(i);
			int precioASumar= ingrediente_actual.getCostoAdicional();
			precioFinal= precioFinal + precioASumar;
		}
		return precioFinal;	
	}
		//CONSTRUCTORES
		
		public ProductoAjustado (ProductoMenu base, ArrayList<Ingrediente> agregados, ArrayList<Ingrediente> eliminados) {
			super();
			this.nombre = base.getNombre();
			this.precio= calcularPrecio(agregados, base.getPrecio());
			this.listaAgregados = agregados;
			this.listaEliminados= eliminados;
		}

		//getters (mismos metodos que la interfaz)
		public int getPrecio() {
			// TODO Auto-generated method stub
			return precio;
		}
		
		public String getNombre() {
			// TODO Auto-generated method stub
			return nombre;
		}
		public String generarTextoFactura() {

				String textoFactura= this.nombre + " (ProductoAjustado)"+ " ; " + Integer.toString(getPrecio());
				return textoFactura;
			}
		
}
