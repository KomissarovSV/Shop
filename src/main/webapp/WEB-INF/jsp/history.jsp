<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover">
    ${order}
    <%--<c:forEach items="${orders}" var="order">--%>
        <%--<tr>${order.cost}</tr>--%>
    <%--</c:forEach>--%>
</table>

</body>
</html>
