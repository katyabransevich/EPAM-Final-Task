<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tft" uri="/WEB-INF/tld/dayTime.tld" %>
<html>
<head>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/student-profile.css" rel="stylesheet">

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.view" var="view"/>
    <fmt:message bundle="${loc}" key="local.delete_course" var="delete"/>
    <fmt:message bundle="${loc}" key="local.apply_course" var="operationWithCourse"/>
    <fmt:message bundle="${loc}" key="local.morning" var="morning"/>
    <fmt:message bundle="${loc}" key="local.evening" var="evening"/>

</head>
<body>
<c:set var="countSubjectStudent" value="${0}" scope="page"/>


<c:forEach var="subjectForStudent" items="${requestScope.subject}">

    <c:if test="${(countSubjectStudent%4)==0}">
        <div class="row">
    </c:if>


    <div class="course">
        <div class="logo-course"><img src="${pageContext.request.contextPath}/images/atoms_dva.jpg">
        </div>
        <div class="course-name"><a href="">${subjectForStudent.courseName}</a></div>
        <div class="course-info">
            <div class="number-listeners">
                <tft:dayTimeCourse  locale="${sessionScope.local}" dayTime="${subjectForStudent.time}"/>
            </div>
            <div class="begin">
                <span>${subjectForStudent.startCourse} - ${subjectForStudent.endCourse}</span>
            </div>
        </div>

        <form action="Controller" method="post">
            <input type="hidden" name="command" value="course"/>

            <input type="hidden" name="course" value="${subjectForStudent.id}"/>

            <button class="signin-button submit" type="submit">${view}</button>
        </form>
        <c:choose>
            <c:when test="${deleteApply>0}">
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="delete-course-student"/>

                    <input type="hidden" name="course" value="${subjectForStudent.id}"/>
                    <button class="signin-button submit" type="submit">${delete}</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="Controller" method="post">
                    <input type="hidden" name="command" value="apply"/>

                    <input type="hidden" name="course" value="${subjectForStudent.id}"/>
                    <button class="signin-button submit" type="submit">${operationWithCourse}</button>
                </form>

            </c:otherwise>
        </c:choose>


    </div>
    <c:set var="countSubjectStudent" value="${countSubjectStudent+1}" scope="page"/>
    <c:if test="${(countSubjectStudent%4)==0}"></div></c:if>
</c:forEach>
</body>
</html>
