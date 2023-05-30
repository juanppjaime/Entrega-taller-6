package logica;

public class ProductoRepetidoException extends HamburguesaException
{
	
	
	private String producto;

	public ProductoRepetidoException(String producto) {
		super("Producto repetido:" + producto);
		this.producto = producto;
		
	}

	public String getProducto()
	{
		return producto;
	}
}
