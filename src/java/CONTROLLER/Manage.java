/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLLER;

import ENTITY.Product;
import ENTITY.User;
import MODEL.SQLServer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Hoàng Thắng <hoangthangrm>
 */
@MultipartConfig(location = "", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(name = "Manage", urlPatterns = {"/Manage"})
public class Manage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        request.setCharacterEncoding("UTF-8");
        String search = (String) request.getParameter("search");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            ArrayList<Product> listProducts = SQLServer.getProducts(user.getId(),search);
            request.setAttribute("listProducts", listProducts);
            dispatcher = request.getRequestDispatcher("Manage.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        request.setCharacterEncoding("UTF-8");
        String search = (String) request.getParameter("search");
        User user = (User) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/Login");
        } else {
            try {
                String name = request.getParameter("nameProduct");
                String price = request.getParameter("priceProduct");
                Part part = request.getPart("imageProduct");
                String realPath = request.getServletContext().getRealPath("/image/uploads");
                
                //Lấy tên file ảnh
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                filename = timestamp.getTime() + filename; 
                
                if (!Files.exists(Paths.get(realPath))) {
                    Files.createDirectories(Paths.get(realPath));
                }

                String fileType = part.getContentType();
                if (fileType.indexOf("image") >= 0) {
                    String pathSave = Paths.get(realPath, filename).toString();

                    //đọc file
                    InputStream targetStream = part.getInputStream();
                    byte[] buffer = new byte[targetStream.available()];
                    targetStream.read(buffer);
                    //lưu lại file ảnh
                    File targetFile = new File(pathSave);
                    OutputStream outStream = new FileOutputStream(targetFile);
                    outStream.write(buffer);
                    
                    String message = "";
                    String error = "";
                    if(SQLServer.addProduct(user.getId(), name, filename, price))
                        message = "Đã thêm hàng thành công !";
                    else
                        error = "Thêm hàng không thành công.";
                    
                    request.setAttribute("message", message);
                    request.setAttribute("error", error);
                    ArrayList<Product> listProducts = SQLServer.getProducts(user.getId(),search);
                    request.setAttribute("listProducts", listProducts);
                    dispatcher = request.getRequestDispatcher("Manage.jsp");
                    dispatcher.forward(request, response);
                }
                
            } catch (Exception e) {
                System.err.println("error add product");
                ArrayList<Product> listProducts = SQLServer.getProducts(user.getId(),search);
                request.setAttribute("listProducts", listProducts);
                dispatcher = request.getRequestDispatcher("Manage.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
