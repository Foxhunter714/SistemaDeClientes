package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import model.Cliente;
import utilidades.Utilidad;

//TODO los nombres de clases son con minúscula
public class ArchivoServicios extends Exportador{
	
	Scanner scanner = new Scanner(System.in);
	
	@SuppressWarnings("resource")
	public List<Cliente> cargarDatos(String fileName){
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		Utilidad.showMessage("-------------------------Cargar Datos---------------------\n");
		Utilidad.showMessage("Ingresa la ruta en donde se encuentra el archivo inventario.csv: \n");
		String filePath = scanner.nextLine();
		String file = filePath + "/" + fileName;
		
		FileReader fr = null;
		BufferedReader br = null;
			
		try {
			fr = new FileReader(new File(file));
			br = new BufferedReader(fr);
			return br.lines().map(line -> line.split(",")).map(values -> 
			//Falta cambiar el valor 0 del values por un int
			new Cliente(values[0], values[1], values[2], values[3], values[4]))
			.collect(Collectors.toList()); 
		} catch(Exception error) {
			Utilidad.showMessage("No se pudo cargar el archivo .csv\n");
		} finally {
			try {
				if ( null != fr) {
					fr.close();
			}
		} catch (Exception error) {
			Utilidad.showMessage("No se pudo cerrar el archivo\n");
		} 
	} 
		return null;
  }	
}
		