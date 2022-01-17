package unico;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ClienteSMTP {

    private static final String MAIL_SERVER_HOST = "smtp.gmail.com";
    private static final String USER = "bestipescook@gmail.com";
    private static final String PASSWORD = "Informedac2021";
    private static final String MAIL_TO = "mcv0004@alu.medac.es";
    private static final String MAIL_CC = "mcv0004@alu.medac.es";
    private static final String MAIL_BCC = "mcv0004@alu.medac.es";
    private static final String MAIL_FROM = "mcv0004@alu.medac.es";

    public static void main(String[] args) throws Exception {
         Properties prop = new Properties();
         
         prop.setProperty("mail.debug", "true");
         prop.setProperty("mail.host", MAIL_SERVER_HOST);
         prop.setProperty("mail.transport.protocol", "smtp");
         prop.setProperty("mail.smtp.auth", "true");
         prop.put("mail.smtp.port", "465");  
         prop.put("mail.smtp.socketFactory.port", "465");  
         prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
         prop.put("mail.smtp.socketFactory.fallback", "false");

         // 1. Crear sesión
         Session session = Session.getDefaultInstance(prop,  
                    new javax.mail.Authenticator() {
                       protected PasswordAuthentication getPasswordAuthentication() {  
                       return new PasswordAuthentication(MAIL_FROM,PASSWORD);  
                   }  
                   });  
         
         // 2, obtener el objeto de transporte a través de la sesión
         Transport ts = null;
         ts = session.getTransport();
         // 3. Conéctese al servidor de correo
         ts.connect(MAIL_SERVER_HOST, USER, PASSWORD);
        
         // 4. Crear correo electrónico
         MimeMessage message = new MimeMessage(session);
         // Encabezado del mensaje de correo electrónico
         message.setFrom(new InternetAddress(MAIL_FROM)); // El remitente del mensaje
         message.setRecipient(Message.RecipientType.TO, new InternetAddress(MAIL_TO)); // El destinatario del mensaje
         message.setRecipient(Message.RecipientType.CC, new InternetAddress(MAIL_CC)); // CC de correo electrónico
         message.setRecipient(Message.RecipientType.BCC, new InternetAddress(MAIL_BCC)); // CCO del correo electrónico
         message.setSubject("Prueba de correo de texto"); // Asunto del mensaje
         // Cuerpo del mensaje de correo electrónico
         message.setText("Prueba de acceso a servidor SMTP con un cliente en Java.");
         // 5. Enviar correo
         ts.sendMessage(message, message.getAllRecipients());
         ts.close();

    }
}

