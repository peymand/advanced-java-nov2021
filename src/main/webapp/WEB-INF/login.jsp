<%
    String pageTitle = "Login Form";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>


<h3>Login</h3>

<form action="/login.do" method="post">
    <input type="text" name="name"/>
    <input type="text" name="role"/>
    <input type="submit" value="submit"/>
</form>

<%@ include file="footer.jsp" %>

