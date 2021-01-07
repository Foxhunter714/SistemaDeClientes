package servicios;

import java.util.List;
import model.Cliente;

public abstract class Exportador {
	public abstract void exportar(String fileName, List<Cliente> listaClientes);
}
