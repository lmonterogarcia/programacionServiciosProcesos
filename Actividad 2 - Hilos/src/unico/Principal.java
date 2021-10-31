package unico;

public class Principal {

	public static void main(String[] args) {
				
		Thread hebra1 = new Thread(new Hilo());
		hebra1.start();

	}
}
