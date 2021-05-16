var btnNav = document.getElementById("btnNav");
var btnTitle = document.getElementById("btnTitle");
var formLogin = document.getElementById("formLogin");
var formRegister = document.getElementById("formRegister");

btnNav.addEventListener("click", function () {
    formLogin.classList.toggle("hide");
    formRegister.classList.toggle("hide");

    if (btnNav.classList.contains("nav-register")) {
        btnNav.classList.remove("nav-register");
        btnNav.classList.add("nav-login");
        btnTitle.textContent = "Login";
    } else {
        btnNav.classList.remove("nav-login");
        btnNav.classList.add("nav-register");
        btnTitle.textContent = "Register";
    }
});

$("#formLogin").submit(function () {
    let username = $("#username").val();
    let password = $("#password").val();
    //    let account = 'user';
    //    let error = $(".error-login");
    //    error.html("");
    //check xem tài khoản và mật khẩu trống không
    if (username == "") {
        alert("Tên đăng nhập không được để trống");
        //error.html("Tên đăng nhập không được để trống");
        return false;
    }
    if (password == "") {
        //error.html("Mật khẩu không được để trống");
        alert("Mật khẩu không được để trống");
        return false;
    }
    let result = false;
    //gọi Ajax
    $.ajax({
        async: false,
        url: "validateLogin",
        method: "POST",
        data: {username: username, password: password},
        success: function (response) {
            if (response === "True") {
                result = true;
            } else {
                alert("Tên đăng nhập hoặc mật khẩu không chính xác !");
                //error.html("Tên đăng nhập hoặc mật khẩu không chính xác !");
            }
        }
    });
    return result;
});