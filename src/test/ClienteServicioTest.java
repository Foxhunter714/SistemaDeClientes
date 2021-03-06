package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CategoriaEnum;
import model.Cliente;
import servicios.ClienteServicio;

public class ClienteServicioTest {

	private ClienteServicio clienteServicio;
	private Cliente cliente;

	@Before
	public void setUp() {
		clienteServicio = new ClienteServicio();
		cliente = new Cliente();
	}

	@Test
	public void agregarClienteTest() {
		// Given
		String runCliente = "18871922-1";
		String nombreCliente = "Alejandro";
		String apellidoCliente = "Garcia";
		String aniosCliente = "23";
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		// When

		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		cliente = clienteServicio.getListaClientes().get(0);
		String a = cliente.getNombreCliente();
		System.out.print(a);

		// Then
		assertEquals(a, "Alejandro");
	}

	@Test
	public void agregarClienteNuloTest() {
		// Given
		String runCliente = "";
		String nombreCliente = "";
		String apellidoCliente = "";
		String aniosCliente = "";
		CategoriaEnum nombreCategoria = null;

		// When
		clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
		cliente = clienteServicio.getListaClientes().get(0);
		String a = cliente.getNombreCliente();
		System.out.print(a);

		// Then
		assertNull(a, null);
	}

}
