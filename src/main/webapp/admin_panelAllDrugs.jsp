<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset='utf-8'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/admin_panelAllDrugs.css'>
    <link rel="shortcut icon" href="static/images/Shortcut-icon.png">
    <title>PharmacyLL</title>

    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/1.10.2/jquery.min.js"></script>
    <script src="static/js/main.js"></script>
</head>
<body>

<header>
    <div class="header">

        <div class="logo"><a id="a" href="<c:url value="/index.jsp"/>">PharmacyLL</a></div>

        <div class="right-part">
            <div class="dropdown">
                <button class="dropbtn">Admin</button>
                <div class="dropdown-content">
                    <a href="<c:url value="/admin_panelAllDrugs.jsp"/>">Все лекарства</a>
                    <a href="<c:url value="/admin_panel_orders.jsp"/>">Все заказы</a>
                    <a href="<c:url value="/logout"/>">Выйти</a>
                </div>
            </div>
        </div>

    </div>
</header>

<c:import url="/cures"/>
<c:set var="myCures" value="${requestScope.cures}"/>

<div class="searching">

    <div class="search">
        <input type="text" placeholder="Искать здесь...">
    </div>

    <a href="<c:url value="/addDrug.jsp"/>">Добавить лекарство</a>
</div>

<div class="main">
    <c:forEach items="${myCures}" var="cure">
        <div class="drug-form-container">

            <h1 class="form-title">
                ${cure.name}
            </h1>

            <div class="circle"></div>

            <div class="classification">
                ${cure.type}
            </div>

            <div class="form-text">
                Упаковка, ${cure.dose}
            </div>

            <div class="info">

                <div class="form-text">${cure.country}</div>

                <div class="form-text">${cure.deliveryTime}</div>

            </div>

            <div>ЦЕНА: ${cure.price}</div>

            <div>
                <form action="<c:url value="/edit_cure"/>" method="get">
                    <input type="hidden" value="${cure.id}" name="cureId">
                    <button type="submit" class="button-change">Редактировать</button>
                </form>
            </div>
            <form action="<c:url value="/remove_cure"/>" method="post">
                <button value="${cure.id}" name="idForDel" class="button-delete">Удалить</button>
            </form>

        </div>
    </c:forEach>

</div>
</body>
</html>