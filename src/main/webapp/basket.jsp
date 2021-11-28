<%--
  Created by IntelliJ IDEA.
  User: tsimafeilabanovich
  Date: 24.11.21
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <script src="static/js/main.js"></script>
    <title>Basket</title>
</head>
<body>
<c:if test="${not empty message}">
    <p style="color: red">${message}</p>
</c:if>
<c:if test="${not empty cures}">
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <c:forEach items="${cures}" var="cure" varStatus="i">
            <div class="col">
                <a href="#">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title">${cure.name}</h5>
                            <p class="card-text">${cure.type}</p>
                        </div>
                        <div class="card-footer">
                            <small class="text-muted">${cure.deliveryTime} ${cure.price}</small>
                        </div>
                        <a href="JavaScript:sendIdForDeleteForm(${cure.basketCureId})">${cure.basketCureId}</a>
                    </div>
                </a>
            </div>

        </c:forEach>
    </div>
</c:if>

<form action="<c:url value="/delete_cure"/>" id="deleteCureForm" method="get">
    <input type="hidden" name="cure_id_for_delete">
</form>
</body>
</html>
