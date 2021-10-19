package unico;

public class Principal {

	public static void main(String[] args) {
		
//		ProcessBuilder pb = new ProcessBuilder("bash", "-c", "open -a TextEdit fch.txt");
//		ProcessBuilder pb = new ProcessBuilder("nano", "/Users/luis/Documents/git-repositorio/programacionServiciosProcesos/06 - Escribir en el bloc de notas/fch.txt");
		
		try {
//			Process process = pb.start();
			Process process = Runtime.getRuntime().exec("/System/Applications/TextEdit.app/Contents/MacOS/TextEdit /Users/luis/Documents/git-repositorio/programacionServiciosProcesos/06-Escribirenelblocdenotas/fch.txt");
			
			} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
