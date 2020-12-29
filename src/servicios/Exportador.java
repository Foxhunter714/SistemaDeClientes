package servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import utilidades.Utilidad;

// TODO esto debería ser una clase abstracta sin implementación, solo con un método exportar(String filename, List<Cliente> listaClientes)
// Luego, existen 2 clases: ExportadorCSV y ExportadorTxt que extienden de esta clase e implementan el método exportar
// Entonces, los métodos declarados acá, en realidad son de cada Exportador
// Concepto de herencia
// Al utilizarlo, se instancia alguno de los 2 exportadores (csv o txt) ocupando polimorfismo al llamar al método exportar(String, List<Cliente>)
public abstract class Exportador {
	Scanner scanner = new Scanner(System.in);
	
	public void exportarTxt(String fileName, List<Cliente> listaClientes) {
	if(listaClientes == null){
		Utilidad.showMessage("La lista está vacía...\n");
	} else {
	Utilidad.showMessage("-----------------------------Exportar Datos\n");
	Utilidad.showMessage("Ingresa la ruta a donde quieres exportar los datos: \n");
	String cvsSeparatorValue = ",";
	String filePath = scanner.nextLine();
	String file = filePath + "/" + fileName;
	File fl = new File(file);
	if(fl.exists()) {
		fl.delete();
	}
	
	try {
		PrintWriter pWriter = new PrintWriter(new FileWriter(file));
		
		listaClientes.forEach(cliente -> {
			pWriter.append(cliente.getRunCliente()).append(cvsSeparatorValue)
			.append(cliente.getNombreCliente()).append(cvsSeparatorValue)
			.append(cliente.getApellidoCliente()).append(cvsSeparatorValue)
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
	public void exportarCsv(String fileName, List<Cliente> listaClientes) {
		if(listaClientes == null){
			Utilidad.showMessage("La lista está vacía...\n");
		} else {
		Utilidad.showMessage("-----------------------------Exportar Datos\n");
		Utilidad.showMessage("Ingresa la ruta a donde quieres exportar los datos: \n");
		String cvsSeparatorValue = ",";
		String filePath = scanner.nextLine();
		String file = filePath + "/" + fileName;
		File fl = new File(file);
		if(fl.exists()) {
			fl.delete();
		}
		
		try {
			PrintWriter pWriter = new PrintWriter(new FileWriter(file));
			
			listaClientes.forEach(cliente -> {
				pWriter.append(cliente.getRunCliente()).append(cvsSeparatorValue)
				.append(cliente.getNombreCliente()).append(cvsSeparatorValue)
				.append(cliente.getApellidoCliente()).append(cvsSeparatorValue)
				.append(cliente.getAniosCliente()).append(cvsSeparatorValue)
				.append(cliente.getCategoriaCliente()).append(System.lineSeparator());
				});
			pWriter.close();
			Utilidad.showMessage("Datos exportados correctamente en formato .csv\n");
			} catch (IOException error) {
				Utilidad.showMessage("El archivo no pudo ser creado en formato .csv\n");
		} finally {
			Utilidad.showMessage("----------------------------\n");
	  }
		
	}
		}
}
