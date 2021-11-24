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
</ul>

<h3>Home</h3>
<p>${info}</p>
<p>${rn}</p>

<div class="container-box">

    <form action="/init.do">

        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="name..">

        <label for="role">Role</label>
        <input type="text" id="role" name="role" placeholder="role..">

        <input type="submit" value="submit"/>

    </form>

</div>

</body>
</html>
