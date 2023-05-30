package logica;
import java.util.List;

public class Combo implements Producto{

	//ATRIBUTOS
	
	private String nombreCombo;
	private Double descuento;
	private List<ProductoMenu> listaProductos;
	
	//CONSTRUCTORES
	public Combo(Double descuento, String nombreCombo, List<ProductoMenu> listaProductos) {
		super();
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.listaProductos= listaProductos;
	}
	
	//METODOS
	public void agregarItemsACombo(ProductoMenu itemCombo) {
		this.listaProductos.add(itemCombo);
		//Esta funcion no se usa ya que fue implementada dentro del restaurante
	}
	@Override
	public int getPrecio() {
		// TODO Auto-generated method stub
		int precio_parcial= 0;
		for (int j=0;j<this.listaProductos.size();j++) {
			precio_parcial= precio_parcial + (listaProductos.get(j)).getPrecio();
		}
		int precio_final = (int) (precio_parcial - (Double) (precio_parcial*this.descuento*0.01));
		return precio_final;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombreCombo;
	}
	public List<ProductoMenu> getlista() {
		return this.listaProductos;
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub

			String textoFactura= this.nombreCombo + " ; " + Integer.toString(getPrecio());
			return textoFactura;
		}
	}
	

	
	