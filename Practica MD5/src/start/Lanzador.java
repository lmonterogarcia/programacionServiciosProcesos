package start;

import java.util.Scanner;
import unico.PracticaMD5;
import view.Login;

public class Lanzador {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.print("1. Practica MD5\n2. Practica MD5 con DB.\nIntroduce una opcion: ");

		String sOpcion = teclado.nextLine();

		try {
			switch (Byte.parseByte(sOpcion)) {

			case 1:
				new PracticaMD5();
				break;

			case 2:
				new Login();
				break;

			default:
				System.out.println("Solo puedes escoger solo entre dos opciones...");
				break;
			}
		} catch (Exception e) {
			System.out.println("Solo puedes escoger solo entre números...");
		}

	}

}
