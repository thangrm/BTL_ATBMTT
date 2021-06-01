package CONTROLLER;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@WebServlet(urlPatterns = {"/Logout"})
public class Logout extends HttpServlet {
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        Cookie ck=new Cookie("user","");  
        ck.setMaxAge(0);  
        response.addCookie(ck); 
        response.sendRedirect(request.getContextPath() + "/Login");
    }
}
