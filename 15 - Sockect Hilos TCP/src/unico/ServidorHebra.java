package unico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

public class ServidorHebra extends Thread {

	private Socket socketCliente;
	private DataInputStream entrada;
	private DataOutputStream salida;

	public ServidorHebra(Socket socketCliente, DataInputStream entrada, DataOutputStream salida) {
		this.socketCliente = socketCliente;
		this.entrada = entrada;
		this.salida = salida;
	}

	@Override
	public void run() {
		boolean salir = true;
		String mensajeRecibido;
		Random generador = new Random();

		while (salir) {
			try {
				salida.writeUTF(
						"SERVIDOR:\n¿Que quieres hacer?\n\t" + "1. Generar numero aleatorio.\n\t" + "2. Salir\n\t");
				mensajeRecibido = entrada.readUTF();
				switch (mensajeRecibido) {
				case "1":
					int aleatorio = generador.nextInt(500);
					salida.writeUTF("SERVIDOR: El numero aleatorio es " + aleatorio);
					break;
				case "2":
					System.out.println("SERVIDOR: El cliente " + this.socketCliente + " enviar salir");
					System.out.println("SERVIDOR: Cerrando conexion");
					this.socketCliente.close();
					salir = false;
					break;
				default:
					break;
				}

			} catch (IOException e) {
				System.out.println("ERROR SERVIDOR: " + e.getMessage());
			}

		}
		try {
			entrada.close();
			salida.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
