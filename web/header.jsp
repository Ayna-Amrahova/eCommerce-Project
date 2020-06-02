<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DB"%>
<%@page import="model.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <div class="header" id="header">

            <p id="head">15% OFF ALL TENTS</p>

            <div class="nav" id="nav">

                <img src="./img/logo.png" alt="logo" id="logo" onclick="openPage('http://localhost:8080/MatrixProject/HomeServlet')">
                <p id="nav1" onclick="openPage('http://localhost:8080/MatrixProject/HomeServlet')"> HOME</p>
                <p id="nav2" onclick="openPage('http://localhost:8080/MatrixProject/ShopServlet')"> SHOP</p>
                <p id="nav3" onclick="openPage('http://localhost:8080/MatrixProject/BlogServlet')"> BLOG</p>
                <p id="nav4" onclick="openPage('http://localhost:8080/MatrixProject/AboutServlet')"> ABOUT </p>
                <p id="nav5" onclick="openPage('http://localhost:8080/MatrixProject/ContactServlet')"> CONTACT</p>
                <img src="./img/basket.png" alt="basket" id="basket" onclick="openPage('http://localhost:8080/MatrixProject/SelectedProductsServlet')">

                <button onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;" id="login">Login</button>

                <div id="id01" class="modal">

                    <form class="modal-content animate" action="/HomeServlet" method="post">
                        <div class="imgcontainer">
                            <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                            <img src="./img/user.jpg" alt="Avatar" class="avatar">
                        </div>

                        <div class="container">
                            <label for="uname"><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="username" required>

                            <label for="psw"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="password" required>

                            <button type="submit" id="login">Login</button>
                            <label>
                                <input type="checkbox" checked="checked" name="remember"> Remember me
                            </label>
                        </div>

                        <div class="container" style="background-color:#f1f1f1">
                            <button type="button" onclick="document.getElementById('id01').style.display = 'none'" 
                                    class="cancelbtn" >Cancel</button>
                            <button type="button" onclick="openPage('http://localhost:8080/MatrixProject/RegisterServlet')"
                                    class="cancelbtn">Register</button>
                            <span class="psw"><a href="#">Forgot password?</a></span>
                        </div>
                    </form>
                </div>

                <script>
                    // Get the modal
                    var modal = document.getElementById('id01');

                    // When the user clicks anywhere outside of the modal, close it
                    window.onclick = function (event) {
                        if (event.target == modal) {
                            modal.style.display = "none";
                        }
                    }
                </script>

                <script type="text/javascript">
                    function openPage(pageURL)
                    {
                        window.location.href = pageURL;
                    }

                    window.onscroll = function () {
                        myFunction();
                    };

                    var header = document.getElementById("header");
                    var sticky = header.offsetTop;

                    function myFunction() {
                        if (window.pageYOffset > sticky) {
                            header.classList.add("sticky");
                        } else {
                            header.classList.remove("sticky");
                        }
                    }
                </script>


            </div>
        </div>
        <br>
        <br>
        <br>


