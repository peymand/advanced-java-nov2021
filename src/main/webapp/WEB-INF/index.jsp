<%
    String pageTitle = "Student Web Application";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>

<h3>Home</h3>
<p>${info}</p>
<p>${rn}</p>
<form action="/init.do">
    <input type="text" name="name"/>
    <input type="text" name="role"/>
    <input type="submit" value="submit"/>
</form>

<%@ include file="footer.jsp" %>
