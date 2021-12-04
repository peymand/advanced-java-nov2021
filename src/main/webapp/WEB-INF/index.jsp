<%
    String pageTitle = "Student Web Application";
    String pageRoute = "/";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
    <jsp:param name="pageRoute" value="<%=pageRoute%>" />
</jsp:include>

<h3>Home</h3>

Welcome to my Site!!

<%@ include file="footer.jsp" %>

