package ctrl;

import java.io.IOException;

import org.json.JSONObject;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class LoginLogic {

	@SuppressWarnings("deprecation")
	public static boolean verificarAdmin(String sUser, String md5Pass) throws IOException {
		boolean booPasar = false;
		String sUrl = "https://thecrewdevelopers.com/bestipes/app/desktop/login/loginmd5.php";
		
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("usuario", sUser);
		jsonObj.put("pass", md5Pass);
		
		String sUserBack = Utils.peticionHttpPostJson(sUrl, jsonObj);
		String sUserHash = Hashing.md5().hashString(sUser, Charsets.UTF_8).toString();
		
		
		if (sUserBack.equals(sUserHash) && !sUserBack.equals("")) {
			booPasar = true;
		}
		
		return booPasar;
	}
	
}
