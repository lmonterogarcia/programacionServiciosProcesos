package unico;

import java.util.Scanner;

public class Hilo implements Runnable {
	private String sNombre, sDia;
	private float fHora;
	
	public Hilo() {
		setsNombre();
		setsSemana();
		setfHora();
	}

	@Override
	public void run() {
		System.out.println(calcularMensaje());

	}

	private String calcularMensaje() {
		String sMensaje = "";
		
		if (fHora < 8.3) {
			sMensaje = "El alumno " + sNombre + " llego a tiempo para tomarse la temperatura el día " + sDia + "."; 
		} else {
			sMensaje = "El alumno " + sNombre + " llego tarde para tomarse la temperatura el día " + sDia + "."; ;
		}
		
		return sMensaje;
	}

	private void setsNombre() {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el nombre del alumno: ");
		sNombre = teclado.next();
	
	}
	
	private void setsSemana() {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese el dia de la semana: ");
		sDia = teclado.next();
	}
	
	private void setfHora() {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese la hora de llegada: ");
		fHora = Float.parseFloat(teclado.next());
		
	}
}
