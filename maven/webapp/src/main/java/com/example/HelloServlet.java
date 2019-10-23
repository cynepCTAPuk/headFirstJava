package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author CTAPuk
 */
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().append(" Hello World! " + req.getMethod() + "\n");
        HttpSession session = req.getSession();

        if (session.getValue("name") == null) {
            session.putValue("name", " hello world session");
            resp.getWriter().append("\n No session");
        } else {
            resp.getWriter().append((String) session.getValue("name"));
        }
    }

}
