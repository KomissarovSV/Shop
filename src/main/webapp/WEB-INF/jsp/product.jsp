<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
    <h4>Name: ${product.name}</h4></a>
    <h4>Cost: ${product.cost}</h4>
    <h4>Company: ${product.company.name}</h4>
    <h4>Type: ${product.type.name}</h4>
    <h4>Description: ${product.description}</h4>
    <c:forEach items="${product.attributeValues}" var="att">
    <h4>${att.attribute.name}: ${att.value}</h4>
    </c:forEach>
    <input type="submit" value="Add to backet" >
</body>
</html>
