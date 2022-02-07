package unico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author luis
 * 
 *         No se ha cambiado nada del ejemplo que se ha hecho en clase.
 *
 */
public class Servidor {

	public static void main(String[] args) {

		try {
			ServerSocket socketServidor = new ServerSocket(5056);
			System.out.println("SERVIDOR: Escuchando en localhost 5056 ...");

			while (true) {
				Socket socketCliente = null;
				try {
					socketCliente = socketServidor.accept();
					System.out.println("SERVIDOR: Cliente nuevo conectado " + socketCliente);
					DataInputStream entrada = new DataInputStream(socketCliente.getInputStream());
					DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
					System.out.println("SERVIDOR: Creando una hebra nueva para el cliente nuevo.");

					Thread clienteHebra = new ServidorHebra(socketCliente, entrada, salida);
					clienteHebra.start();
					System.out.println("SERVIDOR: Hebra del cliente nuevo creada (yo me despreocupo).");
				} catch (Exception e) {
					socketCliente.close();
					System.out.println("ERROR SERVIDOR." + e.toString());
				}
			}
		} catch (IOException e) {
			System.err.println("ERROR SERVIDOR: " + e.getMessage());
		}

	}

}
