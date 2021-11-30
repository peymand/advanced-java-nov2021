<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <link rel="stylesheet" href="/css/main.css"/>
    <script src="/js/main.js" type="application/javascript"></script>
</head>
<body>

<ul class="navigation">
    <li><a class="active" href="/">Home</a></li>
    <li><a href="/student-register-page.do">Register a Student</a></li>
    <li><a href="/student-list-page.do">List of Students</a></li>
    <li><a href="/student-find-page.do">Search a Student</a></li>
    <li><a href="<c:url value="/admin-area.do" /> ">Admin Panel</a></li>
</ul>

<h3>Login</h3>

<form action="/login.do" method="post">
    <input type="text" name="name"/>
    <input type="text" name="role"/>
    <input type="submit" value="submit"/>
</form>

</body>
</html>
