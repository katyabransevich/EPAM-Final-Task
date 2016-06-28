<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tft" uri="/WEB-INF/tld/dayTime.tld" %>
<html>
<head>
    <title>Course</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/teacher.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/course.css" rel="stylesheet">

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>
    <fmt:message bundle="${loc}" key="local.course_description" var="course_description"/>
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
    <fmt:message bundle="${loc}" key="local.teacher" var="teacher"/>
    <fmt:message bundle="${loc}" key="local.time_spending" var="time_spending"/>
    <fmt:message bundle="${loc}" key="local.number_of_students" var="number_of_students"/>
    <fmt:message bundle="${loc}" key="local.course_duration" var="course_duration"/>
    <fmt:message bundle="${loc}" key="local.morning" var="morning"/>
    <fmt:message bundle="${loc}" key="local.evening" var="evening"/>




</head>
<body>
<div class="wrapper">

<header class="main-header">
    <nav>
        <div class="logo"></div>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="back"/>
            <button class="signin-button " type="submit">${back}</button>
        </form>

        <div class="sign-in">
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="sign-out"/>
                <button class="signin-button" >${signOut}</button>
            </form>
        </div>
    </nav>
</header>
<div class="banner">
    <img src="${pageContext.request.contextPath}/images/cover_banner.jpg">
    <div class="title-banner">
        <span class="main-title">${requestScope.course.courseName}</span>
    </div>
</div>
<div class="main-content">
    <div class="information">
        <span>${course_description}</span>

        <div class="field-inf">
            <span class="left-name">${teacher}</span>
            <span class="right-name">${requestScope.course.teacher.name} ${requestScope.course.teacher.surname}</span>
        </div>
        <div class="field-inf">
            <span class="left-name">${number_of_students}</span>
            <span class="right-name">${requestScope.course.numberOfStudent}</span>
        </div>
        <div class="field-inf">
            <span class="left-name">${course_duration}</span>
            <span class="right-name">${requestScope.course.startCourse}  /  ${requestScope.course.endCourse}</span>
        </div>
        <div class="field-inf">
            <span class="left-name">${time_spending}</span>
            <span  class="right-name"> <tft:dayTimeCourse  locale="${sessionScope.local}" dayTime="${requestScope.course.time}"/></span>

        </div>
        <div class="description">
            ${requestScope.course.description}
        </div>

        <div class="stab"></div>
    </div>
    <br><br>

</div>
<footer class="main-footer">
   ${course_portal}

</footer>

</div>

</body>
</html>
