<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="float: right">

    <table style="border-spacing: 10px; border-collapse: separate;">
        <tr>
            <td>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td><a href="<c:url value="/manage"/>">Manage</a></td>
                </sec:authorize>
            </td>
            <td><a href="/basket">Basket</a></td>
            <sec:authorize access="isAnonymous()">
                <td><a href="<c:url value="/user/login"/>">Log in</a></td>
                <td>|<a href="<c:url value="/user/registration"/>">Registration</a></td>
            </sec:authorize>
            <sec:authorize access="!isAnonymous()">
                You entered as user:
                <sec:authentication property="principal.username"/>
                <td><c:url var="logoutUrl" value="/logout"/>
                    <form action="${logoutUrl}" method="post">
                        <input type="submit" value="Exit"/>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </td>
            </sec:authorize>
        </tr>
    </table>
</div>