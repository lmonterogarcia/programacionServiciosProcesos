package unico;

import java.util.Random;

public class Peluquero extends Thread{

	private Peluqueria oPeluqueria;
	
	public Peluquero(Peluqueria oPeluqueria) {
		
		this.oPeluqueria = oPeluqueria;
	}
	
	@Override
	public void run() {
		Random ram = new Random();
		while (true) {
			try {
				sleep(ram.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			oPeluqueria.dormir();
		}	
	}
}
