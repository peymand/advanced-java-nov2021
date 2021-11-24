<%
    String pageTitle = "Registration Form";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>

<h3>Register a Student</h3>

<div class="container-box">
    <form method="post" action="/student-register.do">

        <label for="ssn">SSN</label>
        <input type="text" id="ssn" name="ssn" placeholder="ssn..">

        <label for="fname">Name</label>
        <input type="text" id="fname" name="name" placeholder="name..">

        <label for="family">Family</label>
        <input type="text" id="family" name="family" placeholder="family..">

        <label for="major">Major</label>
        <input type="text" id="major" name="major" placeholder="major..">

        <input type="submit" value="Register">
    </form>
</div>

<%@ include file="footer.jsp" %>
