package logica;

public class precioMaximoException extends Exception {

	private static final String mensaje = "Se ha superado el valor máximo de compra";
	
	public precioMaximoException()
	{
		super(mensaje);
	}
	
}