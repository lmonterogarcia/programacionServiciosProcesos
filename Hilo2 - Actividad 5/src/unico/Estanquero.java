package unico;

import java.util.Random;

public class Estanquero extends Thread{

	private Mostrador oMostrador;

	public Estanquero(Mostrador oMostrador) {
		this.oMostrador = oMostrador;
	}

	public Mostrador getoMostrador() {
		return oMostrador;
	}

	public void setoMostrador(Mostrador oMostrador) {
		this.oMostrador = oMostrador;
	}
	
	@Override
	public void run() {
		while (true) {
			int iIngrediente = new Random().nextInt(3);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oMostrador.ponerIngrediente(iIngrediente);
		}
	}
	
}
