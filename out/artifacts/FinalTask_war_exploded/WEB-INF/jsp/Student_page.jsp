<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserPage</title>

    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/student-profile.css" rel="stylesheet">
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

            <c:choose>
            <c:when test="${requestScope.updateStudent==false}">
                <div class="profile">
                    <span>Профиль студента</span>
                    <div class="info-content">
                        <div class="student-title">
                            <div class="student-login"><div class="user-icon"></div></div>
                            <span>${requestScope.user.surname} ${requestScope.user.name}</span>
                            <form  action="Controller" method="post">
                                <input type="hidden" name="command" value="update-user" />
                                <button class="signin-button update-button" href="">Редактировать</button>
                                </form>
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info">Email</div>
                            <div class="value-info text-info">${requestScope.user.email}</div>
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info">Телефон</div>
                            <div class="value-info text-info">${requestScope.user.telephone}</div>
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info">Skype</div>
                            <div class="value-info text-info">${requestScope.user.skype}</div>
                        </div>
                    </div>

                </div>
            </c:when>
            <c:otherwise>


                    <div class="info-content-save">


                            <form  action="Controller" method="post">
                                <input type="hidden" name="command" value="save-user" />
                                <button class="signin-button update-button" href="">Сохранить</button>
                            </form>


                        <div class="row-content">
                            <div class="title-info text-info"><label for="name">Имя</label></div>
                            <input type="text" class="value-info text-info field-input" placeholder="Введите имя" id="name" name="name">
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info"><label for="surname">Фамилия</label></div>
                            <input type="text" class="value-info text-info field-input" placeholder="Введите фамилию" id="surname"  name="surname">
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info"><label for="email">Email</label></div>
                            <input type="text" class="value-info text-info field-input" placeholder="Введите email" id="email" name="email">
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info"><label for="phone">Телефон</label></div>
                            <input type="text" class="value-info text-info field-input" placeholder="Введите телефон" id="phone" name="phone">
                        </div>
                        <div class="row-content">
                            <div class="title-info text-info"><label for="skype">Skype</label></div>
                            <input type="text" class="value-info text-info field-input" placeholder="Введите skype" id="skype" name="skype">
                        </div>
                    </div>

            </c:otherwise>
            </c:choose>






            <span>Мои курсы</span>

            <c:set var="countSubjectStudent" value="${0}" scope="page"/>
            <c:forEach var="subjectForStudent" items="${requestScope.subjectStudent}">

                <c:if test="${(countSubjectStudent%4)==0}">
                    <div class="row">
                </c:if>


                <div class="course">
                    <div class="logo-course"><img src="${pageContext.request.contextPath}/images/atoms_dva.jpg">
                    </div>
                    <div class="course-name"><a href="">${subjectForStudent.courseName}</a></div>
                    <div class="course-info">
                        <div class="number-listeners"><span>${subjectForStudent.time}</span></div>
                        <div class="begin">
                            <span>${subjectForStudent.startCourse} - ${subjectForStudent.endCourse}</span></div>
                    </div>

                    <form  action="Controller" method="post">
                        <input type="hidden" name="command" value="course" />

                        <input type="hidden" name="course" value="${subjectForStudent.id}"/>

                    <button class="signin-button submit" type="submit">Посмотреть</button>
                    </form>


                </div>
                <c:set var="countSubjectStudent" value="${countSubjectStudent+1}" scope="page"/>
                <c:if test="${(countSubjectStudent%4)==0}"></div></c:if>
            </c:forEach>

        </div>

<br>
        <div class="all-courses">
            <span>Другие курсы</span>
            <c:set var="countOtherSubjectStudent" value="${0}" scope="page"/>
            <c:forEach var="subjectForStudent" items="${requestScope.subject}">

                <c:if test="${(countOtherSubjectStudent%4)==0}">
                    <div class="row">
                </c:if>


                <div class="course">
                    <div class="logo-course"><img src="${pageContext.request.contextPath}/images/atoms_dva.jpg">
                    </div>
                    <div class="course-name"><a href="">${subjectForStudent.courseName}</a></div>
                    <div class="course-info">
                        <div class="number-listeners"><span>${subjectForStudent.time}</span></div>
                        <div class="begin">
                            <span>${subjectForStudent.startCourse} - ${subjectForStudent.endCourse}</span></div>
                    </div>


                    <form  action="Controller" method="post">
                        <input type="hidden" name="command" value="course" />

                        <input type="hidden" name="course" value="${subjectForStudent.id}"/>

                        <button class="signin-button submit" type="submit">Посмотреть</button>
                    </form>
                    <form  action="Controller" method="post">
                        <input type="hidden" name="command" value="apply" />

                        <input type="hidden" name="course" value="${subjectForStudent.id}"/>

                        <button class="signin-button submit" type="submit">Подать заявку</button>
                    </form>

                </div>
                <c:set var="countOtherSubjectStudent" value="${countOtherSubjectStudent+1}" scope="page"/>
                <c:if test="${(countOtherSubjectStudent%4)==0}"></div></c:if>
            </c:forEach>
        </div>

        <div class="stab"></div>
    </div>
    <footer class="main-footer">
        COURSE PORTAL
    </footer>
</div>
</body>
</html>
