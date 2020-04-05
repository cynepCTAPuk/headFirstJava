package xml;
/**
 * https://www.tutorialspoint.com/javamail_api/javamail_api_gmail_smtp_server.htm
 * https://stackoverflow.com/questions/16117365/sending-mail-attachment-using-java
 * https://myaccount.google.com/lesssecureapps
 */

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class SendEmailUsingGMailSMTP {
    public static void main(String[] args) {
        String to = "to@gmail.com";             // Recipient's email ID needs to be mentioned.
        String from = "from@gmail.com";         // Sender's email ID needs to be mentioned
        String file = "c:/000/berns.txt";   // Attachment

        final String user = "user@gmail.com";
        final String password = "password";

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
        try {
            Message message = new MimeMessage(session); // Create a default MimeMessage object.
            message.setFrom(new InternetAddress(from)); // Set From: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Testing Subject");      // Set Subject: header field
            message.setText("Testing JavaMailAPI");     // Now set the actual message

            Multipart multipart = new MimeMultipart();
            MimeBodyPart attachmentBodyPart = new MimeBodyPart();

            DataSource source = new FileDataSource(file);
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName("Name of Attachment");
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);

            Transport.send(message);            // Send message
//            System.out.println("Sent message successfully....");
            System.out.println("Письмо было отправлено.");
        } catch (MessagingException e) {
            System.out.println("Ошибка при отправке: " + e.toString());
        }
    }
}