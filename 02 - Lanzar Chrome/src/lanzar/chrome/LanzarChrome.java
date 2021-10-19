
package lanzar.chrome;

import java.io.IOException;

/**
 *
 * @author Luis Montero
 */
public class LanzarChrome {

    public static void main(String[] args) {
        String RUTA_PROCESO = "C:\\Program Files\\WinRAR\\WinRAR.exe";
        // ProcessBuilder pb = new ProcessBuilder(RUTA_PROCESO);
        try {
            // Process process = pb.star();
            Process process = Runtime.getRuntime().exec(RUTA_PROCESO);
            int retorno = process.waitFor();
            System.out.println("La ejecuacion de " + RUTA_PROCESO + " devuelve " + retorno);
        } catch (IOException ex) {
            System.err.println("Error: " + ex.toString());
            System.exit(-1);
        } catch (InterruptedException ex) {
            System.err.println("El proceso hijo finalizo de forma incorrecta");
            System.exit(-1);
        }
    }
    
}
