package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Класс - сервер, принимает запросы от клиентов и отдает данные
 */
public class ThreadServer {
    public static void main(String args[]) {
        int port = 10777; // Определяем номер порта, который будет "слушать" сервер
        try {
            ServerSocket serverSocket = new ServerSocket(port); // Открыть серверный сокет (ServerSocket)

            while (true) {
                System.out.println("Waiting for a connection on " + port);
                Socket fromClientSocket = serverSocket.accept(); // Получив соединение начинаем работать с сокетом
                new SocketThread(fromClientSocket).start(); // Стартуем новый поток для обработки запроса клиента
            } // end loop
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } // end try-catch
    } // main
} // end class ThreadServer

// Этот отдельный класс для обработки запроса клиента, который запускается в отдельном потоке
class SocketThread extends Thread
{
    private Socket fromClientSocket;

    public SocketThread(Socket fromClientSocket) {
        this.fromClientSocket = fromClientSocket;
    } // end method SocketThread

    @Override
    public void run() {
        // Автоматически будут закрыты все ресурсы
        try (Socket localSocket = fromClientSocket;
             PrintWriter pw = new PrintWriter(localSocket.getOutputStream(), true);
             BufferedReader br = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))) {
            // Читаем сообщения от клиента до тех пор пока он не скажет "bye"
            String str;
            while ((str = br.readLine()) != null) {
                // Печатаем сообщение
                System.out.println("The message: " + str);
                if (str.equals("bye")) { // Сравниваем с "bye" и если это так - выходим из цикла и закрываем соединение
                    pw.println("bye"); // Тоже говорим клиенту "bye" и выходим из цикла
                    break;
                } else {
                    str = "Server returns " + str; // Посылаем клиенту ответ
                    pw.println(str);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } // end method run()
} // end class SocketThread