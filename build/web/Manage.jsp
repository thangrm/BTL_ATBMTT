<%-- 
    Document   : Manage
    Created on : May 17, 2021, 3:45:11 PM
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
                            <meta name="viewport" content="width=device-width, initial-scale=1.0">
                            <link rel="stylesheet" href="css/manage.css">
                            <link>
                            <title>Manage</title>
                        </head>

                        <body>
                            <header>
                                <div class="container-header">
                                    <div class="logo">
                                        <a href="/ATBMTT/Home">
                                            <img src="image/login.svg" alt="logo" width="100px">
                                        </a>
                                    </div>
                                    <div class="search-box">
                                        <form method="get" class="form-search" id="formSearch">
                                            <input class="search" name="search" type="text" placeholder="Tìm kiếm hàng đang bán">
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
                                                    <li><a href="/ATBMTT/Manage">Quản lý bán hàng</a></li>
                                                    <li><a href="/ATBMTT/Logout">Đăng xuất</a></li>
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
                                <div class="form-wrap">
                                    <form action="/ATBMTT/Manage" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <span>Tên sản phẩm</span>
                                            <input type="text" name="nameProduct">
                                        </div>
                                        <div class="form-group">
                                            <span>Giá sản phẩm</span>
                                            <input type="text" name="priceProduct" pattern="[0-9\.]{1,20}">
                                        </div>
                                        <div class=" form-group ">
                                            <span>Ảnh sản phẩm</span>
                                            <input type="file" name="imageProduct ">
                                        </div>
                                        <div class="form-group form-group-btn">
                                            <button class="btn-form ">
                            Thêm mới
                        </button>
                                            <span class="message ">${message}</span>
                                            <span class="error " id="error ">${error}</span>
                                        </div>
                                    </form>
                                </div>
                                <table class="products ">
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên sản phẩm</th>
                                        <th>Ảnh</th>
                                        <th>Giá</th>
                                    </tr>
                                    <%for (int i = 0; i < list.size(); i++) {
                        Product product = (Product) list.get(i);
                        String name = product.getName();
                        if (name.length() > 80) {
                            name = name.substring(0, 80) + "... ";
                        }
                        DecimalFormat formatter = new DecimalFormat("###,###,### ");
                        String price = formatter.format(product.getPrice()) + " VNĐ ";
                %>
                                        <tr>
                                            <td>
                                                <%=product.getId()%>
                                            </td>
                                            <td>
                                                <%=product.getName()%></td>
                                            <td>
                                                <%=product.getImage()%>
                                            </td>
                                            <td>
                                                <%=product.getPrice()%>
                                            </td>
                                        </tr>
                                        <%}%>
                                </table>
                            </div>
                        </body>
                        <script src="js/jquery.min.js "></script>
                        <script src="js/manage.js "></script>

                        </html>