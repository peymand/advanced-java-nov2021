<%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 11/16/2021
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/main.css"/>
    <script src="/js/main.js" type="application/javascript"></script>
</head>
<body>



<ul class="navigation">
    <li><a class="active" href="/">Home</a></li>
    <li><a href="/student-register-page.do">Register a Student</a></li>
    <li><a href="/student-list-page.do">List of Students</a></li>
    <li><a href="/student-find-page.do">Search a Student</a></li>
</ul>

<h3>Search for Students</h3>

<div class="container-box">

    <form action="/student-find-by-ssn.do" method="post">
        SSN : <input type="text" name="ssn" id="ssn" onkeyup="validateForm()" minlength="4" maxlength="4" /> <p id="errMsg" class="error-message"></p> <br/>
        <input type="submit" value="search" onclick="return validateForm()"/>
    </form>


</div>

<table class="student-table" id="st-table" style="display: none">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Family</th>
        <th>Major</th>
        <th>SSN</th>
    </tr>
    <tr>
        <td id="id"></td>
        <td id="name"></td>
        <td id="family"></td>
        <td id="major"></td>
        <td id="ssnn"></td>
    </tr>

</table>

<div class="alert" id="error-msg">
</div>

</body>
</html>
