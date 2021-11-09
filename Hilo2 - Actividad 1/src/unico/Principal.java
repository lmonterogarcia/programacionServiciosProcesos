package unico;

public class Principal {

	public static void main(String[] args) {
		
		
		Cliente oCliente1 = new Cliente("Pepe", new int[]{1,2});
		Cliente oCliente2 = new Cliente("Claudia", new int[]{10,1,2,2});
		Cliente oCliente3 = new Cliente("Fernando", new int[]{4,2,6,2});
		
		Cajera oCajera1 = new Cajera("Ana", oCliente1);
		Cajera oCajera2 = new Cajera("Lorena", oCliente2);
		Cajera oCajera3 = new Cajera("Nieves", oCliente3);
		
		oCajera1.start();
		oCajera2.start();
		oCajera3.start();
	}

}
