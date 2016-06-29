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
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.registration.teacher" var="registration"/>
    <fmt:message bundle="${loc}" key="local.enter.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.enter.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.message.login_bad" var="error_login"/>


</head>
<body>
<div class="wrapper">

    <header class="main-header">
        <nav>
            <div class="logo"></div>
            <div class="sign-in">
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="sign-out"/>
                    <button class="signin-button" >${signOut}</button>
                </form>
            </div>
        </nav>
    </header>



    <div class="regist-teacher">
        <form class="form-regestration" action="Controller" method="post">

            <c:if test="${not empty requestScope.message}">
                *${error_login}</c:if>
            <input type="hidden" name="command" value="registration-teacher"/>
            <input class="input-field" placeholder="${login}" type="text" name="login" pattern="[\w]+"/>
            <input class="input-field" placeholder="${password}" type="password" name="password" pattern="[\w]+"/>
            <button class="signin-button submit" type="submit">${registration}</button>
        </form>

    </div>


    <footer class="main-footer">
        ${course_portal}

    </footer>

</div>

</body>
</html>
