package network;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientGet {
    public static void main(String[] args) {
        OutputStreamWriter out = null;
        try {
            Socket s = new Socket("192.168.1.1", 80); // www.oreilly.com
            OutputStream raw = s.getOutputStream();
            OutputStream buffered = new BufferedOutputStream(raw);
            out = new OutputStreamWriter(buffered, "ASCII");
            out.write("GET / HTTP 1.0\r\n\r\n");
//            read the server response...
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
    }
}
