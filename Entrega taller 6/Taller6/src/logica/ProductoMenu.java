package logica;

public class ProductoMenu implements Producto {
	//ATRIBUTOS
		private String nombre;
		private int precioBase;
		
	//CONSTRUCTORES
	
	public ProductoMenu(String nombre, int precioBase) {
		super();
		this.nombre = nombre;
		this.precioBase = precioBase;
	}

	//getters (mismos metodos que la interfaz)
	@Override
	
	public int getPrecio() {
		// TODO Auto-generated method stub
		return precioBase;
	}
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		String textoFactura= this.nombre + " ; " + Integer.toString(precioBase);
		return textoFactura;
	}
}