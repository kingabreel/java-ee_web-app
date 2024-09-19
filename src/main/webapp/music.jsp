<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kingabreel
  Date: 17/09/2024
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Musics</title>
  <link rel="stylesheet" href="css/musicStylePage.css">
</head>
<body>
<%@ include file="header.jsp"  %>
<button onclick="toggleAddMusicForm()">Add Music</button>

<h2>Add Music</h2>
<form id="addMusicForm" action="/music" method="post">
  <label for="title">Title:</label>
  <input type="text" id="title" name="title" required><br>

  <label for="band">Band:</label>
  <input type="text" id="band" name="band" required><br>

  <label for="album">Album:</label>
  <input type="text" id="album" name="album" required><br>

  <label for="genre">Genre:</label>
  <input type="text" id="genre" name="genre" required><br>

  <label for="durationSec">Duration (seconds):</label>
  <input type="number" id="durationSec" name="durationSec" min="0" required><br>

  <input type="hidden" name="action" value="add">
  <input type="submit" value="Add Music">
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

<script>
  let addMusic = false;
  function toggleAddMusicForm() {
    var formContainer = document.getElementById('addMusicForm');
    if (formContainer) {
      var currentState = formContainer.style.display === 'none' || formContainer.style.display === '';
      formContainer.style.display = currentState ? 'block' : 'none';
    } else {
      console.log("Element with id 'addMusicForm' not found.");
    }
  }
</script>
</body>
</html>
