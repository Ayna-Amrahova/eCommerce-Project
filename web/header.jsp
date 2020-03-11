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
        
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script
            src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
        
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
                <img src="./img/basket.png" alt="basket" id="basket" onclick="openPage('http://localhost:8080/MatrixProject/SecondServlet')">
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


