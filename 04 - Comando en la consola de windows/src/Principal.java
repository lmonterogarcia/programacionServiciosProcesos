import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Ruta ejecutable de Google Chrome
		String sRutaProcesos = "/System/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal"; 

		//Creamos el proceso
		//				ProcessBuilder pb = new ProcessBuilder("bash", "-c", "date");
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "werfe");


		try {
			String sResultado = "La consola devuelve\n";
			Process process = pb.start();
			InputStream sInput = process.getInputStream();
			InputStream sError = process.getErrorStream();

			int i = sInput.read();
			if (i != -1) {
				sResultado += "Un mensaje - ";
			}
			while (i != -1) {
				sResultado += (char)(i);
				i = sInput.read();
			}

			int j = sError.read();

			if (j != -1) {
				sResultado += "Un error - ";
			}

			while (j != -1) {
				sResultado += (char)(j);
				j = sError.read();
			}
			System.out.println(sResultado);
		} catch (IOException e) {
			System.err.println("Error al acceder al archivo");
		}

	}

}
