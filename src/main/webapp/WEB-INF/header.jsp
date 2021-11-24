<%@ page session="false" %>
<html>
<head>
    <title><%=request.getParameter("pageTitle")%></title>
    <link rel="stylesheet" href="/css/main.css"/>
    <link rel="stylesheet" href="/css/sweetalert2.css"/>
</head>

<body>

<ul class="navigation">
    <li><a class="active" href="/">Home</a></li>
    <li><a href="/student-register-page.do">Register a Student</a></li>
    <li><a href="/student-list-page.do">List of Students</a></li>
    <li><a href="/student-find-page.do">Search a Student</a></li>
</ul>
