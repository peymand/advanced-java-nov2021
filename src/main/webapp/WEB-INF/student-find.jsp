<%
    String pageTitle = "Search for Students";
    String pageRoute = "/student-find-page.do";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>"/>
    <jsp:param name="pageRoute" value="<%=pageRoute%>" />
</jsp:include>

<h3>Search for Students</h3>
<p>Welcome ${name}!</p>
<div class="container-box">

    <form action="/student-find-by-ssn.do" method="post">
        SSN : <input type="text" name="ssn" id="ssn" onkeyup="validateForm()" minlength="4" maxlength="4" /> <p id="errMsg" class="error-message"></p> <br/>
        <input type="submit" value="search" onclick="return validateForm()"/>
    </form>


</div>

<table class="student-table" id="st-table" style="display: none">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Family</th>
        <th>Major</th>
        <th>SSN</th>
    </tr>
    <tr>
        <td id="id"></td>
        <td id="name"></td>
        <td id="family"></td>
        <td id="major"></td>
        <td id="ssnn"></td>
    </tr>

</table>

<div class="alert" id="error-msg"></div>

<%@ include file="footer.jsp" %>

