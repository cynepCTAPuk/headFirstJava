package web;
/**
 * https://www.tutorialspoint.com/javamail_api/javamail_api_gmail_smtp_server.htm
 * https://myaccount.google.com/lesssecureapps
 */

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailUsingGMailSMTP {
    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "vasily.kosyuk@yandex.ru";//change accordingly

        // Sender's email ID needs to be mentioned
        String from = "CTAPuk@gmail.com";//change accordingly
        final String username = "CTAPuk@gmail.com";//change accordingly
        final String password = "password";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);            // Create a default MimeMessage object.
            message.setFrom(new InternetAddress(from));            // Set From: header field of the header.
            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Testing Subject");            // Set Subject: header field
            // Now set the actual message
            message.setText("Hello, this is sample for to check send email using JavaMailAPI ");

            Transport.send(message);            // Send message

            System.out.println("Sent message successfully....");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}