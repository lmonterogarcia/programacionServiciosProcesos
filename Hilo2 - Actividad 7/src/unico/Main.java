package unico;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Peluqueria oPeluqueria = new Peluqueria();
		Peluquero oPeluquero = new Peluquero(oPeluqueria);
		int iClientes = new Random().nextInt(10) + 1; 
		
		System.out.println("Van a entrar " + iClientes + " clientes.");
		
		oPeluquero.start();
		for (int i = 0; i < iClientes; i++) {
			Cliente oCliente = new Cliente(i, oPeluqueria);
			oCliente.start();
		}
	}
}
