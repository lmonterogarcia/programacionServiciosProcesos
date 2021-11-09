package unico;

public class Principal {

	public static void main(String[] args) {
		

		Corredor oCorrdor1 = new Corredor("Jaime");
		Corredor oCorrdor2 = new Corredor("Manuel");
		Corredor oCorrdor3 = new Corredor("Rosa");
		
		oCorrdor1.setPriority(Thread.NORM_PRIORITY);
		oCorrdor1.start();
		oCorrdor2.setPriority(Thread.MIN_PRIORITY);
		oCorrdor2.start();
		oCorrdor3.setPriority(Thread.MAX_PRIORITY);
		oCorrdor3.start();

	}

}
