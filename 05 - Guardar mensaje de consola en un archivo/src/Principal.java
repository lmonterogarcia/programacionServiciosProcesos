import java.io.IOException;
import java.io.InputStream;

public class Principal {

	public static void main(String[] args) {
		//Ruta ejecutable de Google Chrome
		String sRutaProcesos = "/System/Applications/Utilities/Terminal.app/Contents/MacOS/Terminal"; 

		//Creamos el proceso
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "date > mensaje.txt");


		try {
			String sResultado = "La consola devuelve\n";
			Process process = pb.start();
		} catch (IOException e) {
			System.err.println("Error al acceder al archivo");
		}

	}

}
