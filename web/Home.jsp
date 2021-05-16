<%-- 
    Document   : Home
    Created on : May 16, 2021, 2:52:05 PM
    Author     : Hoàng Thắng <hoangthangrm>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/home.css">
        <title>Home</title>
    </head>

    <body>
        ${sessionScope.user.id}</br>
        ${sessionScope.user.username}</br>
        ${sessionScope.user.email}</br>
        <button id="btnLogout">
            <span>Đăng xuất</span>
        </button>
    </body>
    <script src="js/home.js"></script>

</html>