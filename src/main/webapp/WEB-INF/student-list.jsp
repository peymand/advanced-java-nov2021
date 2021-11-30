<%@ page import="entities.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
    Java Standard Tag Library

  Created by IntelliJ IDEA.
  User: peyma
  Date: 11/14/2021
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    String pageTitle = "List Form";
        String pageRoute = "/student-list-page.do";
%>
<jsp:include page="header.jsp" flush="true">
    <jsp:param name="pageTitle" value="<%=pageTitle%>"/>
        <jsp:param name="pageRoute" value="<%=pageRoute%>" />
</jsp:include>

<h3>List of Students</h3>

<table class="student-table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Family</th>
        <th>Major</th>
        <th>SSN</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="st" varStatus="loopstatus">

        <tr>
            <td>${ loopstatus.index + 1}</td>
            <td>${st.name}</td>
            <td>${st.family}</td>
            <td>${st.major}</td>
            <td>${st.ssn}</td>
            <td>
                <a href="/student-delete.do?id=${st.id}" id="delete-student">
                    <img src="/img/icon-delete-16.jpg" style="width: 40px; height: 40px;"
                         onclick="return confirmToDelete()"/>
                </a>
                <a href="/student-fetch-to-edit-page.do?id=${st.id}">
                    <img src="/img/edit.png" class="square40px"/>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>


</table>
</body>
</html>
