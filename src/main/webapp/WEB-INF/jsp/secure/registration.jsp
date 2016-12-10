<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<H1>
    Registration.
</H1>
<form:form modelAttribute="user" method="POST" acceptCharset="UTF-8" enctype="utf-8">
    <br>
    <table>
        <tr>
            <td>Username:</td>
            <td><form:input path="name" value=""/></td>
        </tr>
        <tr>
            <td>Phone:</td>
            <td><form:input path="phone" value=""/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:input path="password" value="" type="password"/></td>
        </tr>
        <tr>
            <td>Repeat password:</td>
            <td><form:input path="matchingPassword" value="" type="password"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input name="submit" type="submit" value="register"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>