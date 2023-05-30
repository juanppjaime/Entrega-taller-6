package logica;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ProductoAjustadoTest {
    
    @Test
    public void testConstructor() {
        String nombreBase = "Hamburguesa";
        int precioBase = 100;
        ArrayList<Ingrediente> agregados = new ArrayList<>();
        ArrayList<Ingrediente> eliminados = new ArrayList<>();
        
        ProductoMenu base = new ProductoMenu(nombreBase, precioBase);
        ProductoAjustado producto = new ProductoAjustado(base, agregados, eliminados);
        
        assertEquals(nombreBase, producto.getNombre());
        assertEquals(precioBase, producto.getPrecio());
       
    }
    
    @Test
    public void testCalcularPrecioSinAgregados() {
        String nombreBase = "Hamburguesa";
        int precioBase = 100;
        ArrayList<Ingrediente> agregados = new ArrayList<>();
        ArrayList<Ingrediente> eliminados = new ArrayList<>();
        
        ProductoMenu base = new ProductoMenu(nombreBase, precioBase);
        ProductoAjustado producto = new ProductoAjustado(base, agregados, eliminados);
        
        int precioEsperado = precioBase;
        int precioObtenido = producto.getPrecio();
        
        assertEquals(precioEsperado, precioObtenido);
    }
    
    @Test
    public void testCalcularPrecioConAgregados() {
        String nombreBase = "Hamburguesa";
        int precioBase = 100;
        
        ArrayList<Ingrediente> agregados = new ArrayList<>();
        Ingrediente queso = new Ingrediente("Queso", 10);
        agregados.add(queso);
        
        ArrayList<Ingrediente> eliminados = new ArrayList<>();
        
        ProductoMenu base = new ProductoMenu(nombreBase, precioBase);
        ProductoAjustado producto = new ProductoAjustado(base, agregados, eliminados);
        
        int precioEsperado = precioBase + queso.getCostoAdicional();
        int precioObtenido = producto.getPrecio();
        
        assertEquals(precioEsperado, precioObtenido);
    }
    
    @Test
    public void testGenerarTextoFactura() {
        String nombreBase = "Hamburguesa";
        int precioBase = 100;
        ArrayList<Ingrediente> agregados = new ArrayList<>();
        ArrayList<Ingrediente> eliminados = new ArrayList<>();
        
        ProductoMenu base = new ProductoMenu(nombreBase, precioBase);
        ProductoAjustado producto = new ProductoAjustado(base, agregados, eliminados);
        
        String textoFacturaEsperado = "Hamburguesa (ProductoAjustado) ; 100";
        String textoFacturaObtenido = producto.generarTextoFactura();
        
        assertEquals(textoFacturaEsperado, textoFacturaObtenido);
    }
}
