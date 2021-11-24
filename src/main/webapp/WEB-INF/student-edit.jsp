<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entities.Student" %><%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 11/9/2021
  Time: 6:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Form</title>
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

<h3>Edit a Student</h3>

<div class="container-box">
    <form method="post" action="/student-edit.do">

        <label for="sid" hidden>Id</label>
        <input type="text" id="sid" name="id" hidden value="${std.id}">

        <label for="ssn">SSN</label>
        <input type="text" id="ssn" name="ssn" placeholder="ssn.." value="${std.ssn}" minlength="4" maxlength="4" onkeyup="validateRegisterForm()">
        <p id="errMsgSSN" class="error-message"></p> <br/>

        <label for="fname">Name</label>
        <input type="text" id="fname" name="name" placeholder="name.." value="${std.name}" onkeyup="validateRegisterForm()">
        <p id="errMsgName" class="error-message">* Name value must be filled</p> <br/>

        <label for="family">Family</label>

        <label for="family">Family</label>
        <input type="text" id="family" name="family" placeholder="family.." value="${std.family}" onkeyup="validateRegisterForm()">
        <p id="errMsgFamily" class="error-message">* Family value must be filled</p> <br/>

        <label for="major">Major</label>

        <label for="major">Major</label>
        <input type="text" id="major" name="major" placeholder="major.." value="${std.major}" onkeyup="validateRegisterForm()">
        <p id="errMsgMajor" class="error-message">* Major value must be filled</p> <br/>

        <p id="errMsg" class="error-message"></p> <br/>
        <input type="submit" value="Edit" onclick="return validateRegisterForm()">
    </form>
</div>

</body>
</html>
