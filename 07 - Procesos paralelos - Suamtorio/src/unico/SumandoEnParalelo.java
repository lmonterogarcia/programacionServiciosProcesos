package unico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

/**
 *
 * @author Luis Montero
 */
public class SumandoEnParalelo {

	public static void main(String[] args) {

		// Defino dónde está el home de java
		String javaHome = System.getProperty("java.home");

		// Defino dónde está el bin de Java
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";

		// Defino el path de java
		String classpath = System.getProperty("java.class.path");

		// Obtengo el nombre canónico de la clase que se va a ejecutar
		String className = Sumador.class.getCanonicalName();

		// Creo los dos archivos donde se guardara cada resultado de cada proceso
		File suma1 = new File("suma1");
		File suma2 = new File("suma2");
		
		// Creo los ProcessBuilder
		ProcessBuilder builder1 = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(1),
				String.valueOf(5)).redirectOutput(suma1);
		ProcessBuilder builder2 = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(6),
				String.valueOf(10)).redirectOutput(suma2);
		
		//Creo los procesos qeu van a ejecutarse en paralelo
		Process process1, process2;
		
		try {
			// Ejecuto los procesos
			process1 = builder1.start();
			process2 = builder2.start();
			process1.wait();
			process2.wait();
			
			
		} catch (IOException | InterruptedException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		}
		
		try {
			
			
			//Leemos los resultados de los archivos
			BufferedReader br1 = new BufferedReader(new FileReader(suma1));
			BufferedReader br2 = new BufferedReader(new FileReader(suma2));
			String sLineaLeida1 = br1.readLine();
			String sLineaLeida2 = br2.readLine();
			int iResultado1 = Integer.parseInt(sLineaLeida1);
			int iResultado2 = Integer.parseInt(sLineaLeida2);
			
			// Imprimimos por pantalla la suma
			System.out.println("El resultado es: " + (iResultado1 + iResultado2));
		} catch (IOException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		}

	}

}
