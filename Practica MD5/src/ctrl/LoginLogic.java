package ctrl;

import java.io.IOException;

import org.json.JSONObject;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class LoginLogic {

	@SuppressWarnings("deprecation")
	public static boolean verificarAdmin(String sUser, String sha256hexPass) throws IOException {
		boolean booPasar = false;
		String sUrl = "https://thecrewdevelopers.com/bestipes/app/desktop/login/loginmd5.php";
		
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("usuario", sUser);
		jsonObj.put("pass", sha256hexPass);
		
		String sUserBack = Utils.peticionHttpPostJson(sUrl, jsonObj);
		String sUserHash = Hashing.md5().hashString(sUser, Charsets.UTF_8).toString();
		
		
		if (sUserBack.equals(sUserHash) && !sUserBack.equals("")) {
			booPasar = true;
		}
		
		return booPasar;
	}
	
}
