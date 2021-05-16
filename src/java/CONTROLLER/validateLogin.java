package CONTROLLER;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import MODEL.SQLServer;
import ENTITY.User;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
@WebServlet(urlPatterns = {"/validateLogin"})
public class validateLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        User user = SQLServer.validateLogin(username, password);
        if(user == null)
            out.print("False");
        else{
            out.print("True");
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
    }
}
