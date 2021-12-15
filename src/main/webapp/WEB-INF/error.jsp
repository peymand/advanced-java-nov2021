
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="Error Page"/>
    <jsp:param name="pageRoute" value=""/>
</jsp:include>

    <div class="alert">
        <strong>اخطار!</strong>
<%--        <%=request.getParameter("msg") %>--%>
        ${param.msg}
    </div>
<%--    <%request.getRequestDispatcher("sdsdsdsd").include(request,response);%>--%>

<%@ include file="footer.jsp" %>

