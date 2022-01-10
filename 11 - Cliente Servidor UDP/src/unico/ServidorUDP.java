package unico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {

	private static final int IPUERTO = 6789;
	private static final int IMAXCLIENTES = 7;

	public ServidorUDP() {

		try {
			DatagramSocket skServidor = new DatagramSocket(IPUERTO);
			byte[] bufer = new byte[1000];
			System.out.println("Escucho por el puerto " + IPUERTO);

			for (int iNumCli = 0; iNumCli < IMAXCLIENTES; iNumCli++) {
				// Construimos el DatagramPacket para recibir peticiones
				DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
				// Leemos una petición del DatagramSocket
				skServidor.receive(peticion);
				// Obtengo el mensaje del cliente
				String sMensajeRecibido = new String(peticion.getData());
				// Construimos el DatagramPacket para enviar la respuesta
				String sMensajeRespuesta = "Hola Cliente " +iNumCli + sMensajeRecibido;
				DatagramPacket respuesta = new DatagramPacket(sMensajeRespuesta.getBytes(), sMensajeRespuesta.length(),
						peticion.getAddress(), peticion.getPort());
				skServidor.send(respuesta);
			}

			System.out.println("Ya he terminado con todos los clientes");

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

	}

	public static void main(String[] arsg) {
		new ServidorUDP();
	}

}
