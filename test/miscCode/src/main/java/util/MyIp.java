package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class MyIp {
    private static final String SITE = "http://bot.whatismyipaddress.com";
    private static final String ERROR = "Cannot Execute Properly - ";

    public static void main(String[] args) {
        InetAddress inetAddress;
        String localAddress;
        try {
            inetAddress = InetAddress.getLocalHost();
            localAddress = inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            localAddress = ERROR + e.getClass().getSimpleName();
        }
        System.out.println("System IP Address : " + localAddress);

        String outerIpAddress;
        try (InputStreamReader inputStreamReader = new InputStreamReader(new URL(SITE).openStream());
             BufferedReader br = new BufferedReader(inputStreamReader)) {
            outerIpAddress = br.readLine();
        } catch (IOException e) {
            outerIpAddress = ERROR + e.getClass().getSimpleName();
        }
        System.out.println("Public IP Address : " + outerIpAddress);
    }
}
