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

import model.CategoriaEnum;
import model.Cliente;
import utilidades.Utilidad;

//TODO los nombres de clases son con minúscula => Ño
public class ArchivoServicio extends Exportador {
	Scanner scanner = new Scanner(System.in);

	public List<Cliente> cargarDatos(String fileName) {
		String filePath = scanner.nextLine();
		String file = filePath + "/" + fileName;

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(new File(file));
			br = new BufferedReader(fr);
			return br.lines().map(line -> line.split(","))
					.map(values -> new Cliente(values[0], values[1], values[2], values[3], CategoriaEnum.ACTIVO))
					.collect(Collectors.toList()); // TODO cambiar
		} catch (Exception error) {
			Utilidad.showMessage("No se pudo cargar el archivo .csv\n");
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception error) {
				Utilidad.showMessage("No se pudo crear el archivo\n");
			}
		}
		return null;
	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// Una clase que genera 2 instancias de 2 clases distintas llamadas de la misma
		// forma
		Exportador exportador = new ExportarCsv();
		Exportador exportador2 = new ExportarTxt();
		exportador.exportar(fileName, listaClientes);
		exportador2.exportar(fileName, listaClientes);
	}
}
