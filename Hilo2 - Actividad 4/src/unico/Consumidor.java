package unico;

public class Consumidor extends Thread{
	
	private Buffer buffAlmacen;
	private int iDormir;
	
	
	public Consumidor(Buffer buffAlmacen, int iDormir) {
		this.buffAlmacen = buffAlmacen;
		this.iDormir = iDormir;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			buffAlmacen.getiContenido();
			System.out.println("Consumidor coge el elemento " + i + " del almacen.");
			try {
				sleep(iDormir);
			} catch (InterruptedException e) {
				System.err.println("Error en el consumidor: " + e.toString());
			}
		}
	}

}
