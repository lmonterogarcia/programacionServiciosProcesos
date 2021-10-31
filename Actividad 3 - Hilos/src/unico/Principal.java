package unico;

import java.util.Scanner;

public class Principal extends Thread{

	public static void main(String[] args) {
		
		
		String sNombre = pedirNombre();
		String sNombre2 = pedirNombre();
		String sNombre3 = pedirNombre();
		
		Principal hilo1 = new Principal(sNombre);
		Principal hilo2 = new Principal(sNombre2);
		Principal hilo3 = new Principal(sNombre3);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();

	}
	
	private static String pedirNombre() {
		
		String sNombre;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el nombre del corredor: ");
		sNombre = teclado.next();
		return sNombre;
	}

	private Principal(String sNombre) {
	
		for (int i = 0; i < 20; i++) {

			System.out.println(sNombre + " va por el km " + (i + 1) + ".");
			if (i == 19) {
				System.out.println(sNombre + " llego a la meta.");
			}
			
			try {
				this.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	

}
