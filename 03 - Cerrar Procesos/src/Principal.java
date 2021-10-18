import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		
		//Ruta ejecutable de Google Chrome
		String sRutaProcesos = "/System/Applications/Automator.app/Contents/MacOS/Automator"; 
		
		//CReamos el proceso
		ProcessBuilder pb = new ProcessBuilder(sRutaProcesos);
		Scanner teclado = new Scanner(System.in);
		
		try {
			Process process = pb.start();
			System.out.println("Terminar el proceso? (S/N): ");
			if (teclado.nextLine().toUpperCase().charAt(0) == 'S') {
				process.destroy();
			}
		} catch (IOException e) {
			System.err.println("Error al acceder al archivo");
		}

	}

}
