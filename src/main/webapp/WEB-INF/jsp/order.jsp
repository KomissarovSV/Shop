<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover">
    <tr>
        <th>Name</th>
        <th>Company</th>
        <th>Type</th>
        <th>Count</th>
        <th>Cost</th>
    </tr>
    <c:forEach items="${order.orderPositions}" var="position">
        <tr>
            <td>${position.product.name}</td>
            <td>${position.product.company.name}</td>
            <td>${position.product.type.name}</td>
            <td>${position.count}</td>
            <td>${position.cost}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
