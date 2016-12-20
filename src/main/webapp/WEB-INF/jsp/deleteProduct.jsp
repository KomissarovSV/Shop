
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table table-hover">

</table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="/del?id=${product.id}">${product.id} ${product.name}</a></td>
        </tr>
    </c:forEach>
</body>
</html>
