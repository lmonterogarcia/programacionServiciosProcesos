package unico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ClienteHttp {

	private static final String url = "http://www.luismontero.es";

	public ClienteHttp() {

		URL googleUrl;
		try {

			googleUrl = new URL(url);
			URLConnection conection = googleUrl.openConnection();

			BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));

			String linea;
			while ((linea = in.readLine()) != null) {
				System.out.println(linea);
			}
		

		} catch (MalformedURLException e) {
			System.err.println("Error: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		new ClienteHttp();
	}
}
