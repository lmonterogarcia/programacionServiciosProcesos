package unico;

public class HiloPar extends Thread{

	public HiloPar () {
		byte bTotal = 0;
		for (int i = 2; i <= 20; i += 2) {
			System.out.println(i);
			bTotal += i;
		}
		System.out.println("Los Pares suman: " + bTotal);
	}
}
