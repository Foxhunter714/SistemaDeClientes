package servicios;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import model.Categoria;
import model.CategoriaEnum;
import model.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {
	// [X]TODO falta indentar el código
	// eliminar comentarios innecesarios
	public void listarClientes(List<Cliente> listaClientes) {

		if (listaClientes != null) {

			if (!listaClientes.isEmpty()) {
				for (Cliente cliente : listaClientes) {
					Utilidad.showMessage("Datos del Cliente \n"); // TODO esto podría ser un método aparte
					Utilidad.showMessage("RUN: " + cliente.getRunCliente() + "\n"); 
					Utilidad.showMessage("Nombre: " + cliente.getNombreCliente() + "\n");
					Utilidad.showMessage("Apellido: " + cliente.getApellidoCliente() + "\n");
					Utilidad.showMessage("Años como cliente: " + cliente.getAniosCliente() + "\n");
					Utilidad.showMessage("Categoría del cliente: " + cliente.getCategoriaCliente() + "\n");
					Utilidad.showMessagePredefined();
				}
					Utilidad.showMessagePredefined();
			} else {
				Utilidad.showMessage("No se ha podido listar a los clientes, aún no carga datos\n");
			}
			Utilidad.stopAndContinue();
		} else {
			Utilidad.showMessagePredefined();
			System.out.print("No hay ningún cliente agregado \n");
		}
	}

	public void agregarCliente(List<Cliente> listaClientes) {
		// TODO hay varias instancias de scanner pero ninguna se cierra
		Scanner scanner = new Scanner(System.in);
		Utilidad.showMessage("Crear Cliente\n"); 
		Cliente cliente = new Cliente();
		Utilidad.showMessage("Ingresa RUT del Cliente: \n");
		cliente.setRunCliente(scanner.nextLine());
		Utilidad.showMessage("Ingresa Nombre del Cliente: \n");
		cliente.setNombreCliente(scanner.nextLine());
		Utilidad.showMessage("Ingresa Apellido del Cliente: \n");
		cliente.setApellidoCliente(scanner.nextLine());
		Utilidad.showMessage("Ingresa años como Cliente: \n");
		cliente.setAniosCliente(scanner.nextLine());
		Utilidad.showMessage("Ingresa la categoría del Cliente: \n");
		cliente.setCategoriaCliente(scanner.nextLine());
		Utilidad.showMessagePredefined();
		if (cliente != null) {
			listaClientes.add(cliente);
		}
	
		} 
	



	public void editandoCliente(List<Cliente> listaClientes) {
		Scanner scanner = new Scanner(System.in);
		Utilidad.showMessage("Ingresa el RUN del Cliente a buscar: \n");
		String run = scanner.nextLine(); 
		for (Cliente cliente : listaClientes) {
			if (cliente.getRunCliente().equals(run)) {
				Utilidad.showMessage("El RUN del Cliente es: " + cliente.getRunCliente() + "\n");
				Utilidad.showMessage(
						"Vuelva a escribir el RUN si desea mantener o ingrese el nuevo RUN si desea modificar: \n");
				String runCliente = scanner.nextLine();
				cliente.setRunCliente(runCliente);
				Utilidad.showMessage("El Nombre del Cliente: " + cliente.getNombreCliente() + "\n");
				Utilidad.showMessage(
						"Vuelva a escribir el nombre si desea mantener o ingrese el nuevo nombre si desea modificar: \n");
				String nombreCliente = scanner.nextLine();
				cliente.setNombreCliente(nombreCliente);
				Utilidad.showMessage("El Apellido del Cliente: " + cliente.getApellidoCliente() + "\n");
				Utilidad.showMessage(
						"Vuelva a escribir el apellido si desea mantener o ingrese el nuevo apellido si desea modificar: \n");
				String apellidoCliente = scanner.nextLine();
				cliente.setApellidoCliente(apellidoCliente);
				Utilidad.showMessage("Años como Cliente: " + cliente.getAniosCliente() + "\n");
				Utilidad.showMessage(
						"Vuelva a escribir los años como cliente si desea mantener o ingrese la nueva cantidad de años si desea modificar: \n");
				String aniosCliente = scanner.nextLine();
				cliente.setAniosCliente(aniosCliente);
				Utilidad.showMessage("La Categoría del cliente: " + cliente.getCategoriaCliente() + "\n");
				Utilidad.showMessage(
						"Vuelva a escribir la categoria si desea mantener o ingrese la nueva categoria si desea modificar: \n");
				String categoriaCliente = scanner.nextLine();
				cliente.setCategoriaCliente(categoriaCliente);
			}
		}
	}
}
