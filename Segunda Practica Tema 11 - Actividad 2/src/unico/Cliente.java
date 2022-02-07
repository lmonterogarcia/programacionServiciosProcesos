package unico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * @author luis
 * 
 *         El cliente mandara un numero de DNI al servidor para que se lo
 *         devulva con la letra.
 */
public class Cliente {

	public static void main(String[] args) throws IOException {
		String sDireccionIP = "localhost";
		int iPuerto = 5056;

		InetAddress ip = InetAddress.getByName(sDireccionIP);
		System.out.println("CLIENTE: Conectando con " + sDireccionIP + ": " + iPuerto);

		Socket socket = new Socket(ip, iPuerto);
		System.out.println("CLIENTE: Conexion establecida");

		DataInputStream entrada = new DataInputStream(socket.getInputStream());
		DataOutputStream salida = new DataOutputStream(socket.getOutputStream());

		@SuppressWarnings("resource")
		Scanner tecladoString = new Scanner(System.in);

		System.out.println(entrada.readUTF()); // Respuesta del servidor.
		int iNumDNI = tecladoString.nextInt(); // Se pide escribir el DNI.
		salida.writeInt(iNumDNI); // Se envia el DNI al Servidor.
		System.out.println(entrada.readUTF()); // Devlucion del dni con la letra.

	}

}
