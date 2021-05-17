/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import ENTITY.Product;
import MODEL.SQLServer;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        request.setCharacterEncoding("UTF-8");
        String search = (String)request.getParameter("search");
        System.out.println("search:" + search);
        if(session.getAttribute("user") == null){
            response.sendRedirect(request.getContextPath() + "/Login");
        }else{
            ArrayList<Product> listProducts = SQLServer.getProducts(search);
            request.setAttribute("listProducts", listProducts);
            dispatcher = request.getRequestDispatcher("Home.jsp");
            dispatcher.forward(request, response);
        }
    }

}
