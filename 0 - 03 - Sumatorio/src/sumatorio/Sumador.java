/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sumatorio;

/**
 * Esta clase sumará todos lso números entre dos números
 *
 * @author Francis
 */
public class Sumador {

    /**
     * Este método suma todos los números que hay en un intervalo
     * @param numero1 Inicio del intervalo
     * @param numero2 Fin del intervalo
     * @return Suma de todos los números que hay en el intervalo definido
     */
    public static int sumar(int numero1, int numero2) 
    {
        int suma = 0;
        for (int i = numero1; i <= numero2; i++) 
        {
            suma += i;
        }
        return suma;
    }

    public static void main(String[] args) 
    {
        // Obtenemos los parámetros pasados al crear el proceso
        int numero1 = Integer.valueOf(args[0]);
        int numero2 = Integer.valueOf(args[1]);
        
        int suma = sumar(numero1, numero2);
        
        System.out.println("La suma es: " + suma);
    }
}
