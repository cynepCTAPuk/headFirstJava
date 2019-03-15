package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class PortScanner {
    static String dashString(int i) {
        String dashString = String.join("", Collections.nCopies(i, "-"));
        return dashString;
    }

    public static void main(String[] args) {
        String host = "192.168.1.1"; // localhost
        if (args.length > 0) host = args[0];
        Socket socket = null;
        Date date = new Date();
        Instant begin, current;
        long gap;
        begin = Instant.now();
        ArrayList ports = new ArrayList();

        try {
            InetAddress theAddress = InetAddress.getByName(host);
            System.out.println(theAddress + " Start scanning " +
                    dashString(10) + " " + date);

            for (int i = 1; i < 101; i++) { // for (int i = 1; i < 65536; i++)
                if (i % 10 == 0) {
                    Date dateCurrent = new Date();
                    current = Instant.now();
                    gap = ChronoUnit.SECONDS.between(begin, current);
                    System.out.println(dashString(30) + " " + i + "\t" +
                            dashString(10) + " " + dateCurrent + " " +
                            dashString(10) + " " + gap + " Seconds");
                }
                try {
                    socket = new Socket(host, i);
                    System.out.println("There is a server on port " +
                            i + " of " + host);
                    ports.add(i);
                } catch (IOException e) {
                }
            } // end for
            System.out.println(ports);
        } // end try
        catch (UnknownHostException e) {
            System.err.println(e);
        } finally {
            try {
//                if (socket != null) socket.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } // end main
} // end PortScanner