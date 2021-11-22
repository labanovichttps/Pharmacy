<%@ page import="com.labanovich.constants.AppConstant" %><%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 8.11.21
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<p>Hi Dear ${user.name} ${user.surname}</p>
<a href="<c:url value="<%=AppConstant.LOGOUT_CONTROLLER%>"/>">LOGOUT</a>
<button type="button" class="btn btn-success">Success</button>

</body>
</html>
