<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>PharmacyLL</title>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/Main_tab.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <script src="static/js/main.js"></script>
</head>
<body>

<jsp:include page="templates/header.jsp"/>

<div class="searching">
    <%--Поиск--%>
    <div class="search">
        <input type="text" id="search_cure" placeholder="Искать здесь...">
    </div>

</div>

<c:import url="/cures"/>
<c:set var="myCures" value="${requestScope.cures}"/>

<div class="main">

    <c:forEach items="${myCures}" var="cure" varStatus="i">
        <div class="drug-form-container">
            <h1 class="form-title">
                    ${cure.name}
            </h1>

            <div class="circle"></div>

            <div class="classification">
                    ${cure.type}
            </div>

            <div class="form-text">
                   Количество: ${cure.dose}
            </div>

            <div class="info">

                <div class="form-text">Производитель: ${cure.country}</div>

                <div class="form-text">Срок доставки: ${cure.deliveryTime}</div>

            </div>

            <div>
                <button id="cure_send" onclick="window.location.href='JavaScript:sendIdForm(${cure.id})'" class="price-button">
                        ${cure.price} BYN
                </button>
            </div>
        </div>
    </c:forEach>


</div>

<div style="height: 4%;"></div>

<form action="<c:url value="/basket"/>" id="viewCureForm" method="get">
    <input type="hidden" name="cure_id">
</form>

</body>
</html>