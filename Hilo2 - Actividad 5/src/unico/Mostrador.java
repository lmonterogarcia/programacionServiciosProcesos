package unico;

public class Mostrador {

	private boolean booIngredienteEnMesa = false;
	private boolean booFumando = false;
	private Integer iIngrediente = null;
	
	public synchronized void ponerIngrediente(int iIngrediente) {
		while (booIngredienteEnMesa || booFumando) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Error, el estanquero no puede esperar!.\n" + e.getMessage());
			}
		}
		this.iIngrediente = iIngrediente;
		System.out.println("El estanquero no pone el ingrediente " + iIngrediente + ".");
		booIngredienteEnMesa = true;
		notifyAll();
	}

	public synchronized void empezarFumar(int iIngrediente) {
		while (booFumando || !booIngredienteEnMesa || this.iIngrediente != iIngrediente) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Error, el fumador no puede esperar!.\n" + e.getMessage());
			}
		}
		System.out.println("El fumador " + iIngrediente + " empieza a fumar.");
		booFumando = true;
		booIngredienteEnMesa = false;
	}

	public synchronized void terminarFumar() {
		while (!booFumando) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("Error, el estanquero no puede esperar!.\n" + e.getMessage());
			}
		}
		System.out.println("El fumador " + iIngrediente + " termina de fumar.");
		booFumando = false;
		notifyAll();
		
	}
}
