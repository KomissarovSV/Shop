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
        <tr>${statistic.product.name}</tr>
        <tr>${statistic.count}</tr>
        <tr>${statistic.cost}</tr>
    </c:forEach>
</table>
</body>
</html>
