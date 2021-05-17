<%-- 
    Document   : Home
    Created on : May 16, 2021, 2:52:05 PM
    Author     : Hoàng Thắng <hoangthangrm>
--%>


<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ENTITY.Product"%>
<%ArrayList list = (ArrayList) request.getAttribute("listProducts");%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/home.css">
        <title>Home</title>
    </head>

    <body>
        <header>
            <div class="container">
                <div class="logo">
                    <a href="/ATBMTT_BTL/Home">
                        <img src="image/login.svg" alt="logo" width="100px">
                    </a>
                </div>
                <div class="search-box">
                    <form method="get" class="form-search" id="formSearch">
                        <input class="search" name="search" type="text" placeholder="Tìm kiếm">
                        <button type="submit" class="btn-search">
                            <img src="image/search.png">
                        </button>
                    </form>
                </div>
                <div class="infor">
                    <div class="avatar">
                        <img src="image/user-male.png" width="50px" class="circle">
                        <div class="user-management">
                            <ul>
                                <li><a href="/ATBMTT_BTL/Manage">Quản lý bán hàng</a></li>
                                <li><a href="/ATBMTT_BTL/Logout">Đăng xuất</a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="infor-user">
                        <a href="#"> ${sessionScope.user.username}</a>
                    </div>
                </div>
            </div>

        </header>
        <div class="container">
            <div class="list-product">
                <%for (int i = 0; i < list.size(); i++) {
                        Product product = (Product) list.get(i);
                        String name = product.getName();
                        if (name.length() > 80) {
                            name = name.substring(0, 80) + "...";
                        }
                        DecimalFormat formatter = new DecimalFormat("###,###,###");
                        String price = formatter.format(product.getPrice()) + " VNĐ";
                %>
                <div class="product" id="product-<%=product.getId()%>">
                    <img src="image/uploads/<%=product.getImage()%>" class="image-product">
                    <span class="title-product"><%=name%></span>
                    <span class="price-product"><%=price%></span>
                </div>
                <%}%>
            </div>
        </div>
        <footer></footer>
    </body>
    <script src="js/home.js"></script>
</html>