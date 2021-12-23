<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' type='text/css' href='static/css/addDgug.css'>
    <title>Сантехник</title>
</head>
<body>

<header>
    <div class="header">

        <div class="logo"><a id="a" href="#">PharmacyLL</a></div>

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

<div class="main">
    <c:import url="/all_types"/>
    <c:set var="typ" value="${requestScope.types}"/>
    <!-- Обернуть в тег <form> !!! -->
    <div class="container">

        <h1 class="container-title">
            Добавление нового лекарства
        </h1>

        <div class="container-fields">
            <form action="<c:url value="/add_drug"/>" method="post">

                <div class="container-field">
                    <div class="field-text">Название препарата</div>
                    <input type="text" maxlength="50" name="cname" class="input" value="${cure.name}" required>
                </div>

                <div class="container-field" id="flex">

                    <div>
                        <div class="field-text">Тип препарата</div>
                        <select class="input" name="ctype" id="cureType">
                            <c:forEach var="ty" items="${typ}">
                                <option value="${ty.id}">${ty.name}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="container-field" id="margin">
                        <div class="field-text">Количество в упаковке</div>
                        <input class="input" name="count" type="text" maxlength="20">
                    </div>
                </div>

                <div class="container-field">
                    <div class="field-text">Страна производства</div>
                    <input class="input" type="text" name="country" maxlength="50">
                </div>


                <div class="container-field">
                    <div class="field-text">Срок доставки</div>
                    <input class="input" name="cDate" type="text" maxlength="50">
                </div>


                <div class="container-field">
                    <div class="field-text">Цена</div>

                    <input type="text" class="input" name="cost">
                </div>

                <%--                    <div class="container-field">--%>
                <%--                        <div class="field-text">Описание</div>--%>

                <%--                        <input type="text" class="input">--%>
                <%--                    </div>--%>

                <input type="hidden" name="idC">
                <button type="submit" class="button" width="40%">Добавить</button>
            </form>

        </div>

        <button class="button-cancel"><a href="admin_panelAllDrugs.jsp">Отмена</a></button>

    </div>
</div>

</body>
</html>

