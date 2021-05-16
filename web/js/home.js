/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var btnLogout = document.getElementById("btnLogout");
btnLogout.addEventListener("click", function() {
    let location = window.location;
    window.location = location.origin + "/ATBMTT_BTL/Logout";
});