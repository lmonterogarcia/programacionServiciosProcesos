package unico;

public class Cajera extends Thread {

	private String sNombre;
	private Cliente oCliente;

	public Cajera(String sNombre, Cliente oCliente) {
		this.sNombre = sNombre;
		this.oCliente = oCliente;
	}

	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public Cliente getoCliente() {
		return oCliente;
	}

	public void setoCliente(Cliente oCliente) {
		this.oCliente = oCliente;
	}

	@Override
	public void run() {
		long lHora = System.currentTimeMillis();
		System.out
				.println("LA CAJERA " + sNombre + " EMPIEZA CON LA COMPRA DEL CLIENTE " + oCliente.getsNombre() + ".");
		for (int i = 0; i < oCliente.getaTiempoProductos().length; i++) {
			try {
				sleep(oCliente.getaTiempoProductos()[i] * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("La cajera " + sNombre + " ha pasado el producto " + (i + 1) + " del cliente "
					+ oCliente.getsNombre() + " y ha tardado " + oCliente.getaTiempoProductos()[i] + " segundos.");
		}
		System.out.println("LA CAJERA " + sNombre + " HA TERMINADO CON LA COMPRA DEL CLIENTE " + oCliente.getsNombre()
				+ " EN " + (((System.currentTimeMillis() - lHora)) / 1000) + " SEGUNDOS.");

	}

}
