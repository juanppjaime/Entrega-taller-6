package logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ComboTest {
    private Combo combo;
    private List<ProductoMenu> listaProductos;

    @BeforeEach
    void setUp() {
        listaProductos = new ArrayList<>();
        listaProductos.add(new ProductoMenu("Producto 1", 100));
        listaProductos.add(new ProductoMenu("Producto 2", 200));
        combo = new Combo(10.0, "Combo 1", listaProductos);
    }

    @Test
    void agregarItemsACombo() {
        ProductoMenu nuevoProducto = new ProductoMenu("Nuevo Producto", 300);
        combo.agregarItemsACombo(nuevoProducto);
        List<ProductoMenu> nuevaLista = combo.getlista();
        Assertions.assertEquals(3, nuevaLista.size());
        Assertions.assertTrue(nuevaLista.contains(nuevoProducto));
    }

    @Test
    void generarTextoFactura() {
        String textoFactura = combo.generarTextoFactura();
        Assertions.assertEquals("Combo 1 ; 270", textoFactura);
    }
}
