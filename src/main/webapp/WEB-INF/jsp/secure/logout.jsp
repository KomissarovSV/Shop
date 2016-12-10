<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Выход</title>
</head>
<body>
<h1>
    You have successfully log out.
</h1>

<a href="<c:url value="/" />">Go to the home page</a>
</body>
</html>
