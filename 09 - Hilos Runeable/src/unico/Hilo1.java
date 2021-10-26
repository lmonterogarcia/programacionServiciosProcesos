package unico;

public class Hilo1 implements Runnable {

	String sMensaje;

	public Hilo1(String sMensaje) {
		this.sMensaje = sMensaje;
	}

	// Override
	public void run() {
		System.out.println("Hilo 1: " + sMensaje);
	}
}
