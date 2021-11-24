<%
    String pageTitle = "Error Page";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>"/>
</jsp:include>

<div class="alert">
    <strong>اخطار!</strong> <%=request.getParameter("msg") %> ${param.msg}
</div>


<%@ include file="footer.jsp" %>
