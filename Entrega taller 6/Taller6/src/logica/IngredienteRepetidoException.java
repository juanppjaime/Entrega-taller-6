package logica;

public class IngredienteRepetidoException extends HamburguesaException
{
    
	private String ingrediente;

    public IngredienteRepetidoException(String ingrediente) 
    {
        super("Ingrediente repetido: " + ingrediente);
        this.ingrediente = ingrediente;
    }

    public String getIngrediente() {
        return ingrediente;
    }
}