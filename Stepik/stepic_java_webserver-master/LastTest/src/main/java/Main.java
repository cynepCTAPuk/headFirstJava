import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        EchoMultiServer server = new EchoMultiServer();
        System.out.println("Server started");
        server.start(5050);
    }
}
