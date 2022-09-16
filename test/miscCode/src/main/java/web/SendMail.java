package web;
/**
 * https://myaccount.google.com/lesssecureapps
 */

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class SendMail {
    public static void main(String[] args) throws MessagingException {

// Создаём соединение с почтовым сервером
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtps");
        props.put("mail.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");
        props.put("mail.smtp.sendpartial", "true");
//        props.put("mail.password", "password");
        Session session = Session.getDefaultInstance(props);

// Создание почтовго сообщения
        MimeMessage message = new MimeMessage(session); //создаем сообщение
        message.setSubject("тестовое письмо!");         //устанавливаем тему письма
        message.setText("Hasta la vista, baby!");       //добавляем текст письма
        //указываем получателя
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("CTAPuk@gmail.com"));
        message.setSentDate(new Date());                //указываем дату отправления

// Отправка сообщения
        //логин и пароль gmail пользователя
        String userLogin = "user@gmail.com";
        String userPassword = "password";

        //авторизуемся на сервере:
        Transport transport = session.getTransport();
        transport.connect("smtp.gmail.com", 465, userLogin, userPassword);

        //отправляем сообщение:
        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
    }
}
