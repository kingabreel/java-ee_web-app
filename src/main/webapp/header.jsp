<%--
  Created by IntelliJ IDEA.
  User: kingabreel
  Date: 18/09/2024
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            text-align: center;
        }

        header a {
            color: white;
            text-decoration: none;
            padding: 14px 20px;
            font-size: 18px;
            border-radius: 5px;
            margin: 0 10px;
            display: inline-block;
            transition: background-color 0.3s;
        }

        header a:hover {
            background-color: #45a049;
        }

        .btn {
            display: inline-block;
            padding: 15px 25px;
            font-size: 18px;
            font-weight: bold;
            color: white;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<header><a href="music">Musics</a> <a href="search">Search music</a> <a href="singer">Singers</a></header>
</html>