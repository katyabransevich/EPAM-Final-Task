<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>Registration</title>



    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="localization.local" var="loc" />
    <fmt:message bundle="${loc}" key="local.login" var="login" />
    <fmt:message bundle="${loc}" key="local.password" var="password" />
    <fmt:message bundle="${loc}" key="local.signIn" var="signIn" />
    <fmt:message bundle="${loc}" key="local.registration" var="registration" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru"
                 var="ru_button" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.en"
                 var="en_button" />
</head>
<body>



<form action="Controller" method="post">

    <input type="hidden" name="command" value="registration" />


    <span>name</span>
    <input class="input" type="text" name="name" value="" />
    <span>surname</span>
    <input class="input" type="text" name="surname" value="" />

    <span>${login}</span>
    <input class="input" type="text" name="login" value="" />
    <span>${password}</span>
    <input class="input" type="password" name="password" value="" />

    <input class="submit" type="submit" value="${registration}" />
</form>

</body>
</html>
