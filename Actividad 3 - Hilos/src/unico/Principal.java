package unico;

import java.util.Scanner;

public class Principal extends Thread{

	public static void main(String[] args) {
		
		
		String sNombre = pedirNombre();
		Principal hilo1 = new Principal(sNombre);
		
		hilo1.start();

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
				this.sleep(4500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
	

}
