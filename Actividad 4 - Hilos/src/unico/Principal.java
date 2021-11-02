package unico;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		HiloImpar hiImpares = new HiloImpar();
		HiloPar hiPares = new HiloPar();

		hiImpares.start();
		hiImpares.join();
		hiPares.start();

	}

}
