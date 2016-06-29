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
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.all_course" var="all_courses"/>
    <fmt:message bundle="${loc}" key="local.my_courses" var="my_courses"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>


</head>
<body>


<div class="wrapper">

    <header class="main-header">
        <nav>
            <div class="logo"></div>
            <ul class="menu-navigation">

                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="all-courses-for-student"/>
                    <button class=" signin-button " type="submit">${all_courses}</button>
                </form>

            </ul>
            <div class="sign-in">
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="sign-out"/>
                    <button class="signin-button">${signOut}</button>
                </form>
            </div>
        </nav>
    </header>


    <div class="main-content">
        <jsp:include page="Profile_user.jsp"/>
        <div class="all-courses">

            <div class="courses-header">
                <span>${my_courses}</span>
            </div>
            <jsp:include page="${pageContext.request.contextPath}/Controller">
                <jsp:param name="command" value="student-course"/>
            </jsp:include>
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
