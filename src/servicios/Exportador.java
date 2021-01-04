package servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import utilidades.Utilidad;

//[X]TODO esto debería ser una clase abstracta sin implementación, solo con un método exportar(String filename, List<Cliente> listaClientes)
//Luego, existen 2 clases: ExportadorCSV y ExportadorTxt que extienden de esta clase e implementan el método exportar
//Entonces, los métodos declarados acá, en realidad son de cada Exportador
//Concepto de herencia
//Al utilizarlo, se instancia alguno de los 2 exportadores (csv o txt) ocupando polimorfismo al llamar al método exportar(String, List<Cliente>)
public abstract class Exportador {
	public abstract void exportar(String fileName, List<Cliente> listaClientes);
}
