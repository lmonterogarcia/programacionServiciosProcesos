package unico;

public class Cliente {

	private String sNombre;
	private int[] aTiempoProductos;
	
	
	public Cliente(String sNombre, int[] aTiempoProductos) {
		this.sNombre = sNombre;
		this.aTiempoProductos = aTiempoProductos;
	}


	public String getsNombre() {
		return sNombre;
	}


	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}


	public int[] getaTiempoProductos() {
		return aTiempoProductos;
	}


	public void setaTiempoProductos(int[] aTiempoProductos) {
		this.aTiempoProductos = aTiempoProductos;
	}
	
	
	
	
}
