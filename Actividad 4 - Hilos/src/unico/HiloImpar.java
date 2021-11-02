package unico;

public class HiloImpar extends Thread {

	public void run() {

		byte bTotal = 0;
		for (int i = 1; i <= 20; i += 2) {
			System.out.println(i);
			bTotal += i;
		}
		System.out.println("Los Impares suman: " + bTotal);
	}
}
