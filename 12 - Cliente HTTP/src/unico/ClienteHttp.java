package unico;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClienteHttp {

	private String sUrl;

	public ClienteHttp(String sUrl) {

		try {

			// Crea el objeto URL.
			URL url = new URL("http://www." + sUrl);
			// Crea el objeto URLCOnnection.
			URLConnection conn = url.openConnection();
			// Crea el Objeto _HttpURLCOnnection.
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			// Se especifica que el metodo de conexión sea GET.
			httpConn.setRequestMethod("GET");

			// Se Verifica qsi hay un error 301 de redicreción.
			if (httpConn.getResponseCode() == 301) {
				// Si hay redirección se cambia al protocolo https.
				url = new URL("https://www." + sUrl);
				conn = url.openConnection();
				httpConn.disconnect();
				url = new URL("https://www." + sUrl);
				httpConn = (HttpURLConnection) url.openConnection();

			}

			// Se solicita toda al informacion del Header y se guada en un Map.
			Map<String, List<String>> mapHeader = conn.getHeaderFields();

			// Se va aimprimir cada elemento del mapa por consola.
			for (String key : mapHeader.keySet()) {
				System.out.println(key + ":");

				List<String> values = mapHeader.get(key);

				for (String aValue : values) {
					System.out.println("\t" + aValue);
				}

			}

//			// Otra forma de solicitar la informacion del Header, pero no toda sino la que
//			// nos interesa
//			int responseCode = httpConn.getResponseCode();
//			String responseMessage = httpConn.getResponseMessage();
//			String contentType = httpConn.getContentType();
//			String contentEncoding = httpConn.getContentEncoding();
//			int contentLength = httpConn.getContentLength();
//
//			long date = httpConn.getDate();
//			long expiration = httpConn.getExpiration();
//			long lastModified = httpConn.getLastModified();
//
//			// Impprimir por consola al información solicitada
//			System.out.println("Response Code:\n\t" + responseCode);
//			System.out.println("Response Message:\n\t" + responseMessage);
//			System.out.println("Content Type:\n\t" + contentType);
//			System.out.println("Content Encoding:\n\t" + contentEncoding);
//			System.out.println("Content Length:\n\t" + contentLength);
//			System.out.println("Date:\n\t" + new Date(date));
//			System.out.println("Expiration:\n\t" + new Date(expiration));
//			System.out.println("Last Modified:\n\t" + new Date(lastModified));

			// Solicitar .html completo de la dirección web
			System.out.println("\nArchivo html:\n");
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			// Imprimir por consola el archivo html.
			String linea;
			while ((linea = in.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (MalformedURLException e) {
			System.err.println("Error Malformed: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error IO: " + e.getMessage());
		}

	}

	public String getsUrl() {
		return sUrl;
	}

	public void setsUrl(String sUrl) {
		this.sUrl = sUrl;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		System.out.println("Introduzca el dominio que desea consultar (sin http/s ni www): ");
		String sUrl = new Scanner(System.in).nextLine();

		new ClienteHttp(sUrl);

	}
}
