<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Student Group</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/teacher.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/group.css" rel="stylesheet">


    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
    <fmt:message bundle="${loc}" key="local.student_name" var="student_name"/>

    <fmt:message bundle="${loc}" key="local.mark" var="mark"/>
    <fmt:message bundle="${loc}" key="local.comments" var="comments"/>
    <fmt:message bundle="${loc}" key="local.add_comments" var="add_comments"/>
    <fmt:message bundle="${loc}" key="local.add_mark" var="add_mark"/>
    <fmt:message bundle="${loc}" key="local.change_comments" var="change_comments"/>
    <fmt:message bundle="${loc}" key="local.change_mark" var="change_mark"/>
    <fmt:message bundle="${loc}" key="local.enter_comment" var="enter_comments"/>
    <fmt:message bundle="${loc}" key="local.enter_mark" var="enter_mark"/>


</head>
<body>

<div class="wrapper">

    <header class="main-header">
        <nav>
            <form action="Controller" method="post">
                <input type="hidden" name="command" value="back"/>
                <button class=" signin-button " type="submit">${back}</button>
            </form>
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
            <span>${requestScope.course.courseName}</span>
            <table class="table-group">

                <tr class="header-table">
                    <th>${student_name}</th>
                    <th>${mark}</th>
                    <th>${comments}</th>
                    <th>изменить/добавить отметку</th>
                    <th>изменить/добавить комментарий</th>
                </tr>


                <c:forEach var="currentStudent" items="${requestScope.groupStudents}">
                    <tr>
                        <td>${currentStudent.student.surname} ${currentStudent.student.name} </td>
                        <td>
                            <c:if test="${currentStudent.mark>0}">
                                ${currentStudent.mark}
                            </c:if>
                        </td>
                        <td class="feedback">

                                ${currentStudent.comment}
                        </td>
                        <td>
                            <form class="button-group" action="Controller" method="post">
                                <input type="hidden" name="command" value="update"/>
                                <input type="hidden" name="update" value="mark"/>
                                <input type="hidden" name="idSubject" value="${requestScope.course.id}"/>
                                <input type="hidden" name="idStudent" value="${currentStudent.student.id}"/>
                                <input type="hidden" name="courseName"
                                       value="${requestScope.course.courseName}"/>
                                <input type="text" placeholder="${enter_mark}" class="input-field-mark"
                                       name="mark" pattern="([0-9])|(10)" required/>
                                <button class="signin-button ">ОK</button>
                            </form>

                        </td>
                        <td>
                            <form class="button-group" action="Controller" method="post">
                                <input type="hidden" name="command" value="update"/>
                                <input type="hidden" name="update" value="comment"/>
                                <input type="hidden" name="idSubject" value="${requestScope.course.id}"/>
                                <input type="hidden" name="idStudent" value="${currentStudent.student.id}"/>
                                <input type="hidden" name="courseName"
                                       value="${requestScope.course.courseName}"/>
                                        <textarea class="decription comment-description"
                                                  placeholder="${enter_comments}" name="comment" required></textarea>
                                <button class="signin-button button-ok ">ОK</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="stab"></div>
    </div>
    <footer class="main-footer">
        ${course_portal}

    </footer>

</div>


</body>
</html>