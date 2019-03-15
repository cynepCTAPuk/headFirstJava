package network;

import java.io.*;
import java.net.Socket;

// * Класс - клиент для отправки и получения данных
public class Client {

    public static void main(String args[]) throws Exception {
        int portNumber = 10777; // Определяем номер порта, на котором нас ожидает сервер для ответа
        String messageOut = "Тестовая строка для передачи"; // Подготавливаем строку для запроса
        String messageIn; // Подготавливаем строку для ответа
        System.out.println("Client is started"); // Пишем, что стартовали клиент
//         Открыть сокет (Socket) для обращения к локальному компьютеру Сервер мы будем запускать на этом же компьютере
//         Это специальный класс для сетевого взаимодействия c клиентской стороны
        Socket socket = new Socket("127.0.0.1", portNumber);
//         Создать поток для чтения символов из сокета Для этого надо открыть поток сокета - socket.getInputStream()
//         Потом преобразовать его в поток символов - new InputStreamReader
        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//          И уже потом сделать его читателем строк - BufferedReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//         Создать поток для записи символов в сокет
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        printWriter.println(messageOut); // Отправляем тестовую строку в сокет

//         Входим в цикл чтения, что нам ответил сервер
        while ((messageIn = bufferedReader.readLine()) != null) {
            if (messageIn.equals("bye")) break; // Если пришел ответ “bye”, то заканчиваем цикл
            System.out.println(messageIn); // Печатаем ответ от сервера на консоль для проверки
            printWriter.println("bye"); // Посылаем ему "bye" для окончания "разговора"
        } // end loop

        bufferedReader.close();
        printWriter.close();
        socket.close();
    }
}