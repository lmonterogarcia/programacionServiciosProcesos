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
 */
public class ServidorHebra extends Thread {

	private Socket socketCliente;
	private DataInputStream entrada;
	private DataOutputStream salida;

	// Array para almacenar las letras en el del dni
	private char[] aLetras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
			'H', 'L', 'C', 'K', 'E' };

	public ServidorHebra(Socket socketCliente, DataInputStream entrada, DataOutputStream salida) {
		this.socketCliente = socketCliente;
		this.entrada = entrada;
		this.salida = salida;
	}

	@Override
	public void run() {
		boolean salir = true;
		int iNumDNI;

		try {
			// Se va apedir el dni para despues calcular la letra y mandar el resultado al
			// Cliente.
			salida.writeUTF("Introduzca el numero del DNI: ");
			iNumDNI = entrada.readInt();
			salida.writeUTF(calcularLetra(iNumDNI));
			this.socketCliente.close();
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
			e.printStackTrace();
		}

		try {
			entrada.close();
			salida.close();
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param iNumDNI
	 * @return sDniCompleto
	 * 
	 *         En este metodo calculamos la letra del dni. Mod del numero de dni
	 *         entre 23.
	 * 
	 */
	private String calcularLetra(int iNumDNI) {
		String sDniCompleto = "\n\n El DNI con letras es " + iNumDNI;

		try {

			sDniCompleto += String.valueOf(aLetras[iNumDNI % 23]);
		} catch (Exception e) {
			System.err.println("ERROR: " + e.getMessage());
			sDniCompleto = "El DNI es incorrecto";

		}

		return sDniCompleto;
	}

}
