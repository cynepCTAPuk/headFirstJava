/**
 * https://javarush.ru/groups/posts/2125-veb-prilozhenie-na-java
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class App extends HttpServlet {
    public String getGreeting() {
        return "Hello world.";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // https://www.oracle.com/technetwork/java/servlet-142430.html
        PrintWriter out = response.getWriter();
        out.println(this.getGreeting());
        out.close();
    }
}