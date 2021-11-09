package unico;

public class Productor extends Thread{

	private Buffer buffAlmacen;
	private int iDormir;
	
	
	public Productor(Buffer buffAlmacen, int iDormir) {
		this.buffAlmacen = buffAlmacen;
		this.iDormir = iDormir;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			buffAlmacen.setiContenido(i);
			System.out.println("El productor pone el elemento " + i + " en el almacen.");
			try {
				sleep(iDormir);
			} catch (InterruptedException e) {
				System.err.println("Error en el productor: " + e.toString());
			}
		}
	}
}
