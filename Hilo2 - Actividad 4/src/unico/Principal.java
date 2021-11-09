package unico;

public class Principal {

	public static void main(String[] args) {
		
		final int iDORMIRCONSUMIDOR = 500, IDORMIRPRODUCTOR = 3000;
		
		Buffer almacen = new Buffer();
		Productor productor = new Productor(almacen, IDORMIRPRODUCTOR);
		Consumidor consumidor = new Consumidor(almacen, iDORMIRCONSUMIDOR);
		
		productor.start();
		consumidor.start();
		
	}

}
