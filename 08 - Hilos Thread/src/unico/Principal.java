package unico;

public class Principal extends Thread{

String sMensaje;
	
	public Principal(String sMensaje) {
		this.sMensaje = sMensaje;
	}
	
	// Override
	public void run() {
		System.out.println("Hilo 1: " + sMensaje);
	}
	
	public static void main(String[] args) {
		
		Hilo1 miPrimerHilo = new Hilo1("Hola, te saludo desde un hilo de una clase!");
		Principal miSegundoHilo = new Principal("Hola, te saludo desde un hilo de esta clase");
		
		miPrimerHilo.start();
		miSegundoHilo.start();

	}

}
