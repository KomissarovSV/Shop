<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover">
    <tr>
        <th>Product</th>
        <th>Count</th>
        <th>Cost</th>
    </tr>
    <c:forEach items="${statistics}" var="statistic">
        <tr>
            <td>${statistic.product.name}</td>
            <td>${statistic.count}</td>
            <td>${statistic.cost}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
