package logica;

import org.junit.Test;
import static org.junit.Assert.*;


public class ProductoMenuTest {

	//Decía que no se necesitaban el de getPrecio y geetNombre, pero los incluyo solo para probar el constructor
    @Test
    public void testConstructor() {
        String nombre = "Hamburguesa";
        int precioBase = 100;
        
        ProductoMenu producto = new ProductoMenu(nombre, precioBase);
        
        assertEquals(nombre, producto.getNombre());
        assertEquals(precioBase, producto.getPrecio());
    }
    
    @Test
    public void testGenerarTextoFactura() {
        String nombre = "Hamburguesa";
        int precioBase = 100;
        
        ProductoMenu producto = new ProductoMenu(nombre, precioBase);
        
        String textoFacturaEsperado = "Hamburguesa ; 100";
        String textoFacturaObtenido = producto.generarTextoFactura();
        
        assertEquals(textoFacturaEsperado, textoFacturaObtenido);
    }
}

