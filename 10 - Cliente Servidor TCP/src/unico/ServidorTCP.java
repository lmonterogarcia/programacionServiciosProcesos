package unico;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	private static final int IPUERTO = 6000;
	private static final int IMAXCLIENTES = 3;

	public ServidorTCP() {

		try {
			ServerSocket skServidor = new ServerSocket(IPUERTO);

			for (int iNumCli = 0; iNumCli < IMAXCLIENTES; iNumCli++) {
				Socket skCliente = skServidor.accept();
				System.out.println("Sirvo al cliente: " + iNumCli);
				OutputStream aux = skCliente.getOutputStream();
				DataOutputStream flujo = new DataOutputStream(aux);
				flujo.writeUTF("Hola cliente " + iNumCli);
				skCliente.close();
			}
			System.out.println("Ya he terminado con todos los clientes");
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Escucho por el puerto: " + IPUERTO);

	}

	public static void main(String[] arsg) {
		new ServidorTCP();
	}

}
