package unico;

public class Hilo1 extends Thread {

	String sMensaje;
	
	public Hilo1(String sMensaje) {
		this.sMensaje = sMensaje;
	}
	
	// Override
	public void run() {
		System.out.println("Hilo 1: " + sMensaje);
	}
}
