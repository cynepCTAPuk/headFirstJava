package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
//         Открываем сокет для доступа к компьютеру по адресу "java-course.ru" (порт 80)
        Socket socket = new Socket("192.168.1.1", 80);
//         Открываем поток для чтения из сокета (информация будет посылаться нам с удаленного компьютера
        InputStream inputStream = socket.getInputStream();
//         Открываем поток для записи в сокет (информация будет посылаться от нас на удаленный компьютер
        OutputStream outputStream = socket.getOutputStream();
//         Готовим строчку с данными для запроса к серверу Можно пока игнорировать смысл этого запроса
//         String str = "GET /network.txt HTTP/1.1\r\n" + "Host:java-course.ru\r\n\r\n";
        String outMessage = "GET / HTTP 1.0\\r\\n\\r\\n\")";
//         Превращаем их в массив байт для передачи Мы же используем поток, а он работает с байтами
        byte outBuffer[] = outMessage.getBytes();
        outputStream.write(outBuffer); // Пишем в поток вывода
//         И читаем результат в буфер
        int size;
        byte inBuffer[] = new byte[1024];
        while ((size = inputStream.read(inBuffer)) != -1) {
            System.out.print(new String(inBuffer, 0, size));
        }
        System.out.println("Размер принятого буфера в байтах - " + inBuffer.length);
        socket.close();
    }
}