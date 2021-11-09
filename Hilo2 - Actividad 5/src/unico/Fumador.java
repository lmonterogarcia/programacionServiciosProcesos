package unico;

public class Fumador extends Thread{

	private int iNum, iIngrediente;
	private Mostrador oMostrador;

	public Fumador(int iNum, int iIngrdiente, Mostrador oMostrador) {
		this.iNum = iNum;
		this.iIngrediente = iIngrdiente;
		this.oMostrador = oMostrador;
	}
	
	public int getiNum() {
		return iNum;
	}

	public void setiNum(int iNum) {
		this.iNum = iNum;
	}

	public int getiIngrdiente() {
		return iIngrediente;
	}

	public void setiIngrdiente(int iIngrdiente) {
		this.iIngrediente = iIngrdiente;
	}

	public Mostrador getoMostrador() {
		return oMostrador;
	}
	
	public void setoMostrador(Mostrador oMostrador) {
		this.oMostrador = oMostrador;
	}

	@Override
	public void run() {
		while (true) {
			oMostrador.empezarFumar(iIngrediente);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			oMostrador.terminarFumar();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
