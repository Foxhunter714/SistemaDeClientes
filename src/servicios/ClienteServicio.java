package servicios;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import model.CategoriaEnum;
import model.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {
	public void listarClientes(List<Cliente> listaClientes) {
		  
		if(listaClientes != null) {
			
		if(!listaClientes.isEmpty()) {
			for (Cliente cliente : listaClientes) {
				Utilidad.showMessage("");
				Utilidad.showMessage("Datos del Cliente: \n" );
				Utilidad.showMessage("\n");
				Utilidad.showMessage("RUN: " + cliente.getRunCliente()+ "\n");
				//System.out.print();
				Utilidad.showMessage("\n");
				Utilidad.showMessage("Nombre: " + cliente.getNombreCliente()+ "\n"); 
				//System.out.print();
				Utilidad.showMessage("\n");
				Utilidad.showMessage("Apellido: " + cliente.getApellidoCliente()+ "\n");
				//System.out.print();
				Utilidad.showMessage("\n");
				Utilidad.showMessage("Años como cliente: " + cliente.getAniosCliente() + "\n");
				//System.out.print();
				Utilidad.showMessage("\n");
				Utilidad.showMessage("Categoría del cliente: " + cliente.getCategoriaCliente() + "\n");
				Utilidad.showMessage("\n");
				//System.out.print();
			}
			Utilidad.showMessage("---------------------------------\n");
		} else {
			Utilidad.showMessage("No se ha podido listar a los clientes, aún no carga datos\n");
		}
		Utilidad.stopAndContinue();
		} else {
			System.out.print("No hay ningún cliente agregado \n");
			Utilidad.showMessage("-------------------------------------\n");
		}
	}
	
	public Cliente agregarCliente() {
		Scanner scanner = new Scanner(System.in);
		Utilidad.showMessage("-----------------------------Crear Cliente\n");
		Utilidad.showMessage("Ingresa RUT del Cliente: \n");
		String runCliente = scanner.nextLine();
		Utilidad.showMessage("Ingresa Nombre del Cliente: \n");
		String nombreCliente = scanner.nextLine();
		Utilidad.showMessage("Ingresa Apellido del Cliente: \n");
		String apellidoCliente = scanner.nextLine();
		Utilidad.showMessage("Ingresa años como Cliente: \n");
		String aniosCliente = scanner.nextLine(); 
		Utilidad.showMessage("Ingresa la categoría del Cliente: \n");
		String categoriaCliente = scanner.nextLine();
		Utilidad.showMessage("------------------------------------------\n");
		return creandoCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, categoriaCliente);
	}
	
	public Cliente creandoCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente, String categoriaCliente){
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, categoriaCliente);
		return cliente;
	}
	
	
	public void editandoCliente(List<Cliente> listaClientes) {
		Scanner scanner = new Scanner(System.in);
		Utilidad.showMessage("Ingresa el RUN del Cliente a buscar: \n");
		String run = scanner.nextLine();
		for(Cliente cliente : listaClientes) {
			if(cliente.getRunCliente().equals(run)) {
				Utilidad.showMessage("Los datos del cliente seleccionado son los siguientes: \n");
				Utilidad.showMessage("1.-RUN del Cliente \n");
				Utilidad.showMessage(cliente.getRunCliente() + "\n");
				Utilidad.showMessage("2.-Nombre del Cliente \n");
				Utilidad.showMessage(cliente.getNombreCliente() + "\n");
				Utilidad.showMessage("3.-Apellido del Cliente \n");
				Utilidad.showMessage(cliente.getApellidoCliente() + "\n");
				Utilidad.showMessage("4.-Años como Cliente \n");
				Utilidad.showMessage(cliente.getAniosCliente() + "\n");
				Utilidad.showMessage("5.- Categoría del cliente \n");
				Utilidad.showMessage(cliente.getCategoriaCliente() + "\n");
				Utilidad.showMessage("-------------------------------------------\n");
				Utilidad.showMessage("Seleccione la opción a editar: \n");
				Utilidad.showMessage("1.-RUN del Cliente \n");
				Utilidad.showMessage("2.-Nombre del Cliente \n");
				Utilidad.showMessage("3.-Apellido del Cliente \n");
				Utilidad.showMessage("4.-Años como Cliente \n");
				Utilidad.showMessage("5.- Categoría del cliente \n");
				Utilidad.showMessage("--------------------------------------------\n");
				int opcionEdicion = scanner.nextInt();
				if(opcionEdicion == 1) {
					//acá se cae, todo lo demás está bien previamente, pero vuelve al menú principal en este punto
					Utilidad.showMessage("----Usted está cambiando el RUN del Cliente----\n");
					String runNuevo = scanner.nextLine();
					cliente.setRunCliente(runNuevo);
					Utilidad.stopAndContinue();
				} else {if (opcionEdicion == 2) {
					Utilidad.showMessage("----Usted está cambiando el Nombre del Cliente----\n");
					String nombreNuevo = scanner.nextLine();
					cliente.setNombreCliente(nombreNuevo);
				} else {if (opcionEdicion == 3) {
					Utilidad.showMessage("----Usted está cambiando el Apellido del Cliente----\n");
					String apellidoNuevo = scanner.nextLine();
					cliente.setApellidoCliente(apellidoNuevo);
				} else {if (opcionEdicion == 4) {
					Utilidad.showMessage("----Usted está cambiando el Años como Cliente----\n");
					String anioNuevo = scanner.nextLine();
					cliente.setAniosCliente(anioNuevo);
				} else { if (opcionEdicion == 5) {
					Utilidad.showMessage("----Usted está cambiando el Categoría del Cliente----\n");
					String categoriaNuevo = scanner.nextLine();
					cliente.setCategoriaCliente(categoriaNuevo);
				} else {
					Utilidad.showMessage("El número que ingreso es incorrecto \n");
				}
				}}}}
			} 	
		}		
	}
	
 }

