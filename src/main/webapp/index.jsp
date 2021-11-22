<%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 10.11.21
  Time: 09:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Training Portal</title>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
</head>
<body>
<jsp:include page="templates/header.jsp"/>
<table>
    <tr>
        <td>Today</td>
        <td>Tomorrow</td>
        <td>Soon</td>
        <td>Past</td>
        <td>All</td>
    </tr>
</table>
<c:import url="/qwe"/>

<c:set var="myCourses" value="${requestScope.courses}"/>

<div class="row row-cols-1 row-cols-md-3 g-4">
    <c:forEach var="course" items="${myCourses}">
        <a href="#">
            <div class="col">
                <div class="card h-100">
                    <img src="..." class="card-img-top" alt="...">
                    <div class="card-body">
                        <h5 class="card-title">${course.title}</h5>
                        <p class="card-text">${course.subtitle}</p>
                    </div>
                    <div class="card-footer">
                        <small class="text-muted">${course.date}</small>
                    </div>
                </div>
            </div>
        </a>

    </c:forEach>
</div>
</body>
</html>
