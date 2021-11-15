package unico;

import java.util.Random;

public class Cliente extends Thread{

	private int iId;
	private Peluqueria oPeluqueria;
	
	public Cliente(int iId, Peluqueria oPeluqueria) {
		this.iId = iId;
		this.oPeluqueria = oPeluqueria;
	}

	public int getiId() {
		return iId;
	}
	
	@Override
	public void run() {
		Random ram = new Random();
		try {
			sleep(ram.nextInt(2000));
		} catch (InterruptedException e) {
			System.err.println("El cliente " + getiId() + " ha tenido un error en el run");
			e.printStackTrace();
		}
		oPeluqueria.entrar(this);
		oPeluqueria.pelarse(this);
		try {
			sleep(ram.nextInt(1000));
		} catch (InterruptedException e) {
			System.err.println("El cliente " +  getiId() + " ha tenido un error en el run");
			e.printStackTrace();
		}
		oPeluqueria.irse(this);
	}
	
	
}
