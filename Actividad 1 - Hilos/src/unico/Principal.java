package unico;

public class Principal extends Thread{

	public static void main(String[] args) {
		
		Principal hilo1 = new Principal();		
		hilo1.start();
	}
	
	private Principal() {
	
		for (int i = 0; i < 15; i++) {
			System.out.println(i + 1);
			try {
				this.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
