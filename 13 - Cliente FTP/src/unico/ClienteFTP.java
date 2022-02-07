package unico;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTP {

    public static void main(String[] args) {
        //Creamos el objeto cliente FTP
        FTPClient clienteFTP = new FTPClient();

        //Datos para conectarme al servidor
        String sFtp = "10.192.120.41";
        String sUsuario = "medac";
        String sPass = "medac";


        try {
            //Conectando al servidor
            clienteFTP.connect(sFtp);

            //Comprobamos si el usuario es válido
            verificarUsuario(clienteFTP,sUsuario,sPass);

            //Verificamos que estamos conectados con el servidor
            verificarConexion(clienteFTP);

            //Subimos el archivo
            UploadFile(clienteFTP);
            
            //Nos desconectamos del servidor
            clienteFTP.logout();
            clienteFTP.disconnect();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void verificarUsuario(FTPClient clienteFTP, String sUsuario, String sPass) throws IOException {
        if(clienteFTP.login(sUsuario, sPass)) {
            System.out.println("Usuario válido.");
        }else {
            System.err.println("Usuario inválido.");
        }
    }
    
    public static void verificarConexion(FTPClient clienteFTP) {
        int respuesta = clienteFTP.getReplyCode();
        if(FTPReply.isPositiveCompletion(respuesta))
        {
            System.out.println("Conectado Satisfactoriamente");    
        }else{
            System.err.println("Imposible conectarse al servidor");
        }
    }
    
    public static void UploadFile(FTPClient clienteFTP) throws IOException {
        //Ruta de nuestro archivo
         String sFilename = "miarchivo.txt";
         
        //Preparamos el cliente para que envie cualquier tipo de archivo
        clienteFTP.setFileType(FTP.BINARY_FILE_TYPE);
        BufferedInputStream buffIS = new BufferedInputStream(new FileInputStream(sFilename));//Ruta del archivo para enviar
        clienteFTP.enterLocalPassiveMode(); //Modo pasivo
        
        //Verificamos si ha podido realizar la accion de subir el archivo
        if(clienteFTP.storeFile(sFilename, buffIS)) {
            System.out.println("El archivo se ha subido con éxito.");
        }else {
            System.err.println("No se ha podido subir el archivo.");
        }
        
        //Cerramos el buffer
        buffIS.close();
    }

}
