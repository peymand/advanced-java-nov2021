<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<% String url = request.getParameter("pageRoute"); %>
<html>
<head>
    <title>${param.pageTitle}</title>
    <link rel="stylesheet" href="/css/main.css"/>
    <link rel="stylesheet" href="/css/sweetalert2.css"/>
</head>

<body>

<ul class="navigation">
    <li><a class="item <%if(url.equals("/")){%> active <% } %>" href="${ctx}/">Home</a></li>
    <li><a class="item <%if(url.equals("/student-register-page.do")){%> active <% } %>"
           href="${ctx}/student-register-page.do">Register a Student</a></li>
    <li><a class="item <%if(url.equals("/student-list-page.do")){%> active <% } %>"
           href="${ctx}/student-list-page.do">List of Students</a></li>
    <li><a class="item <%if(url.equals("/student-find-page.do")){%> active <% } %>"
           href="${ctx}/student-find-page.do">Search a Student</a></li>
    <li><a href="<c:url value="/admin-area.do" /> ">Admin Panel</a></li>

</ul>
