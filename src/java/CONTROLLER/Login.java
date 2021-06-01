package CONTROLLER;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import ENTITY.User;
import MODEL.SQLServer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    User user = SQLServer.checkCookie(cookie.getValue());
                    session.setAttribute("user", user);
                }
            }
        }
        if (session.getAttribute("user") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/Home");
        }
    }

}
