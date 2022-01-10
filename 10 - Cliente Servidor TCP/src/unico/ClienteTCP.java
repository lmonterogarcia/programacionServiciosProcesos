package unico;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {
	
	private static final int IPUERTO = 6000;
	private static final String SHOST = "localhost";
	
	public ClienteTCP() {
		try {
			Socket skCliente = new Socket(SHOST, IPUERTO);
			InputStream aux = skCliente.getInputStream();
			DataInputStream flujo = new DataInputStream(aux);
			System.out.println("Mensaje recibido del Servidor");
			System.out.println(flujo.readUTF());
			skCliente.close();
			
		} catch (UnknownHostException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		new ClienteTCP();
	}
}
