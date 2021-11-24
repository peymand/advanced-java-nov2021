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
        <input type="text" id="ssn" name="ssn" placeholder="ssn.." minlength="4" maxlength="4" onkeyup="validateRegisterForm()">
        <p id="errMsgSSN" class="error-message"></p> <br/>

        <label for="fname">Name</label>
        <input type="text" id="fname" name="name" placeholder="name.." onkeyup="validateRegisterForm()">
        <p id="errMsgName" class="error-message">* Name value must be filled</p> <br/>

        <label for="family">Family</label>
        <input type="text" id="family" name="family" placeholder="family.." onkeyup="validateRegisterForm()">
        <p id="errMsgFamily" class="error-message">* Family value must be filled</p> <br/>

        <label for="major">Major</label>
        <input type="text" id="major" name="major" placeholder="major.." onkeyup="validateRegisterForm()">
        <p id="errMsgMajor" class="error-message">* Major value must be filled</p> <br/>

        <p id="errMsg" class="error-message"></p> <br/>
        <input type="submit" value="Register" hidden id="register-student">
        <input type="submit" value="Register" id="validation-register-student" onclick="return validateRegisterForm()">

    </form>
</div>

<%@ include file="footer.jsp" %>
