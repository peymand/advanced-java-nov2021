<%
    String pageTitle = "Student Web Application";
    String pageRoute = "/";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
    <jsp:param name="pageRoute" value="<%=pageRoute%>" />
</jsp:include>

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

<%@ include file="footer.jsp" %>
