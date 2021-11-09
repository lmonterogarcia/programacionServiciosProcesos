package unico;

public class Buffer {

	private int iContenido;
	private boolean booDisponible =  false;

	public synchronized int getiContenido() {
		
		while (!booDisponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		booDisponible = false;
		notify();
		return iContenido;
	}

	public synchronized void setiContenido(int iContenido) {
		
		while (booDisponible) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.iContenido = iContenido;
		booDisponible = true;
		notify();
		
	}
	
	
	
}
