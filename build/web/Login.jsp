<%-- 
    Document   : index
    Created on : May 16, 2021, 2:15:21 PM
    Author     : Hoàng Thắng <hoangthangrm>
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vn">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>
</head>

<body>
    <div class="container">
        <div class="login">
            <div class="header">
                <div class="title">
                    <span id="titleContent">Đăng nhập</span>
                </div>
                <div class="image-login">
                    <img src="image/login.svg" alt="" srcset="">
                </div>
            </div>
            <div class="form-wrap form-login" id="formLogin">
                <form action="Home">
                    <div class="form-group">
                        <span>Tài khoản</span>
                        <input type="text" id="username">
                    </div>
                    <div class="form-group">
                        <span>Mật khẩu</span>
                        <input type="password" id="password">
                    </div>
                    <div class="form-group">
                        <button class="btn-form" id="btnLogin">Đăng nhập</button>
                    </div>
                </form>
            </div>
            <div class="form-wrap form-register hide" id="formRegister">
                <form action="#">
                    <div class="form-group">
                        <span>Tài khoản</span>
                        <input type="text">
                    </div>
                    <div class="form-group">
                        <span>Mật khẩu</span>
                        <input type="password">
                    </div>
                    <div class="form-group">
                        <span>Nhập lại mật khẩu</span>
                        <input type="password">
                    </div>
                    <div class="form-group">
                        <span>Email</span>
                        <input type="email">
                    </div>
                    <div class="form-group">
                        <button class="btn-form" id="btnRegister">Đăng ký</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="nav nav-register" id="btnNav">
            <span id="btnTitle">Register</span>
        </div>
    </div>
</body>
<script src="js/jquery.min.js"></script>
<script src="js/login.js"></script>
</html>
