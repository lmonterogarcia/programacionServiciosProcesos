package unico;

import java.util.Random;

public class Barbero extends Thread{

	private Peluqueria oPeluqueria;
	private static int iClientesTotales;
	
	public Barbero(Peluqueria oPeluqueria, int iClientes) {
		this.oPeluqueria = oPeluqueria;
		iClientesTotales = iClientes;
	}
	
	public static int getiClientesTotales() {
		return iClientesTotales;
	}

	public static void setiClientesTotales(int iClientes) {
		iClientesTotales = iClientes;
	}

	@Override
	public void run() {
		Random ram = new Random();
		while (iClientesTotales > 0) {
			try {
				sleep(ram.nextInt(2000));
			} catch (InterruptedException e) {
				System.err.println("El barbero ha tenido un error en el run");
				e.printStackTrace();
			}
			oPeluqueria.dormir();
		}
	}
}
