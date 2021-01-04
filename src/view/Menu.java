package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import model.Categoria;
import model.CategoriaEnum;
import model.Cliente;
import servicios.ArchivoServicios;
import servicios.ClienteServicio;
import servicios.ExportarCsv;
import servicios.ExportarTxt;
import utilidades.Utilidad;
/*
 [ ]Falta por implementar el método salir en el menú.
 [X]Falta por implementar editar cliente de manera correcta, ya que solamente se puede rellenar sin colocar opcion de cual quiero llenar  
 [ ]Faltan implementar los TEST
 [ ]Agregar los ENUM para categoría cliente o para estado del cliente (activo o inactivo)
 [ ]Ver si se puede incorporar int de años como cliente
 [X] Método agregar funciona pero no cuando la lista está nula o vacía
 */

//[X]TODO menú no debe extender de ArchivoServicios
//[X]TODO indentar el código
public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicios archivoServicios = new ArchivoServicios();
	ExportarCsv exportarcsv = new ExportarCsv();
	ExportarTxt exportartxt = new ExportarTxt();
	List<Cliente> listaClientes;
	Categoria categoria = new Categoria(null);

	String fileName = "clientes";
	String fileName1= "DBClientes";
	Scanner scanner = new Scanner(System.in);

	public void iniciarMenu() {
		List<String> opcionesMenu = new ArrayList<String>();
		opcionesMenu.add("Listar Cliente\n"); // 1
		opcionesMenu.add("Agregar Cliente\n"); // 2
		opcionesMenu.add("Editar Cliente\n"); // 3
		opcionesMenu.add("Cargar Datos\n"); // 4
		opcionesMenu.add("Exportar Datos\n"); // 5
		opcionesMenu.add("Salir\n"); // 6
		Menu menu = new Menu(); 
		menu.seleccionOpcion(opcionesMenu);
	}

	protected int construirMenu(List<String> pOpcionesMenu) {
		List<String> opcionesMenu = pOpcionesMenu;
		int largo = opcionesMenu.size();
		for (int i = 0; i < largo; i++) {
			System.out.print(i + 1 + " " + opcionesMenu.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		Utilidad.showMessage("Ingrese una opción: \n");
		try {
			opcion = scanner.nextInt();
		} catch (Exception error) {
			scanner.nextLine();
		}
		if (opcion < 1 || opcion >= largo+1) {
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
			switch (resultado) {
			case 1:
				// Listar Cliente
				clienteServicio.listarClientes(listaClientes);
				break;
			case 2:
				// Agregar Cliente 
				Utilidad.showMessage("Esto trae:" + listaClientes);
				clienteServicio.agregarCliente(listaClientes);
				//listaClientes.add(clienteServicio.agregarCliente());
				Utilidad.stopAndContinue();;				
				/*if(listaClientes.isEmpty()) {
				listaClientes.add(clienteServicio.agregarCliente());
				Utilidad.stopAndContinue();
				}
				else {
				listaClientes.add(clienteServicio.agregarCliente());
				Utilidad.stopAndContinue();					
				}*/
				break;
			case 3:
				// Editar Cliente
				System.out.print("Seleccione que desea hacer: \n");
				Utilidad.showMessage("1.-Cambiar el estado del Cliente\n");
				Utilidad.showMessage("2.-Editar los datos del Cliente\n");
				int opcionEdicion = scanner.nextInt();
				switch (opcionEdicion) {
				case 1: 
				// Cambiar estado
				int opcionCategoria = scanner.nextInt();
				if (opcionCategoria == 1) {
					Utilidad.showMessage("Activo: 1");
					Categoria categoria1 = new Categoria(CategoriaEnum.ACTIVO);
					Utilidad.stopAndContinue();
				} else if (opcionCategoria == 2){
					Utilidad.showMessage("Activo: 2");
					Categoria categoria2 = new Categoria(CategoriaEnum.INACTIVO);
					Utilidad.stopAndContinue();
				} else {
					Utilidad.showMessage("Categoria mal ingresada");
				}
				break;
				case 2:
				clienteServicio.editandoCliente(listaClientes);
				Utilidad.stopAndContinue();
				break;
				case 3:
				Utilidad.showMessage("Dato ingresado incorrectamente\n");
				}
				break;
			case 4:
				// Cargar Datos
				listaClientes = archivoServicios.cargarDatos(fileName1+".csv");
				if (!listaClientes.isEmpty()) {
					Utilidad.showMessage("Datos cargados correctamente\n");
					Utilidad.showMessagePredefined();
					Utilidad.stopAndContinue();
				}
				break;
			case 5:
				// Exportar Datos
				Utilidad.showMessage("Seleccione el formato a exportar: \n");
				Utilidad.showMessage("1.-Formato '.txt' \n");
				Utilidad.showMessage("2.- Formato '.csv' \n");
				int opcion = scanner.nextInt();
				switch (opcion) {
					case 1:
					exportarcsv.exportar(fileName+".csv\n", listaClientes);
					Utilidad.stopAndContinue();
					break;
					case 2: 
					exportartxt.exportar(fileName+".txt\n", listaClientes);
					Utilidad.stopAndContinue();
					break;
					case 3:
					Utilidad.showMessage("Número de opción ingresado incorrectamente\n");
					break;
				}
						
				break;
			case 6:
				// Saliendo del sistema
				Utilidad.showMessage("Abandonando el sistema de inventario...\n");
				Utilidad.timeToWait();
				Utilidad.showMessage("Acaba de salir del sistema");
				Utilidad.stopAndContinue();
				Utilidad.cleanScreen();
				continuar = false;
			}
		} while (!continuar);
	}
}

