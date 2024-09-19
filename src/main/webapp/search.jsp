<%--
  Created by IntelliJ IDEA.
  User: kingabreel
  Date: 18/09/2024
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search music</title>
    <link rel="stylesheet" href="css/musicStylePage.css">

</head>
<body>
<%@ include file="header.jsp"  %>
<form id="search" action="/search" method="post">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>

    <input type="hidden" name="action" value="search">
    <input type="submit" value="Search">
</form>
<h2>Music List</h2>

<table >
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Band</th>
        <th>Album</th>
        <th>Genre</th>
        <th>Dutarion (sec)</th>
    </tr>

    <c:forEach var="music" items="${musics}">
        <tr>
            <td><c:out value="${music.id}"/></td>
            <td><c:out value="${music.title}"/></td>
            <td><c:out value="${music.band}"/></td>
            <td><c:out value="${music.album}"/></td>
            <td><c:out value="${music.genre}"/></td>
            <td><c:out value="${music.durationSec}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
