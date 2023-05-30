package logica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import logica.Pedido;
import logica.Producto;
import logica.precioMaximoException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

class PedidoTest {
    private Pedido pedido;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;

    @BeforeEach
    void setUp() {
        producto1 = new ProductoImpl("Producto 1", 50);
        producto2 = new ProductoImpl("Producto 2", 70);
        producto3 = new ProductoImpl("Producto 3", 40);

        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(producto1);
        listaProductos.add(producto2);

        pedido = new Pedido("Cliente", "Dirección", listaProductos);
    }

    @Test
    void testAgregarProducto() throws precioMaximoException {
        Producto nuevoProducto = new ProductoImpl("Nuevo producto", 30);
        pedido.agregarProducto(nuevoProducto);
        Assertions.assertTrue(pedido.getListaProductos().contains(nuevoProducto));
    }

    @Test
    void testAgregarProductoExcedePrecioMaximo() {
        // Configuración de la prueba
        Pedido pedido = new Pedido("Cliente", "Dirección", new ArrayList<>());
        
        Producto producto1 = new ProductoImpl("Producto 1", 100000);
        Producto producto2 = new ProductoImpl("Producto 2", 60000);
        
        Assertions.assertThrows(precioMaximoException.class, () -> {
            pedido.agregarProducto(producto1);
            pedido.agregarProducto(producto2);
        });
    }




    @Test
    void testGetPrecioNetoPedido() {
        Assertions.assertEquals(120, pedido.getPrecioNetoPedido());
    }

    @Test
    void testGetPrecioIvaPedido() {
        Assertions.assertEquals(22.8, pedido.getPrecioIvaPedido(), 0.01);
    }

    @Test
    void testGetPrecioTotalPedido() {
        Assertions.assertEquals(142.8, pedido.getPrecioTotalPedido(), 0.01);
    }

    @Test
    void testGenerarTextoFactura() {
        ArrayList<String> textoFactura = pedido.generarTextoFactura();
        Assertions.assertEquals(2, textoFactura.size());
        Assertions.assertTrue(textoFactura.contains("Producto: Producto 1 - Precio: 50"));
        Assertions.assertTrue(textoFactura.contains("Producto: Producto 2 - Precio: 70"));
    }

    @Test
    void testGuardarFactura() {
        Assertions.assertDoesNotThrow(() -> pedido.guardarFactura());
        File file = new File("./data/" + pedido.getIdPedido());
        Assertions.assertTrue(file.exists());
        file.delete();
    }

    private static class ProductoImpl implements Producto {
        private String nombre;
        private int precio;

        ProductoImpl(String nombre, int precio) {
            this.nombre = nombre;
            this.precio = precio;
        }

        @Override
        public int getPrecio() {
            return precio;
        }

        @Override
        public String getNombre() {
            return nombre;
        }

        @Override
        public String generarTextoFactura() {
            return "Producto: " + nombre + " - Precio: " + precio;
        }
    }
}


