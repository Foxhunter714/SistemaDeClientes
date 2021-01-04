package servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import utilidades.Utilidad;

public class ExportarTxt extends Exportador {
	Scanner scanner = new Scanner(System.in);
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {		
		if (listaClientes == null) {
			Utilidad.showMessage("La lista está vacía...\n");
		} else {
			Utilidad.showMessage("-----------------------------Exportar Datos\n");
			Utilidad.showMessage("Ingresa la ruta a donde quieres exportar los datos: \n");
			String cvsSeparatorValue = ",";
			String filePath = scanner.nextLine();
			String file = filePath + "/" + fileName;
			File fl = new File(file);
			if (fl.exists()) {
				fl.delete();
			}

			try {
				PrintWriter pWriter = new PrintWriter(new FileWriter(file));

				listaClientes.forEach(cliente -> {
					pWriter.append(cliente.getRunCliente()).append(cvsSeparatorValue).append(cliente.getNombreCliente())
							.append(cvsSeparatorValue).append(cliente.getApellidoCliente()).append(cvsSeparatorValue)
							.append(cliente.getAniosCliente()).append(cvsSeparatorValue)
							.append(cliente.getCategoriaCliente()).append(System.lineSeparator());
				});
				pWriter.close();
				Utilidad.showMessage("Datos exportados correctamente en formato .txt\n");
			} catch (IOException error) {
				Utilidad.showMessage("El archivo no pudo ser creado en formato .txt\n");
			} finally {
				Utilidad.showMessage("----------------------------\n");
			}

		}
		
	} 
}
