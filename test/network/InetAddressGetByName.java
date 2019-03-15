package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class InetAddressGetByName {
    public static void main(String[] args) {
        String host = "rbc.ru";
        if (args.length > 0) host = args[0];
        Socket connection = null;
        try {
            InetAddress theAddress = InetAddress.getByName(host);
            System.out.println(theAddress);
/*
            for (int i = 1; i < 1024; i++) { // for (int i = 1; i < 65536; i++)
                System.out.print("port " + i + " ");
                try {
                    connection = new Socket(host, i);
                    System.out.println("There is a server on port " + i + " of " + host);
                } catch (IOException e) {
                }
            } // end for
*/
        } // end try
        catch (UnknownHostException e) {
            System.err.println(e);
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (IOException e) {
            }
        }
    } // end main
}
