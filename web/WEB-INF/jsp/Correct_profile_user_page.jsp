<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/sign-in.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/style/student-profile.css" rel="stylesheet">

    <fmt:setLocale value="${sessionScope.local}"/>
    <fmt:setBundle basename="localization.local" var="loc"/>
    <fmt:message bundle="${loc}" key="local.back" var="back"/>
    <fmt:message bundle="${loc}" key="local.course_portal" var="course_portal"/>
    <fmt:message bundle="${loc}" key="local.signOut" var="signOut"/>
    <fmt:message bundle="${loc}" key="local.save_profile" var="save"/>
    <fmt:message bundle="${loc}" key="local.profile.enter.name" var="enter_name"/>
    <fmt:message bundle="${loc}" key="local.profile.enter.surname" var="enter_surname"/>
    <fmt:message bundle="${loc}" key="local.profile.enter.skype" var="enter_skype"/>
    <fmt:message bundle="${loc}" key="local.profile.enter.email" var="enter_email"/>
    <fmt:message bundle="${loc}" key="local.profile.enter.phone" var="enter_phone"/>
    <fmt:message bundle="${loc}" key="local.name" var="name"/>
    <fmt:message bundle="${loc}" key="local.surname" var="surname"/>
    <fmt:message bundle="${loc}" key="local.phone" var="phone"/>


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



   <div class="info-content-save">
       <form  action="Controller" method="post">
            <div class="row-content">
                <div class="title-info text-info"><label for="name">${name}</label></div>
                <input type="text" class="value-info text-info field-input" placeholder="${enter_name}" id="name" name="name" />
            </div>
            <div class="row-content">
                <div class="title-info text-info"><label for="surname">${surname}</label></div>
                <input type="text" class="value-info text-info field-input" placeholder="${enter_surname}" id="surname"  name="surname"/>
            </div>
            <div class="row-content">
                <div class="title-info text-info"><label for="email">Email</label></div>
                <input type="text" class="value-info text-info field-input" placeholder="${enter_email}" id="email" name="email" pattern="[\w]+@[a-z]+.[a-z]{2,3}"/>
            </div>
            <div class="row-content">
                <div class="title-info text-info"><label for="phone">${phone}</label></div>
                <input type="text" class="value-info text-info field-input" placeholder="${enter_phone}" id="phone" name="phone" pattern="[\+]?[([0-9]+)|([\-]?)]+"/>
            </div>
            <div class="row-content">
                <div class="title-info text-info"><label for="skype">Skype</label></div>
                <input type="text" class="value-info text-info field-input" placeholder="${enter_skype}" id="skype" name="skype"/>
            </div>

           <input type="hidden" name="command" value="save-user" />
           <button class="signin-button save-button">${save}</button>
       </form>
        </div>


    <footer class="main-footer">
        ${course_portal}

    </footer>

</div>

</body>
</html>
