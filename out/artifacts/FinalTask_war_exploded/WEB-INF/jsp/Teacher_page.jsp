<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Teacher page</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/teacher.css" rel="stylesheet">

</head>
<body>


<div class="wrapper">

    <header class="main-header">
        <nav>
            <div class="logo"></div>
            <ul class="menu-navigation">
                <li><a class="href-nav" href="/">ВСЕ КУРСЫ</a></li>
                <li><a class="href-nav" href="/">НОВОСТИ</a></li>
                <li><a class="href-nav" href="/">ABOUT</a></li>
                <li><a class="href-nav" href="#create-course"></span>СОЗДАТЬ КУРСЫ</a></li>

            </ul>
            <div class="sign-in">
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="sign-out"/>
                    <button class="signin-button" >Sign out</button>
                    </form>
            </div>
        </nav>
    </header>


    <div class="main-content">
        <div class="all-courses">
            <span>Мои курсы</span>
            <c:set var="count" value="${0}" scope="page"/>
            <c:forEach var="subjectForTeacher" items="${requestScope.subject}">

                <c:if test="${(count%4)==0}">
                    <c:out value="${(count%4)}"/>
                    <div class="row">
                </c:if>


                <div class="course">
                    <div class="logo-course"><img src="${pageContext.request.contextPath}/images/atoms_dva.jpg">
                    </div>
                    <div class="course-name"><a href="">${subjectForTeacher.courseName}</a></div>
                    <div class="course-info">
                        <div class="number-listeners"><span>${subjectForTeacher.time}</span></div>
                        <div class="number-listeners">
                            <span>${subjectForTeacher.numberOfCurrentStudent}/${subjectForTeacher.numberOfStudent} </span>
                        </div>
                        <div class="begin">
                            <span>${subjectForTeacher.startCourse} - ${subjectForTeacher.endCourse}</span></div>
                    </div>
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="studentgroup"/>
                        <input type="hidden" name="idCourse" value="${subjectForTeacher.id}"/>
                        <input type="hidden" name="courseName" value="${subjectForTeacher.courseName}"/>


                        <c:choose>
                            <c:when test="${subjectForTeacher.numberOfCurrentStudent==0}">
                                <button class="signin-button submit disabled" type="submit">Посмотреть</button>
                            </c:when>
                            <c:otherwise>

                                <button class="signin-button submit" type="submit">Посмотреть</button>
                            </c:otherwise>
                        </c:choose>
                    </form>

                </div>
                <c:set var="count" value="${count+1}" scope="page"/>
                <c:if test="${(count%4)==0}"></div></c:if>


            </c:forEach>


        </div>
        <div class="stab"></div>
    </div>
    <footer class="main-footer">
        COURSE PORTAL

    </footer>

</div>
<a href="" class="overlay" id="overlay"></a>

<div class="create-course">
    <div class="window-header main-header">
        COURSE PORTAL
    </div>
    <form class="form">
        <input class="input-field" placeholder="Введите название курса" type="text">
        <input class="input-field" placeholder="Введите количество студентов" type="password">
        <div class="date-title"><span>Дата начала курсов</span></div>
        <input type="text" class="date" placeholder="День">
        <input type="text" class="date" placeholder="Месяц">
        <input type="text" class="date" placeholder="Год">
        <div class="divider"></div>
        <input type="text" class="input-field" placeholder="Продолжительность">
        <input type="text" class="input-field" placeholder="Количество слушателей">
        <textarea class="decription" placeholder="Введите описание курса"></textarea>
        <button class="signin-button submit create" type="submit">Создать</button>
    </form>

</div>
</body>
</html>
