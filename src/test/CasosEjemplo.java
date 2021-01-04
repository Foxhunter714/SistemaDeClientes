package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Cliente;
import servicios.ClienteServicio;

public class CasosEjemplo {

	private ClienteServicio clienteServicio;
	private Cliente cliente;
	@Before
	void setUp() {
		clienteServicio = new ClienteServicio();
		cliente = new Cliente();
	}

	@Test
	final void crearClienteTest() {
		//Given
		String runCliente = "18871922-1";
		String nombreCliente = "Alejandro";
		String apellidoCliente = "Garcia";
		String aniosCliente = "23";
		String categoriaCliente = "Gold";
		//When
		
		cliente = clienteServicio.creandoCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, categoriaCliente);
		String a = cliente.getNombreCliente();
		System.out.print(a);
		
		//Then
		assertEquals(a, "Alejandro");
	}

}
