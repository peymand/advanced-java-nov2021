<% String pageTitle = "Edit Form"; %>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>" />
</jsp:include>

<h3>Edit a Student</h3>

<div class="container-box">
    <form method="post" action="/student-edit.do">

        <label for="sid" hidden>Id</label>
        <input type="text" id="sid" name="id" hidden value="${std.id}">

        <label for="ssn">SSN</label>
        <input type="text" id="ssn" name="ssn" placeholder="ssn.." value="${std.ssn}">

        <label for="fname">Name</label>
        <input type="text" id="fname" name="name" placeholder="name.." value="${std.name}">

        <label for="family">Family</label>
        <input type="text" id="family" name="family" placeholder="family.." value="${std.family}">

        <label for="major">Major</label>
        <input type="text" id="major" name="major" placeholder="major.." value="${std.major}">

        <input type="submit" value="Edit">
    </form>
</div>

<%@ include file="footer.jsp" %>

