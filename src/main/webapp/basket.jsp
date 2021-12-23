<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/Main_tab.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <title>Basket</title>

</head>
<body>

<jsp:include page="templates/header.jsp"/>

<div class="div-under-header">
    <div class="basket-text">КОРЗИНА</div>
    <form action="<c:url value="/place_order"/>" method="post">
        <button class="button-oform" type="submit">Оформить</button>
    </form>
</div>



<div class="main">

    <c:forEach var="cure" items="${cures}">
        <div class="drug-form-container">

            <h1 class="form-title">
                ${cure.name}
            </h1>

            <div class="circle"></div>

            <div class="classification">
                ${cure.type}
            </div>

            <div class="form-text">
                ${cure.dose}
            </div>

            <div class="info">

                <div class="form-text">${cure.country}</div>

                <div class="form-text">${cure.deliveryTime}</div>

            </div>

            <div>
                <form action="<c:url value="/delete_cure"/>" method="post">
                    <button type="submit" value="${cure.basketCureId}" name="cure_id_for_delete">Удалить</button>
                </form>
            </div>

        </div>
    </c:forEach>

</div>


</body>
</html>