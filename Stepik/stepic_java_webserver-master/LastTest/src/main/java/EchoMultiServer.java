import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoMultiServer {
    private ServerSocket server;

    public void start(int port) throws IOException {
        server = new ServerSocket(port);
        while (true) new EchoClientHandler(server.accept()).start();
    }

    public void stop() throws IOException {
        server.close();
    }

    private static class EchoClientHandler extends Thread {
        private final Socket client;

        public EchoClientHandler(Socket socket) {
            this.client = socket;
        }

        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    if ("bye".equals(inputLine.toLowerCase())) {
//                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }
                in.close();
                out.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}