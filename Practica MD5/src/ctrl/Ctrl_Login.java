package ctrl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import view.Login;

public class Ctrl_Login {

	public static void conectar() {
		
		String md5Pass = Hashing.md5().hashString(String.valueOf(Login.txtPassword.getPassword()), Charsets.UTF_8).toString();
		
		try {
			if (LoginLogic.verificarAdmin(Login.txtUsuario.getText(), md5Pass)) {
				JOptionPane.showMessageDialog(Login.window,
						"Usuario o contraseña CORRECTOS",
						"Gestión de Login", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(Login.window,
						"Usuario o contraseña incorrectos",
						"Gestión de Login", JOptionPane.PLAIN_MESSAGE);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(Login.window,
					"No se ha podido verificar las credenciales, si sigue ocurriendo contacte con el equipo de desarrollo",
					"Gestión de Login", JOptionPane.PLAIN_MESSAGE);
			e.printStackTrace();
		}
		
	}
}
