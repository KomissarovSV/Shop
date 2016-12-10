<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Log in</h1>
<form name='f' action="login" method='POST'>
    <table>
        <tr>
            <td>User</td>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td>Remeber me</td>
            <td><input type='checkbox' name='remember-me' /></td>
        </tr>
        <tr>
            <td></td>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <td><input name="submit" type="submit" value="register" /></td>
        </tr>
    </table>
</form>
</body>
</html>


