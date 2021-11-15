package unico;

public class Main {

	public static void main(String[] args) {
		
		int iSillasDeEspera = 4;
		int iNumClientes = 5;
		Peluqueria oPeluqueria = new Peluqueria(iSillasDeEspera);
		Barbero oBarbero = new Barbero(oPeluqueria, iNumClientes);
		
		oBarbero.start();
		
		for (int i = 0; i < iNumClientes; i++) {
			Cliente oCliente = new Cliente(i, oPeluqueria);
			oCliente.start();
		}
		
		

	}

}
