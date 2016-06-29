<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/student-profile.css" rel="stylesheet">

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.profile" var="profile"/>
    <fmt:message bundle="${loc}" key="local.edit_profile" var="edit"/>

</head>
<body>

        <div class="profile">
            <div class="courses-header">
                <span>${profile}</span>
            </div>
            <div class="info-content">
                <div class="student-title">
                    <div class="student-login"><div class="user-icon"></div></div>
                    <span>${sessionScope.user.surname} ${sessionScope.user.name}</span>
                    <form  action="Controller" method="post">
                        <input type="hidden" name="command" value="update-user" />
                        <button class="signin-button update-button" href="">${edit}</button>
                    </form>
                </div>
                <div class="row-content">
                    <div class="title-info text-info">Email</div>
                    <div class="value-info text-info">${sessionScope.user.email}</div>
                </div>
                <div class="row-content">
                    <div class="title-info text-info">Телефон</div>
                    <div class="value-info text-info">${sessionScope.user.telephone}</div>
                </div>
                <div class="row-content">
                    <div class="title-info text-info">Skype</div>
                    <div class="value-info text-info">${sessionScope.user.skype}</div>
                </div>
            </div>

        </div>

</body>
</html>
