<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>UserPage</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/student-profile.css" rel="stylesheet">


    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>
    <fmt:message bundle="${loc}" key="local.available_courses" var="available_courses"/>
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
</head>
<body>


<div class="wrapper">

    <header class="main-header">
        <nav>

            <form action="Controller" method="post">
                <input type="hidden" name="command" value="back"/>
                <button class=" signin-button " type="submit">${back}</button>
            </form>
            <div class="logo"></div>
            <div class="sign-in">
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="sign-out"/>
                    <button class="signin-button">${signOut}</button>
                </form>
            </div>
        </nav>
    </header>


    <div class="main-content">
        <div class="all-courses">
            <div class="courses-header">
                <span>${available_courses}</span>
            </div>

            <jsp:include page="Courses.jsp"/>


        </div>



        <div class="stab"></div>
    </div>
    <footer class="main-footer">
       ${course_portal}
    </footer>
</div>
</body>
</html>
