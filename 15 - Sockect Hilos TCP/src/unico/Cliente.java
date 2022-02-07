package unico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

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

		boolean booSalir = false;
		Scanner tecladoString = new Scanner(System.in);

		while (!booSalir) {
			System.out.println(entrada.readUTF());
			String sTextoEnviar = tecladoString.nextLine();
			salida.writeUTF(sTextoEnviar);

			switch (sTextoEnviar) {
			case "1":
				String sMensajeRecibido = entrada.readUTF();
				System.out.println(sMensajeRecibido);
				break;

			case "2":
				System.out.println("CLIENTE: cerrando la conexion...");
				socket.close();
				System.out.println("CLIENTE: Conexion cerrada...");
				booSalir = true;
				break;

			default:
				System.out.println("CLIENTE: Opcion incorrecta.");
				break;
			}
		}

	}

}
