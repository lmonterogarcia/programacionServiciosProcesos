package unico;

import java.security.DrbgParameters.NextBytes;
import java.util.Random;

public class Corredor extends Thread{

	private String sNombre;

	public Corredor(String sNombre) {
		super();
		this.sNombre = sNombre;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 11; i++) {
			System.out.println("El corredor " + sNombre + " lleva " + i + "km.");
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---- EL CORREDOR " + sNombre + " LLEGO A LA META ----");
	}
}
