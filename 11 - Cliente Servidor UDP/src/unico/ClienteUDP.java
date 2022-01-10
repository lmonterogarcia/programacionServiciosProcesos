package unico;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {

	private static final int IPUERTO = 6789;
	private static final String SHOST = "localhost";
	
	public ClienteUDP() {
		
		try {
			 
			String sMensajeEnviar = String.valueOf(", Hola Servidor.");
			// Creo el socket UDP
			DatagramSocket skCliente = new DatagramSocket();
			byte[] bMensaje = sMensajeEnviar.getBytes();
			// Obtengo la direccion del host
			InetAddress hostServidor = InetAddress.getByName(SHOST);
			// Construimos un datagrama para enviar el mensaje al servidor
			DatagramPacket peticion = new DatagramPacket(bMensaje,sMensajeEnviar.length(),hostServidor, IPUERTO);
			// Enviamos el datagrama
			skCliente.send(peticion);
			// Construimos el DatagramPacket que contendrá la respuesta
			byte[] bufer = new byte[1000];
			DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
			skCliente.receive(respuesta);
			// Enviamos la respuesta del servidor a la salida estandar
			System.out.println("Respuesta: " + new String(respuesta.getData()));
			// Cerramos el socket
			skCliente.close();
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	
	
	public static void main(String[] args) {
		new ClienteUDP();
	}
}
