package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.CategoriaEnum;
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
	void crearClienteTest() {
		//Given
		String runCliente = "18871922-1";
		String nombreCliente = "Alejandro";
		String apellidoCliente = "Garcia";
		String aniosCliente = "23";
		CategoriaEnum nombreCategoria = CategoriaEnum.ACTIVO;
		
		//When
		cliente = clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria.name());
		//cliente = clienteServicio.agregarCliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);
		String a = cliente.getNombreCliente();
		System.out.print(a);

		//Then
		assertEquals(a, "Alejandro");
	}

}
