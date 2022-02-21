package unico;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import com.google.common.base.Charsets;
import com.google.common.hash.*;

public class PracticaMD5 {

	public PracticaMD5() {
		inicio();
	}

	@SuppressWarnings({ "resource", "deprecation" })
	public void inicio() {

		try {

			Scanner teclado = new Scanner(System.in);
			System.out.println("Introduce la contraseña a cifrar:");
			String pass = teclado.nextLine();

			System.out.println("\nContraseña -> " + pass);

			// Ciframos con MD5
			MessageDigest md5 = MessageDigest.getInstance("MD5");

			md5.update(pass.getBytes());
			byte byteData3[] = md5.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteData3.length; i++) {
				sb.append(Integer.toString((byteData3[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Imprimimos por consola el cifrado de MD5
			System.out.println("MD5        -> " + sb.toString());

			// Ciframos con la libreria Guava de Google utilizando MD5
			HashCode md5Guava = Hashing.md5() // El método esta deprecated, pore Google no aconsesa su uso,
												// unicamente para aplicaciones legacy que no puedan utilizar otro
												// método.
					.hashString(pass, Charsets.UTF_8);
			// Imprimimos por consola el cifrado de MD5 con la libreria Guava
			System.out.println("MD5 Guava  -> " + md5Guava.toString());

		} catch (NoSuchAlgorithmException error) {
			System.out.println("Error: " + error.toString());
		}
	}
}
