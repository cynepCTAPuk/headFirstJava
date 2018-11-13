package book.chap15;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DailyAdviceServer {
    //    String[] adviceList = {"\"Ешьте меньшими порциями\"", "\"Два слова: не годится\""};
    ArrayList<String> adviceArrayList = new ArrayList<>();
    int port = 4242;

    private String getAdvice() {
//        int random = (int) (Math.random() * adviceList.length);
        int random = (int) (Math.random() * adviceArrayList.size());
//        return adviceList[random];
        return adviceArrayList.get(random);
    } // end method getAdvice()

    private void loadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                adviceArrayList.add(line);
            } // end loop while
            reader.close();
            System.out.println(adviceArrayList);
        } catch (IOException ex) {
            System.out.println("couldn't read the card file");
            ex.printStackTrace();
        } // try-catch
    } // end loadFile method

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                System.out.println("Waiting for a connection on " + port);
                String advice1 = getAdvice();
                String advice2 = getAdvice();
                printWriter.println("Совет дня " + advice1);
                printWriter.println("2-й совет бесплатно " + advice2);
                printWriter.close();
                System.out.println(advice1 + "\n" + advice2);
            } // end loop while
        } catch (IOException e) {
            e.printStackTrace();
        } // end try-catch
    } // end method go()

    public static void main(String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.loadFile(new File("adviceList.txt"));
        server.go();
    } // end main
} // end class DailyAdviceServer