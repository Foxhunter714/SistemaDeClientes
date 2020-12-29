package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import model.Cliente;
import servicios.ArchivoServicios;
import servicios.ClienteServicio;
import utilidades.Utilidad;
/*
 [ ]Falta por implementar el método salir en el menú.
 [ ]Falta por implementar editar cliente de manera correcta, ya que cuando uno coloca: 
 	1.- Editar cliente (3) -> Ingrese una opción(2) -> Ingresa el RUN del Cliente a buscar(Muestra los datos si coincide) -> Seleccione la opción a editar(cualquiera) -> Aparece un texto y vuelve al menú inicial  
 [ ]Faltan implementar los TEST
 [ ]Agregar los ENUM para categoría cliente o para estado del cliente (activo o inactivo)
 [ ]Ver si se puede incorporar int de años como cliente
 */ 
public class Menu extends ArchivoServicios {

	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicios archivoServicios = new ArchivoServicios();
	List<Cliente> listaClientes;
	String fileName = "clientes.csv";
	Scanner scanner = new Scanner(System.in);
	
	public void iniciarMenu() {
		List<String> opcionesMenu = new ArrayList<String>();
		opcionesMenu.add("Listar Cliente\n"); //1
		opcionesMenu.add("Agregar Cliente\n"); //2
		opcionesMenu.add("Editar Cliente\n"); //3
		opcionesMenu.add("Cargar Datos\n"); //4
		opcionesMenu.add("Exportar Datos\n"); //5
		opcionesMenu.add("Salir\n"); //6
		Menu menu = new Menu();
		menu.seleccionOpcion(opcionesMenu);
	}
	protected int construirMenu(List<String> pOpcionesMenu) {
			List<String> opcionesMenu = pOpcionesMenu;
			int largo = opcionesMenu.size();
			for(int i = 0; i<largo; i++) {
				System.out.print(i+1 + " " + opcionesMenu.get(i));
	}
			Scanner scanner = new Scanner(System.in);
			int opcion = 0;
			Utilidad.showMessage("Ingrese una opción: \n");
			try {
				opcion = scanner.nextInt();
			} catch (Exception error) {
				scanner.nextLine();
			} if (opcion <1 || opcion >= largo) {
				Utilidad.showMessage("Selección no permitida \n");
			} else {
				return opcion;
			}
			return 0;
	}	
		
		public void seleccionOpcion(List<String> pOpcionesMenu) {
			boolean continuar = false;
			int resultado;
			
			do {
				resultado = construirMenu(pOpcionesMenu);
				switch(resultado) {
				case 1:
					//Listar Cliente
					clienteServicio.listarClientes(listaClientes);
					break; 
				case 2: 
					//Agregar Cliente
					
					listaClientes.add(clienteServicio.agregarCliente());
					//System.out.print(listaClientes);
					Utilidad.stopAndContinue();
					break;
				case 3: 
					//Editar Cliente
					System.out.print("Seleccione que desea hacer: \n");
					Utilidad.showMessage("1.-Cambiar el estado del Cliente\n");
					Utilidad.showMessage("2.-Editar los datos del Cliente\n");
					int opcionEdicion = scanner.nextInt();
					if(opcionEdicion == 1) {
						//Cambiar estado
						Utilidad.stopAndContinue();
					}
					else {
						clienteServicio.editandoCliente(listaClientes);
						Utilidad.stopAndContinue();
					}
					break;
				case 4:
					//Cargar Datos
					listaClientes = archivoServicios.cargarDatos(fileName);
					if (!listaClientes.isEmpty()) {
					Utilidad.showMessage("Datos cargados correctamente\n");
					Utilidad.showMessage("----------------------------\n");
					Utilidad.stopAndContinue();
					}
					break;
				case 5: 
					//Exportar Datos
					Utilidad.showMessage("Seleccione el formato a exportar: \n");
					Utilidad.showMessage("1.-Formato '.txt' \n");
					Utilidad.showMessage("2.- Formato '.csv' \n");
					int opcion = scanner.nextInt();
					if(opcion == 1) {
					archivoServicios.exportarTxt("boleta.txt", listaClientes);
					Utilidad.stopAndContinue();;
					} else {
					archivoServicios.exportarCsv("boleta.csv", listaClientes);
					Utilidad.stopAndContinue();;	
					}
					break;
				case 6: 
					//Saliendo del sistema
					Utilidad.showMessage("Abandonando el sistema de inventario...\n");
					Utilidad.stopAndContinue();
					Utilidad.showMessage("Acaba de salir del sistema");
					continuar = true;
				}
			} while (!continuar);
		}
		
		public abstract class MenuTemplate {
			public abstract void iniciarMenu();
		}
		
	}

