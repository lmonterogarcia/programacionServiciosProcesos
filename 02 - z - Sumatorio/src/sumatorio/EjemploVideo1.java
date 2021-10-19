/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumatorio;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Francis
 */
public class EjemploVideo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Scanner teclado = new Scanner(System.in);
        int numero1, numero2;
        
        System.out.println("Dame un número:");
        numero1 = teclado.nextInt();
        System.out.println("Dame otro número:");
        numero2 = teclado.nextInt();
        // Sumador suma = new Sumador();
        
        try 
        {
            int estado_ejecucion = ejecutarClaseProceso(Sumador.class, numero1, numero2);
            if (estado_ejecucion == 0) 
            {
                System.out.println("Proceso ejecutado correctamente.");
                // System.out.println("La suma es: " + suma.sumar(numero1,numero2));
                
            } 
            else 
            {
                System.out.println("Error ejecutando el proceso.");
            }
        } 
        catch (IOException | InterruptedException ex) 
        {
            System.err.println("Error: " + ex.toString());
            System.exit(-1);
        }
    }

    /**
     * Ejecuta una clase del proyecto en un proceso
     *
     * @param clase Clase a ejecutar
     * @param n1 número 1
     * @param n2 número 2
     * @return Resultado de haber ejecutado el proceso
     * @throws IOException Esta excepción se lanzará si ocurre algún error en la
     * ejecución del proceso
     * @throws InterruptedException Esta excepción se lanzará si ocurre algún
     * error en la ejecución del proceso
     *
     * La clase a ejecutar ha de tener un método main que es el que se ejecutará
     */
    public static int ejecutarClaseProceso(Class clase, int n1, int n2) throws IOException, InterruptedException {
        // Defino dónde está el home de java
        String javaHome = System.getProperty("java.home");
        // Defino dónde está el bin de Java
        String javaBin = javaHome
                + File.separator + "bin"
                + File.separator + "java";
        // Defino el path de java
        String classpath = System.getProperty("java.class.path");
        // Obtengo el nombre canónico de la clase que se va a ejecutar
        String className = clase.getCanonicalName();
        // Creo el proceso a ejecutar
        // Los dos últimos parámetros son los parámetros del método main de la clase 
        ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp",
                classpath, className, String.valueOf(n1), String.valueOf(n2));
        Process process = builder.inheritIO().start();
        // Espero a que se ejecute el proceso
        process.waitFor();
        return process.exitValue();
    }

}
