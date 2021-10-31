package unico;

public class Principal {

	public static void main(String[] args) {
		
		HiloImpar hiImpares = new HiloImpar();
		HiloPar hiPares = new HiloPar();
		
		hiImpares.start();
		hiPares.start();

	}

}
