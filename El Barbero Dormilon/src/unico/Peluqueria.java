package unico;

public class Peluqueria {

	boolean booSillonPelarLibre, booBarberoDurmiendo;
	int iSillasOcupadas, iTotalSillas;
	
	public Peluqueria(int iTotalSillas) {
		
		this.booSillonPelarLibre = true;
		this.booBarberoDurmiendo = false;
		this.iSillasOcupadas = 0;
		this.iTotalSillas = iTotalSillas;
	}

	public synchronized void dormir() {
		while (!booSillonPelarLibre || booBarberoDurmiendo || iSillasOcupadas > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("El barbero ha tenido un error al dormirse");
				e.printStackTrace();
			}
		}
		System.out.println("El barbero se ha dormido en el sillon");
		booSillonPelarLibre = false;
		booBarberoDurmiendo = true;
		notifyAll();
		
	}

	public synchronized void entrar(Cliente oCliente) {
		while (iSillasOcupadas >= iTotalSillas) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("El cliente " + oCliente.getiId() + " ha tenido un error entrar");
				e.printStackTrace();
			}
		}
		System.out.println("Ha entrado el cliente " + oCliente.getiId() + " y se sienta en una silla de espera");
		if (booBarberoDurmiendo) {
			System.out.println("El barbero se despierta y se levanta del sillon");
			booBarberoDurmiendo = false;
			booSillonPelarLibre = true;
		}
		iSillasOcupadas++;
		notifyAll();
	}

	public synchronized void pelarse(Cliente oCliente) {
		while (!booSillonPelarLibre) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("El cliente " + oCliente.getiId() + " ha tenido un error pelarse");
				e.printStackTrace();
			}
		}
		System.out.println("El barbero empieza a pelar al cliente " + oCliente.getiId() + ".");
		booSillonPelarLibre = false;
		iSillasOcupadas--;
		Barbero.setiClientesTotales(Barbero.getiClientesTotales() - 1);
		notifyAll();
	}

	public synchronized void irse(Cliente oCliente) {
		while (booSillonPelarLibre) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.err.println("El cliente " + oCliente.getiId() + " ha tenido un error irse");
				e.printStackTrace();
			}
		}
		
		System.out.println("El barbero termina de pelar al cliente " + oCliente.getiId() + ". El cliente paga y se va.");
		booSillonPelarLibre = true;
		notifyAll();
	}

}
