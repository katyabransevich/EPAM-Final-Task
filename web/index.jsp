<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tft" uri="/WEB-INF/tld/dayTime.tld" %>
<html>
<head>
    <title>Course portal</title>
    <meta charset="utf-8">
    <style>

        <%@include file='style/main.css' %>
        <%@include file='style/sign-in.css' %>

    </style>
    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.enter.login" var="login"/>
    <fmt:message bundle="${loc}" key="local.enter.password" var="password"/>
    <fmt:message bundle="${loc}" key="local.signIn" var="signIn"/>
    <fmt:message bundle="${loc}" key="local.welcome" var="welcome"/>
    <fmt:message bundle="${loc}" key="local.large_choose" var="large_choose"/>
    <fmt:message bundle="${loc}" key="local.registration" var="registration"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.ru"
                 var="ru_button"/>
    <fmt:message bundle="${loc}" key="local.locbutton.name.en"
                 var="en_button"/>
    <fmt:message bundle="${loc}" key="local.all_course" var="all_courses"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
    <fmt:message bundle="${loc}" key="local.view" var="view"/>
    <fmt:message bundle="${loc}" key="local.message.login_or_pass_not_correct" var="error_login_or_passwors"/>
    <fmt:message bundle="${loc}" key="local.message.login_bad" var="error_login"/>
    <fmt:message bundle="${loc}" key="local.morning" var="morning"/>
    <fmt:message bundle="${loc}" key="local.evening" var="evening"/>


</head>
<body>


<div class="wrapper">

    <header class="main-header">
        <nav>

            <c:if test="${not empty requestScope.message}">
                *${error_login}</c:if>
            <div class="sign-in">
                <a class="signin-button" href="#registration">${registration}</a>
                <a class="signin-button" href="#overlay">${signIn}</a>

                <div class="location">
                    <form action="ControllerLocal" method="post">
                        <input type="hidden" name="local" value="ru"/>
                        <button> ${ru_button}</button>
                    </form>

                    <div class="separator"></div>
                    <form action="ControllerLocal" method="post">
                        <input type="hidden" name="local" value="en"/>
                        <button> ${en_button}</button>
                    </form>
                </div>
            </div>
        </nav>
    </header>


    <jsp:include page="${pageContext.request.contextPath}/Controller">
        <jsp:param name="command" value="all-courses"/>
    </jsp:include>


    <div class="banner">
        <img src="images/cover_banner.jpg" alt="">
        <div class="title-banner">
            <span class="main-title">${welcome}</span>
            <span class="other-inf">${large_choose}</span>
        </div>
    </div>
    <div class="main-content">
        <div class="all-courses">
            <div class="courses-header">
                <span>${all_courses}</span>
            </div>

            <c:set var="countSubjectStudent" value="${0}" scope="page"/>
            <c:forEach var="subjectForStudent" items="${requestScope.subject}">

                <c:if test="${(countSubjectStudent%4)==0}">
                    <div class="row">
                </c:if>


                <div class="course-index">
                    <div class="logo-course"><img src="${pageContext.request.contextPath}/images/atoms_dva.jpg">
                    </div>
                    <div class="course-name"><a href="">${subjectForStudent.courseName}</a></div>
                    <div class="course-info">
                        <div class="number-listeners">

                            <tft:dayTimeCourse locale="${sessionScope.local}" dayTime="${subjectForStudent.time}"/>
                        </div>
                        <div class="begin">
                            <span>${subjectForStudent.startCourse} - ${subjectForStudent.endCourse}</span></div>
                    </div>

                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="course"/>

                        <input type="hidden" name="course" value="${subjectForStudent.id}"/>

                        <button class="signin-button submit" type="submit">${view}</button>
                    </form>
                </div>
                <c:set var="countSubjectStudent" value="${countSubjectStudent+1}" scope="page"/>
                <c:if test="${(countSubjectStudent%4)==0}"></div></c:if>
            </c:forEach>


        </div>


    </div>

    <div class="stab"></div>
</div>
<footer class="main-footer">
    ${course_portal}

</footer>

<c:set var="notCorrectLoginOrPassword" value="notCorrectLoginOrPassword"/>

<c:choose>
<c:when test="${requestScope.message eq  notCorrectLoginOrPassword}">
<a href="" class="overlay" style="display: block"></a>
<div class="regestration-window" style="display: block">

    </c:when>
    <c:otherwise>
    <a href="" class="overlay" id="overlay"></a>
    <div class="regestration-window">
        </c:otherwise>
        </c:choose>
        <div class="window-header main-header">
            ${course_portal}
        </div>

        <form class="form-regestration" action="Controller" method="post">
            <input type="hidden" name="command" value="login"/>
            <c:if test="${not empty requestScope.message}">
                *${error_login_or_passwors}</c:if>

            <input class="input-field" placeholder="${login}" type="text" name="login" pattern="[\w]+"/>
            <input class="input-field" placeholder="${password}" type="password" name="password" pattern="[\w]+"/>

            <button class="signin-button submit" type="submit">${signIn}</button>
        </form>

        <c:choose>
        <c:when test="${not empty requestScope.message}">
    </div>
    </c:when>
    <c:otherwise>
</div>
</c:otherwise>
</c:choose>


<c:set var="loginBad" value="loginBad"/>

<c:choose>
<c:when test="${requestScope.message eq  loginBad}">
<a href="" class="overlay" style="display: block"></a>
<div class="regestration-window" style="display: block">

    </c:when>
    <c:otherwise>
    <a href="" class="overlay" id="registration"></a>
    <div class="regestration-window">
        </c:otherwise>
        </c:choose>
        <div class="window-header main-header">
            ${course_portal}
        </div>


        <form class="form-regestration" action="Controller" method="post">

            <c:if test="${not empty requestScope.message}">
                *${error_login}</c:if>
            <input type="hidden" name="command" value="registration-student"/>
            <input class="input-field" placeholder="${login}" type="text" name="login" pattern="[\w]+"/>
            <input class="input-field" placeholder="${password}" type="password" name="password" pattern="[\w]+"/>
            <button class="signin-button submit" type="submit">${registration}</button>
        </form>

        <c:choose>
        <c:when test="${requestScope.message eq  loginBad}">
    </div>
    </c:when>
    <c:otherwise>
</div>
</c:otherwise>
</c:choose>


</body>


</html>
