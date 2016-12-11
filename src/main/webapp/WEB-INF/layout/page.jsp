<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
    <link href="/resources/css/bootstrap.css" type="text/css" rel="stylesheet"/>
    <link href="/resources/css/style.css" type="text/css" rel="stylesheet"/>

    <script src="/resources/js/jquery-3.1.1.min.js" type=""></script>
    <script src="/resources/js/bootstrap.min.js" type=""></script>
    <script src="/resources/js/angular.min.js" type="text/javascript"></script>
</head>
<body>
    <table width="100%">
        <tr>
            <td width="80%"><tiles:insertAttribute name="header"/></td>
            <td width="20%"><tiles:insertAttribute name="login"/></td>
        </tr>
        <tr>
            <td colspan="2"><tiles:insertAttribute name="body"/></td>
        </tr>
    </table>

</body>
</html>