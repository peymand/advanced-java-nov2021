<%--
  Created by IntelliJ IDEA.
  User: peyma
  Date: 2/22/2021
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="j_security_check" method="POST">
        Username:   <input type="text" name="j_username" placeholder="Username" />
        Password:   <input type="password" name="j_password" placeholder="Password" />
                    <input type="submit" value="Log In" />
    </form>
</body>
</html>
