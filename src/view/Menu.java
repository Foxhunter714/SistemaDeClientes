package view;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import model.CategoriaEnum;
import model.Cliente;
import servicios.ArchivoServicio;
import servicios.ClienteServicio;
import servicios.ExportarCsv;
import servicios.ExportarTxt;
import utilidades.Utilidad;
/*
 [X]Falta por implementar el método salir en el menú.
 [X]Falta por implementar editar cliente de manera correcta, ya que solamente se puede rellenar sin colocar opcion de cual quiero llenar  
 [ ]Faltan implementar los TEST
 [X]Agregar los ENUM para categoría cliente o para estado del cliente (activo o inactivo)
 [ ]Ver si se puede incorporar int de años como cliente
 [X] Método agregar funciona pero no cuando la lista está nula o vacía
 */

//[X]TODO menú no debe extender de ArchivoServicios
//[X]TODO indentar el código
public class Menu {

	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportarCsv exportarcsv = new ExportarCsv();
	ExportarTxt exportartxt = new ExportarTxt();
	String fileName = "clientes";
	String fileName1 = "DBClientes.csv";
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
		Utilidad.showMessage("Ingrese una opción:");
		try {
			opcion = scanner.nextInt();
		} catch (Exception error) {
			scanner.nextLine();
		}
		if (opcion < 1 || opcion >= largo + 1) {
			Utilidad.showMessage("Selección no permitida");
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
				listarCliente();
				break;
			case 2:
				agregarCliente();
				break;
			case 3:
				editarCliente(null);
				break;
			case 4:
				cargarDatos();
				break;
			case 5:
				exportarDatos();
				break;
			case 6:
				salirSistema();
			default:
				Utilidad.showMessage("Opción no válida");
			}
		} while (!continuar);
	}

	private void listarCliente() {
		clienteServicio.listarClientes();
		Utilidad.stopAndContinue();
	}

	private void agregarCliente() {

		Utilidad.showMessage("Crear Cliente");
		Utilidad.showMessage("Ingresa RUT del Cliente:");
		String runCliente = scanner.nextLine();
		Utilidad.showMessage("Ingresa Nombre del Cliente:");
		String nombreCliente = scanner.nextLine();
		Utilidad.showMessage("Ingresa Apellido del Cliente:");
		String apellidoCliente = scanner.nextLine();
		Utilidad.showMessage("Ingresa años como Cliente:");
		String aniosCliente = scanner.nextLine();
		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);
		Utilidad.stopAndContinue();
	}

	private void editarCliente(List<Cliente> listaClientes) {
		System.out.print("Seleccione que desea hacer: ");
		Utilidad.showMessage("1.-Cambiar el estado del Cliente");
		Utilidad.showMessage("2.-Editar los datos del Cliente");
		int opcionEdicion = scanner.nextInt();
		Utilidad.showMessage("Ingrese RUN del cliente:");
		String run1 = scanner.nextLine();
		for (Cliente cliente : listaClientes) {
			if (opcionEdicion == 1) {
				if (cliente.getRunCliente().equals(run1)) {
					Utilidad.showMessage("El estado actual es: " + cliente.getNombreCategoria());
					Utilidad.showMessagePredefined();
					Utilidad.showMessage("1.-Si desea cambiar el estado");
					Utilidad.showMessage("2.-Si desea mantener el estado");
					int opcionActividad = scanner.nextInt();
					if (opcionActividad == 1) {
						cliente.setNombreCategoria(CategoriaEnum.INACTIVO);
					} else if (opcionActividad == 2) {
						Utilidad.stopAndContinue();
					} else {
						Utilidad.showMessage("Te equivocaste de opción");
					}
				}
			} else if (opcionEdicion == 2) {
				Utilidad.showMessage("Ingresa el RUN del Cliente a buscar:");
				String run2 = scanner.nextLine();
				if (cliente.getRunCliente().equals(run2)) {
					Utilidad.showMessage("1.-El RUN del Cliente es: " + cliente.getRunCliente());
					Utilidad.showMessage("2.-El Nombre del Cliente: " + cliente.getNombreCliente());
					Utilidad.showMessage("3.-El Apellido del Cliente: " + cliente.getApellidoCliente());
					Utilidad.showMessage("4.-Años como Cliente: " + cliente.getAniosCliente());
					Utilidad.showMessagePredefined();
					Utilidad.showMessage("Ingrese la opción a editar");
					int opcionCliente = scanner.nextInt();
					switch (opcionCliente) {
					case 1:
						Utilidad.showMessage("Ingrese nuevo RUN:");
						String runCliente = scanner.nextLine();
						cliente.setRunCliente(runCliente);
						Utilidad.stopAndContinue();
						break;
					case 2:
						Utilidad.showMessage("Ingrese nuevo nombre:");
						String nombreCliente = scanner.nextLine();
						cliente.setNombreCliente(nombreCliente);
						Utilidad.stopAndContinue();
						break;
					case 3:
						Utilidad.showMessage("Ingrese nuevo apellido");
						String apellidoCliente = scanner.nextLine();
						cliente.setApellidoCliente(apellidoCliente);
						Utilidad.stopAndContinue();
						break;
					case 4:
						Utilidad.showMessage("Ingrese la cantidad nueva de años:");
						String aniosCliente = scanner.nextLine();
						cliente.setAniosCliente(aniosCliente);
						Utilidad.stopAndContinue();
						break;
					default:
						Utilidad.showMessage("Usted marco una opción incorrecta");
						Utilidad.stopAndContinue();
					}
				}
			} else {
				Utilidad.showMessage("");
			}
		}
	}

	private void cargarDatos() {
		Utilidad.showMessage("Cargar Datos");
		Utilidad.showMessage("Ingresa la ruta en donde se encuentra el archivo inventario.csv:");
		listaClientes = archivoServicio.cargarDatos(fileName1);
		if (!listaClientes.isEmpty()) {
			Utilidad.showMessage("Datos cargados correctamente");
			Utilidad.showMessagePredefined();
			Utilidad.stopAndContinue();
		}

	}

	private void salirSistema() {
		Utilidad.showMessage("Abandonando el sistema de inventario...");
		Utilidad.timeToWait();
		Utilidad.showMessage("Acaba de salir del sistema");
		Utilidad.stopAndContinue();
		System.exit(0);
	}

	private void exportarDatos() {
		Utilidad.showMessage("Seleccione el formato a exportar:");
		Utilidad.showMessage("1.-Formato '.csv'");
		Utilidad.showMessage("2.- Formato '.txt'");

		int opcion = scanner.nextInt();
		switch (opcion) {
		case 1:
			exportarcsv.exportar(fileName + ".csv", listaClientes);
			Utilidad.stopAndContinue();
			break;
		case 2:
			exportartxt.exportar(fileName + ".txt", listaClientes);
			Utilidad.stopAndContinue();
			break;
		case 3:
			Utilidad.showMessage("Número de opción ingresado incorrectamente");
		}
	}
}
