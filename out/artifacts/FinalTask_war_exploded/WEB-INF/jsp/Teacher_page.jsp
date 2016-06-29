<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tft" uri="/WEB-INF/tld/dayTime.tld" %>
<html>
<head>
    <title>Teacher page</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/teacher.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/course.css" rel="stylesheet">

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.create_course" var="create_course"/>
    <fmt:message bundle="${loc}" key="local.my_courses" var="my_courses"/>
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.view" var="view"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
    <fmt:message bundle="${loc}" key="local.delete_course" var="delete"/>
    <fmt:message bundle="${loc}" key="local.view_student_group" var="view_group"/>
    <fmt:message bundle="${loc}" key="local.enter.name_course" var="enter_name_course"/>
    <fmt:message bundle="${loc}" key="local.enter.count_of_student" var="enter_count_of_student"/>
    <fmt:message bundle="${loc}" key="local.enter.start_of_course" var="enter_start_of_course"/>
    <fmt:message bundle="${loc}" key="local.enter.end_of_course" var="enter_end_of_course"/>
    <fmt:message bundle="${loc}" key="local.enter.course_description" var="enter_description"/>
    <fmt:message bundle="${loc}" key="local.morning" var="morning"/>
    <fmt:message bundle="${loc}" key="local.evening" var="evening"/>


</head>
<body>


<div class="wrapper">

    <header class="main-header">
        <nav>
            <div class="logo"></div>
            <ul class="menu-navigation">
                <li><a class="href-nav" href="#create-course">${create_course}</a></li>

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
                <jsp:param name="command" value="teacher-course"/>
            </jsp:include>


            <c:set var="count" value="${0}" scope="page"/>
            <c:forEach var="subjectForTeacher" items="${requestScope.subject}">

                <c:if test="${(count%4)==0}">
                    <div class="row">
                </c:if>


                <div class="course-teacher">
                    <div class="logo-course"><img src="${pageContext.request.contextPath}/images/atoms_dva.jpg"></div>
                    <div class="course-name"><a href="">${subjectForTeacher.courseName}</a></div>
                    <div class="course-info">
                        <div class="number-listeners">
                            <tft:dayTimeCourse  locale="${sessionScope.local}" dayTime="${subjectForTeacher.time}"/>
                        </div>
                        <div class="number-listeners">
                            <span>${subjectForTeacher.numberOfCurrentStudent}/${subjectForTeacher.numberOfStudent} </span>
                        </div>
                        <div class="begin">
                            <span>${subjectForTeacher.startCourse} - ${subjectForTeacher.endCourse}</span></div>
                    </div>
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="course"/>

                        <input type="hidden" name="course" value="${subjectForTeacher.id}"/>

                        <button class="signin-button submit" type="submit">${view}</button>
                    </form>

                    <c:choose>


                        <c:when test="${subjectForTeacher.numberOfCurrentStudent==0}">
                            <form action="Controller" method="post">
                                <input type="hidden" name="command" value="delete-course-teacher"/>
                                <input type="hidden" name="idCourse" value="${subjectForTeacher.id}"/>

                                <button class="signin-button submit ">${delete}</button>
                            </form>
                        </c:when>
                        <c:otherwise>
                            <form action="Controller" method="post">
                                <input type="hidden" name="command" value="studentgroup"/>
                                <input type="hidden" name="idCourse" value="${subjectForTeacher.id}"/>
                                <input type="hidden" name="courseName" value="${subjectForTeacher.courseName}"/>

                                <button class="signin-button submit" type="submit">${view_group}</button>
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <c:set var="count" value="${count+1}" scope="page"/>
                <c:if test="${(count%4)==0}"></div></c:if>
            </c:forEach>
        </div>
        <div class="stab"></div>
    </div>
    <footer class="main-footer">
        ${course_portal}

    </footer>

</div>


<a href="" class="overlay" id="create-course"></a>
<div class="create-course">
    <div class="window-header main-header">
        ${course_portal}
    </div>
    <form class="form" action="Controller" method="post">
        <input type="hidden" name="command" value="add-course"/>
        <input class="input-field" placeholder="${enter_name_course}" type="text" name="nameCourse" required />
        <input class="input-field" placeholder="${enter_count_of_student}" type="text" name="numberOfStudent" required pattern="[0-9]+"/>
        <div class="choose-group">
            <input type="radio" id="day-group" name="dayTime" class="group" value="morning" checked>
            <label class="name-group" for="day-group">${morning}</label>
            <input type="radio" id="evening-group" name="dayTime" class="group" value="evening">
            <label class="name-group" for="evening-group">${evening}</label>
        </div>

        <div class="field-date">
            <input class="input-field" placeholder="${enter_start_of_course}" type="text" name="startCourse" required pattern="20[1-2][6-9]\-((1[0-2])|(0[0-9]))\-(([0-2][0-9])|3[0-1])"/>
            <input class="input-field" placeholder="${enter_end_of_course}" type="text" name="endCourse" required pattern="20[1-2][6-9]\-((1[0-2])|(0[0-9]))\-(([0-2][0-9])|3[0-1])"/>
        </div>
        <textarea class=" input-field decription" placeholder="${enter_description}" name="description" required></textarea>

        <div >
            <p>картинка</p>
        <input type="file" name="file" accept="image/jpeg">
        </div>
        <button class="signin-button submit create">${create_course}</button>
    </form>

</div>
</body>
</html>
