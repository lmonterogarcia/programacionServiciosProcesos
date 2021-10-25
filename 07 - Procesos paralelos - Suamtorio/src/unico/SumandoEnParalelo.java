package unico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

/**
 * Esta clase es la principal
 *
 * @author Luis Montero
 */
public class SumandoEnParalelo {
	/**
	 * Esta es la metodo main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Creamos las variables para leer por teclado, para guardar los 4 numeros y los
		// dos archivos donde vamos a guardar los resultados.
		Scanner teclado = new Scanner(System.in);
		int iNumero1, iNumero2, iNumero3, iNumero4;
		File suma1 = new File("suma1");
		File suma2 = new File("suma2");

		// Pedimos al usuario los 2 numeros
		System.out.println("Dame un número:");
		iNumero1 = teclado.nextInt();
		System.out.println("Dame otro número:");
		iNumero2 = teclado.nextInt();

		// Cerramos el Scanner
		teclado.close();

		// Llamamos al método para que haga las sumas en paralelo
		sumarNumeros(iNumero1, iNumero2, suma1, suma2);

		// Mostramos por pantalla el resultado de sumar los dos archivos
		System.out.println(sumarFicheros(suma1, suma2));

	}

	/**
	 * Este metodo recoge los dos numeros del intervalo que va aser sumado. Crea los
	 * dos procesos y los ejecuta en paralero. espera que termine su ejecuvión. Como
	 * se utiliza el metodo redirect(FIle fch) los resultados serán guardados en
	 * archivos.
	 * 
	 * @param iNumero1
	 * @param iNumero2
	 * @param suma1
	 * @param suma2
	 */
	private static void sumarNumeros(int iNumero1, int iNumero2, File suma1, File suma2) {

		// Defino dónde está el home de java
		String javaHome = System.getProperty("java.home");

		// Defino dónde está el bin de Java
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";

		// Defino el path de java
		String classpath = System.getProperty("java.class.path");

		// Obtengo el nombre canónico de la clase que se va a ejecutar
		String className = Sumador.class.getCanonicalName();

		// Intercambio las variables si entran en orden invertido
		if (iNumero1 > iNumero2) {

			// Creo la variable de intercambio
			int iIntercambio;

			iIntercambio = iNumero1;
			iNumero1 = iNumero2;
			iNumero2 = iIntercambio;
		}

		try {
			// Creo los procesos, les digo donde tiene que guardar los output y los ejecuto.
			// Se ha creado un algoritmo que separa las suma en dos partes.
			Process process1 = new ProcessBuilder(javaBin, "-cp", classpath, className, String.valueOf(iNumero1),
					String.valueOf((int) ((iNumero1 + iNumero2) / 2))).redirectOutput(suma1).start();
			Process process2 = new ProcessBuilder(javaBin, "-cp", classpath, className,
					String.valueOf((int) ((iNumero1 + iNumero2) / 2) + 1), String.valueOf(iNumero2))
							.redirectOutput(suma2).start();

			// Espero aque acaben los procesos
			process1.waitFor();
			process2.waitFor();

		} catch (IOException | InterruptedException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
		}
	}

	/**
	 * Este metodo recibe dos archivos, leera su primera linea y sumara su
	 * contenido. Si al hacer el casting hay algun problema devolvera un mensaje de
	 * error.
	 *
	 * @param suma1
	 * @param suma2
	 * @return Mensaje con la suma o mensaje de error
	 */
	private static String sumarFicheros(File suma1, File suma2) {

		String sResultado = "";
		int iResultado1, iResultado2;

		try {
			// Leo los resultados de los archivos y se lo asignamos a
			BufferedReader br1 = new BufferedReader(new FileReader(suma1));
			BufferedReader br2 = new BufferedReader(new FileReader(suma2));
			String sLineaLeida1 = br1.readLine();
			String sLineaLeida2 = br2.readLine();
			iResultado1 = Integer.parseInt(sLineaLeida1);
			iResultado2 = Integer.parseInt(sLineaLeida2);

			// Cierro los BufferedReaders
			br1.close();
			br2.close();

			// Asigno a la variable la suma total de los dos ficheros
			sResultado = "El resultado es: " + (iResultado1 + iResultado2);

		} catch (IOException ex) {
			System.err.println("Error: " + ex.toString());
			System.exit(-1);
			sResultado = "Ha ocurrido un error y no es posible enseñar el resultado";
		}

		return sResultado;

	}

}
