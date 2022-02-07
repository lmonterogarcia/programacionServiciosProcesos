package unico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

/**
 * 
 * @author luis
 * 
 *         En esta clase se ha cambiado el menu para que ademas de crear un
 *         numero aleatorio y enseñarlo por consola lo guarde en un archivo y
 *         haya otra opcion para enseñar por consola las lineas del archivo y
 *         cuente esas lineas.
 *
 */
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
		File numAleatorios = new File("numaleatorios.txt");

		while (salir) {
			try {
				salida.writeUTF("SERVIDOR:\n¿Que quieres hacer?\n\t" + "1. Generar numero aleatorio.\n\t"
						+ "2. Mostrar numeros aleatorios\n\t" + "3. Salir\n\t");
				mensajeRecibido = entrada.readUTF();
				int iLineas = 0;
				switch (mensajeRecibido) {

				// El el caso 1 se ha implementado que guarde en un archivo los numeros
				// aleatorios creados junto con el cliente que los ha creado.
				case "1":
					int aleatorio = generador.nextInt(500);
					BufferedWriter bw = new BufferedWriter(new FileWriter(numAleatorios, true));
					bw.write(socketCliente.toString() + " - " + aleatorio + "\n");
					salida.writeUTF("SERVIDOR: El numero aleatorio es " + aleatorio);
					bw.flush();
					bw.close();
					break;

				// En el caso 2 se va a leer cada linea del archivo y se enviara al cliente.
				// Ademas se cuenta las lineas de ese archivo para saber cuanto clientes han
				// solicitado un numero aleatorio.
				case "2":
					String sMensaje = "";
					BufferedReader br = new BufferedReader(new FileReader(numAleatorios));
					String sLineaLeida = br.readLine();
					if (sLineaLeida == null || sLineaLeida.equals("")) {
						sMensaje = "Ningun CLIENTE ha solicitado un numero aleatorio\n";
					} else {

						while (sLineaLeida != null) {
							sMensaje += sLineaLeida + "\n";
							iLineas++;
							sLineaLeida = br.readLine();

						}
					}
					br.close();
					salida.writeUTF(
							"SERVIDOR:\n" + sMensaje + "\n\n\n" + iLineas + " Clientes han solicitado un numero\n");
					break;
				case "3":
					System.out.println("SERVIDOR: El cliente " + this.socketCliente + " enviar salir");
					System.out.println("SERVIDOR: Cerrando conexion");
					salida.writeUTF("");
					this.socketCliente.close();
					salir = false;
					break;
				default:
					break;
				}

			} catch (IOException e) {
				System.out.println("ERROR: " + e.getMessage());
			}

		}
		try {
			entrada.close();
			salida.close();
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

}
