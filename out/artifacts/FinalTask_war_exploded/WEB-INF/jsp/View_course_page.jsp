<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Course</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/teacher.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/course.css" rel="stylesheet">


</head>
<body>
<div class="wrapper">

<header class="main-header">
    <nav>
        <div class="logo"></div>
        <ul class="menu-navigation">
            <li><a class="href-nav" href="/">ВСЕ КУРСЫ</a></li>
            <li><a class="href-nav" href="/">НОВОСТИ</a></li>
            <li><a class="href-nav"href="/">ABOUT</a></li>

        </ul>
        <form action="Controller" method="post">
            <input type="hidden" name="command" value="backviewcoursestudent"/>
            <button class="signin-button " type="submit">Назад</button>
        </form>
        <div class="sign-in">
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="sign-out"/>
                <button class="signin-button" >Sign out</button>
            </form>
        </div>
    </nav>
</header>
<div class="banner">
    <img src="${pageContext.request.contextPath}/images/cover_banner.jpg">
    <div class="title-banner">
        <span class="main-title">Название курсов</span>
    </div>
</div>
<div class="main-content">
    <div class="information">
        <span>Описание курсов</span>
        <div class="field-inf">
            <span class="left-name">Преподаватель</span>
            <span class="right-name">${requestScope.course.teacher.name} ${requestScope.course.teacher.surname}</span>
        </div>
        <div class="field-inf">
            <span class="left-name">Количество слушателей</span>
            <span class="right-name">${requestScope.course.numberOfStudent}</span>
        </div>
        <div class="field-inf">
            <span class="left-name">Продолжительность</span>
            <span class="right-name">${requestScope.course.startCourse}  /  ${requestScope.course.endCourse}</span>
        </div>
        <div class="field-inf">
            <span class="left-name">Время проведения</span>
            <span class="right-name"> ${requestScope.course.time}</span>
        </div>
        <div class="decription">
            ${requestScope.course.description}
        </div>

        <div class="stab"></div>
    </div>
    <br><br>

</div>
<footer class="main-footer">
    COURSE PORTAL

</footer>

</div>

</body>
</html>
