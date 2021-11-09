package unico;

public class Principal {

	public static void main(String[] args) {

		Mostrador oMostrador = new Mostrador();
		Estanquero oEstanquero = new Estanquero(oMostrador);
		Fumador oFumador1 = new Fumador(0, 0, oMostrador);
		Fumador oFumador2 = new Fumador(1, 1, oMostrador);
		Fumador oFumador3 = new Fumador(2, 2, oMostrador);

		oEstanquero.start();
		oFumador1.start();
		oFumador2.start();
		oFumador3.start();

	}

}
