package unico;

import java.util.Random;

public class Peluqueria {

	boolean booSillaPrincipal, booBarberoDurmiendo;
	int iHayClientes, iSillasDeEspera;

	public Peluqueria() {
		Random ram = new Random();
		this.booSillaPrincipal = true;
		this.iHayClientes = 0;
		this.iSillasDeEspera = ram.nextInt(4) + 1;
		System.out.println("Hay " + this.iSillasDeEspera + " silla de espera");
		booBarberoDurmiendo = false;
	}

	public synchronized void dormir() {
		while (iHayClientes > 0 || booBarberoDurmiendo || !booSillaPrincipal) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		booBarberoDurmiendo = true;
		System.out.println("El barbero se ha sentado en la sillon a dormir");
		booSillaPrincipal = false;
		notifyAll();
	}

	public synchronized void entrar(Cliente oCliente) {
		while (iHayClientes >= iSillasDeEspera) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (booBarberoDurmiendo) {
			System.out.println("El barbero se despierta");
			booBarberoDurmiendo = false;
			booSillaPrincipal = true;
		}
		iHayClientes++;
		System.out.println("El cliente " + oCliente.getiId() + " ha entrado y se ha sentado en una silla de espera");
		notifyAll();
	}

	public synchronized void pelarse(Cliente oCliente) {
		while (!booSillaPrincipal) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		booSillaPrincipal = false;
		iHayClientes--;
		System.out.println("El cliente " + oCliente.getiId() + " se esta pelando");
		notifyAll();
	}

	public synchronized void irse(Cliente oCliente) {
		while (booSillaPrincipal) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		booSillaPrincipal = true;
		System.out.println("El cliente " + oCliente.getiId() + " paga y se va");
		notifyAll();
	}

}
