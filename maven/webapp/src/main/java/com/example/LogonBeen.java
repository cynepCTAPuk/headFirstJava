package com.example;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author CTAPuk
 */
@WebServlet(urlPatterns = "/logon")
public class LogonBeen extends HttpServlet {
    @Inject
    private LoginBean loginBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().append("Login: " + loginBean.getLogin());
        resp.getWriter().append("\nPassword: " + loginBean.getPassword());
    }

}
