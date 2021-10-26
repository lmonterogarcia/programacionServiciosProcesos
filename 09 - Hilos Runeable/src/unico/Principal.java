package unico;

public class Principal {
	
	public static void main(String[] args) {
		
		Hilo1 miPrimerHilo = new Hilo1("Hola, te saludo desde un hilo de una clase!");
		
		Thread hebra1 = new Thread(miPrimerHilo);
		
		hebra1.start();
		

	}

}
