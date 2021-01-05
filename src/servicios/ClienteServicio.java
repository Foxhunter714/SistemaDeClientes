package servicios;

import java.util.ArrayList;
import java.util.List;
import model.CategoriaEnum;
import model.Cliente;
import utilidades.Utilidad;

public class ClienteServicio {
	// [X]TODO falta indentar el código
	// [X]eliminar comentarios innecesarios
	// []Eliminar todos los \n
	List<Cliente> listaClientes;
	
	public ClienteServicio() {
		listaClientes = new ArrayList<>();
	}

	@SuppressWarnings("null")
	public void listarClientes() {
		//TODO que no se puedan agregar valores nulos al agregar usuario
			
			if (listaClientes != null) {
					
					for (Cliente cliente : listaClientes) {
						Utilidad.showMessage("Datos del Cliente:");
						Utilidad.showMessage("RUN: " + cliente.getRunCliente());
						Utilidad.showMessage("Nombre: " + cliente.getNombreCliente());
						Utilidad.showMessage("Apellido: " + cliente.getApellidoCliente());
						Utilidad.showMessage("Años como cliente: " + cliente.getAniosCliente());
						Utilidad.showMessage("Categoría del cliente: " + cliente.getNombreCategoria());
						Utilidad.showMessagePredefined();
					}
				}
			 else {
				 Utilidad.showMessage("No se ha podido listar a los clientes, aún no carga datos");	
			 } 
		 }
	

	public void agregarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria) {
		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);
		
		if(listaClientes != null) {
		listaClientes.add(cliente);
		}
		else {
			Utilidad.showMessage("El cliente al cual usted está agregando viene nulo");
		}
	}

	public void editarCliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente,
			CategoriaEnum nombreCategoria, List<Cliente> listaClientes) {
		
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
}
