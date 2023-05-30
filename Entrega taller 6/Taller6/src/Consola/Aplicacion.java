package Consola;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import logica.Ingrediente;
import logica.IngredienteRepetidoException;
import logica.Pedido;
import logica.Producto;
import logica.ProductoAjustado;
import logica.ProductoMenu;
import logica.ProductoRepetidoException;
import logica.Restaurante;
import logica.precioMaximoException;

public class Aplicacion {	
	
	public static void imprimirProdcutosMenu() {
		
		System.out.println("  ");
		System.out.println("PRODUCTOS DEL MENÚ");
		for (int j=0;j<Restaurante.getMenuBase().size();j++) {
			System.out.println("  ");
			System.out.print(j + ". ");
			System.out.print(Restaurante.getMenuBase().get(j).getNombre());
			System.out.print(" -> ");
			System.out.print(Restaurante.getMenuBase().get(j).getPrecio());
		}	
		System.out.println("  ");
	}
	
	public static void imprimirCombos() {
		System.out.println("  ");
		System.out.println("COMBOS");
		for (int j=0;j<Restaurante.getCombos().size();j++) {
			System.out.println("  ");
			System.out.print(j+ ". " );
			System.out.print(Restaurante.getCombos().get(j).getNombre());
			System.out.print(" -> ");
			System.out.print(Restaurante.getCombos().get(j).getPrecio());
		}
		System.out.println("  ");
	}
	
	public static void imprimirIngredientes() {
		System.out.println("  ");
		System.out.println("INGREDIENTES ADICIONALES");
		for (int j=0;j<Restaurante.getIngredientes().size();j++) {
			System.out.println("  ");
			System.out.print(j + ". ");
			System.out.print(Restaurante.getIngredientes().get(j).getNombre());
			System.out.print(" -> ");
			System.out.print(Restaurante.getIngredientes().get(j).getCostoAdicional());
		}
		System.out.println("  ");
	}
	public static void imprimirMenuPrincipal () {
		System.out.println("Bienvenido a El Corral");
		System.out.println("Que desea hacer?");
		System.out.println("1.Ver el Menú");
		System.out.println("2. Hacer un nuevo Pedido");
		System.out.println("3. Consultar información de un pedido");
		System.out.println("4. Salir");
	}
	
	
	
	//METODO MAIN
	
	
	public static void main(String[] args) throws IOException, ProductoRepetidoException, IngredienteRepetidoException, precioMaximoException {
		//CARGA DE DATOS
		File archicombos= new File("./data/combos.txt");
		File archiingre= new File("./data/ingredientes.txt");
		File archimenu= new File("./data/menu.txt");
		Restaurante.cargarInformacionRestaurante(archiingre,archimenu,archicombos);
		//IMPRESION DEL MENU PRINCIPAL
		
		imprimirMenuPrincipal();
		Scanner scaner = new Scanner (System.in);
		//ELECCION DE OPCION PRINCIPAL
		int opcionPrincipal = scaner.nextInt();
			//IMPRESION DEL PEDIDO
			if (opcionPrincipal== 1) {
				imprimirProdcutosMenu();
				imprimirCombos();
				imprimirIngredientes();
				main(args);
				}
			//CREACION DE NUEVO PEDIDO
			else if (opcionPrincipal== 2) 
			{
				ArrayList<Producto> listaProductos= new ArrayList <Producto>(); 
				int precioMaximo = 0;
				Boolean continuarPedido= true;
				while (continuarPedido==true)
				{
					System.out.println("Que desea agregar al pedido? (digite un número de 1 a 3");
					System.out.println("1. Un Producto del menú");
					System.out.println("2. Un Combo");
					System.out.println("3. Un Producto del menú modificado");
					int opcionPedido= scaner.nextInt();
					
					if (opcionPedido == 1) {
					    imprimirProdcutosMenu();
					    System.out.println("Digite el número del producto que desea (ej: 0, 1, 2, etc.):");
					    int opcionProductoMenu = scaner.nextInt();
					    listaProductos.add(Restaurante.listMenu.get(opcionProductoMenu));
					    
					    precioMaximo += Restaurante.listMenu.get(opcionProductoMenu).getPrecio();
					    if (precioMaximo >= 150000) {
					        throw new precioMaximoException();
					    }
					    
					    System.out.print("¿Desea agregar algo más al pedido? (Digite true/false):");
					    continuarPedido = scaner.nextBoolean();
					} 
					else if (opcionPedido == 2) {
					    imprimirCombos();
					    System.out.println("Digite el número del combo que desea (ej: 0, 1, 2, etc.):");
					    int opcionCombo = scaner.nextInt();
					    listaProductos.add(Restaurante.listCombos.get(opcionCombo));
					    
					    precioMaximo += Restaurante.listCombos.get(opcionCombo).getPrecio();
					    if (precioMaximo >= 150000) {
					        throw new precioMaximoException();
					    }
					    
					    System.out.print("¿Desea agregar algo más al pedido? (Digite true/false):");
					    continuarPedido = scaner.nextBoolean();
					}
					else if (opcionPedido==3) {
						ArrayList<Ingrediente> listAgregados= new ArrayList<Ingrediente>();
						ArrayList<Ingrediente> listEliminados= new ArrayList<Ingrediente>();
						imprimirProdcutosMenu();
						System.out.println("digite el número del producto que desea modificar (ej: 0, 1, 2, etc.)");
						int opcionProductoMenu= scaner.nextInt();
						ProductoMenu base= Restaurante.getMenuBase().get(opcionProductoMenu);
						System.out.println("desea eliminar algún ingrediente?(digite true/false)");
						Boolean opcionEliminar= scaner.nextBoolean();
						if (opcionEliminar== true) 
							{
							//ELIMINAR
							Boolean seguirEliminando= true;
							
							while (seguirEliminando==true) 
								{
								imprimirIngredientes();
								System.out.print("Seleccione el número del ingrediente que desea eliminar");
								int numeroEliminado= scaner.nextInt();
								listEliminados.add(Restaurante.listIngredientes.get(numeroEliminado));
								System.out.println("desea eliminar algún otro ingrediente?(digite true/false)");
								seguirEliminando= scaner.nextBoolean();
								}
							}
						System.out.println("desea agregar algún ingrediente?(digite true/false)");
						Boolean opcionAgregar= scaner.nextBoolean();
						if (opcionAgregar== true) 
						{
						//AGREGAR
						Boolean seguirAgregando= true;
						
						while (seguirAgregando==true) 
							{
							imprimirIngredientes();
							System.out.println("Seleccione el número del ingrediente que desea agregar");
							int numeroAgregado= scaner.nextInt();
							listAgregados.add(Restaurante.listIngredientes.get(numeroAgregado));
							System.out.println("desea agregar algún otro ingrediente?(digite true/false)");
							seguirAgregando= scaner.nextBoolean();
							}
						}
						ProductoAjustado pAjustado= new ProductoAjustado (base,listAgregados , listEliminados);
						listaProductos.add(pAjustado);
						for (int i=0;i<listaProductos.size();i++)
						{
							precioMaximo+= listaProductos.get(i).getPrecio();
							if (precioMaximo>=150000)
							{
								throw new precioMaximoException();
							}
						}
						System.out.println("Desea agregar algo más al pedido?(digite true/false)");
						continuarPedido= scaner.nextBoolean();
						}
					}
				
				
				System.out.println("Digite su nombre");
				String nombreCliente= scaner.next();
				System.out.println("Digite su dirección");
				String direccionCliente= scaner.next();
				Pedido pedido = Restaurante.iniciarPedido(nombreCliente, direccionCliente,listaProductos );
				Restaurante.cerrarYGuardarPedido(pedido);
				System.out.println("\n" +"Recuerde el id de su pedido para consultarlo más tarde");
				System.out.println("\n" +"También puede consultar la informacion del archivo txt guardado en la carpeta data");
				System.out.println("El id de su pedido es: " + pedido.getIdPedido());
				main(args);
			} 
			else if (opcionPrincipal== 3) {
				Boolean encontrado= false;
				System.out.println("escriba el ID del pedido");
				int idpedido= scaner.nextInt();
				for (int i=0; i<Restaurante.listPedidos.size();i++) {
					Pedido pedidoActual=Restaurante.listPedidos.get(i);
					if (idpedido== pedidoActual.getIdPedido())
						{
						encontrado= true;
						System.out.println("Se ha encontrado el pedido que busca, su información se muestra a continuación");
						System.out.println("id -> " + pedidoActual.getIdPedido());
						System.out.println("Nombre -> " + pedidoActual.getNombreCliente());
						System.out.println("Dirección -> " + pedidoActual.getDireccionCliente());
						ArrayList<String> textoFactura = pedidoActual.generarTextoFactura();
						for (int j = 0; j<textoFactura.size(); j++) {
							System.out.println(textoFactura.get(j));
							}
						
						}
					
				}
				if (encontrado==false){
					System.out.println("no se encontró la información, es posible que haya cerrado"
							+ " el programa después de haber hecho su pedido, o que no se haya hecho el pedido");
				}
				main(args);
			}

	}
	
}
