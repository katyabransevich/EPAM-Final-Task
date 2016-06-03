<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Group</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/teacher.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/group.css" rel="stylesheet">


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
            <span>${requestScope.course.courseName}</span>
            <table class="table-group">
                <thead>
                <tr class="header-table">
                    <th>Имя ученика</th>
                    <th>Отметка</th>
                    <th>Комментарии</th>
                    <th class="total-mark"></th>
                    <th class="total-recall"></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>

                <c:forEach var="groupStudents" items="${requestScope.groupStudents}">
                    <tr>
                        <td>${groupStudents.student.surname} ${groupStudents.student.name} </td>
                        <td>
                            <c:if test="${groupStudents.mark>0}">
                                ${groupStudents.mark}
                            </c:if>
                        </td>
                        <td class="feedback">

                                ${groupStudents.comment}
                        </td>
                        <td class="total-mark"></td>
                        <td class="total-recall"></td>
                        <td class="button-group">
                            <div class="button-group">

                                <c:choose>
                                    <c:when test="${groupStudents.comment!=null}">
                                        <a href="#comment" class="add-feedback signin-button"></span>Изменить
                                            комментарий</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#comment" class="add-feedback signin-button"></span>Добавить
                                            комментарий</a>
                                    </c:otherwise>
                                </c:choose>


                                <c:choose>
                                    <c:when test="${groupStudents.mark>0}">
                                        <a href="#total" class="add-feedback signin-button">Изменить отметку</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#total" class="add-feedback signin-button">Добавить отметку</a>
                                    </c:otherwise>
                                </c:choose>

                                <a href="#x" class="overlay" id="comment"></a>
                                <div class="create comment">
                                    <form class="form" action="Controller" method="post">
                                        <input type="hidden" name="command" value="update"/>
                                        <input type="hidden" name="update" value="comment"/>
                                        <input type="hidden" name="idSubject" value="${requestScope.course.id}"/>
                                        <input type="hidden" name="idStudent" value="${groupStudents.student.id}"/>
                                        <input type="hidden" name="courseName"
                                               value="${requestScope.course.courseName}"/>
                                        <span class="title-comment">Введите комментарий</span>
                                        <textarea class="decription comment-decription"
                                                  placeholder="Введите комменатрий" name="comment"></textarea>

                                        <button class="signin-button create-comment-submit" type="submit">Окей</button>
                                    </form>

                                </div>
                                <a href="#x" class="overlay" id="total"></a>
                                <div class="create total">
                                    <form class="form" action="Controller" method="post">
                                        <input type="hidden" name="command" value="update"/>
                                        <input type="hidden" name="update" value="mark"/>
                                        <input type="hidden" name="idSubject" value="${requestScope.course.id}"/>
                                        <input type="hidden" name="idStudent" value="${groupStudents.student.id}"/>
                                        <input type="hidden" name="courseName"
                                               value="${requestScope.course.courseName}"/>
                                        <span class="title-comment">Введите оценку </span>
                                        <input type="text" placeholder="Введите оценку" class="input-field"
                                               name="mark"/>
                                        <button class="signin-button create-comment-submit" type="submit">Окей</button>
                                    </form>

                                </div>

                            </div>
                        </td>
                    </tr>

                </c:forEach>

                </tbody>
            </table>

        </div>
        <div class="stab"></div>
    </div>
    <footer class="main-footer">
        COURSE PORTAL

    </footer>

</div>


</body>
</html>