<%--
  Created by IntelliJ IDEA.
  User: kingabreel
  Date: 19/09/2024
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Singers</title>
    <link rel="stylesheet" href="css/musicStylePage.css">
</head>
<body>
<%@ include file="header.jsp"  %>
<button onclick="toggleAddMusicForm()">Add Singer</button>

<h2>Add Singer</h2>
<form id="addSingerForm" action="/singer" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="age">Age:</label>
    <input type="text" id="age" name="age" required><br>

    <label for="country">Country:</label>
    <input type="text" id="country" name="country" required><br>

    <input type="hidden" name="action" value="add">
    <input type="submit" value="Add Singer">
</form>

<h2>Singers List</h2>

<table >
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Country</th>
    </tr>

    <c:forEach var="singer" items="${singers}">
        <tr>
            <td><c:out value="${singer.id}"/></td>
            <td><c:out value="${singer.name}"/></td>
            <td><c:out value="${singer.age}"/></td>
            <td><c:out value="${singer.country}"/></td>
        </tr>
    </c:forEach>
</table>

<script>
    let addSinger = false;
    function toggleAddMusicForm() {
        var formContainer = document.getElementById('addSingerForm');
        if (formContainer) {
            var currentState = formContainer.style.display === 'none' || formContainer.style.display === '';
            formContainer.style.display = currentState ? 'block' : 'none';
        } else {
            console.log("Element with id 'addSingerForm' not found.");
        }
    }
</script>
</body>
</html>
