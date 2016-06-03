<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>Course portal</title>
      <meta charset="utf-8">
      <style>

         <%@include file='style/main.css' %>
         <%@include file='style/sign-in.css' %>

      </style>
    <fmt:setLocale value="${sessionScope.local}" />
    <fmt:setBundle basename="localization.local" var="loc" />
    <fmt:message bundle="${loc}" key="local.login" var="login" />
      <fmt:message bundle="${loc}" key="local.password" var="password" />
      <fmt:message bundle="${loc}" key="local.signIn" var="signIn" />
      <fmt:message bundle="${loc}" key="local.registration" var="registration" />
      <fmt:message bundle="${loc}" key="local.locbutton.name.ru"
                 var="ru_button" />
    <fmt:message bundle="${loc}" key="local.locbutton.name.en"
                 var="en_button" />


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
              <div class="sign-in">
                  <a class="signin-button" href="#overlay">Sign in</a>
                  <div class="user">
                  </div>


                  <div class="location">
                      <form action="ControllerLocal" method="post">
                          <input type="hidden" name="local" value="ru" />
                          <a href="">${ru_button}</a>
                      </form>

                      <div class="separator"></div>
                      <form action="ControllerLocal" method="post">
                          <input type="hidden" name="local" value="en" />
                          <a href="">${en_button}</a>
                      </form>
                  </div>
              </div>
          </nav>
      </header>
      <div class="banner">
          <img src="images/cover_banner.jpg" alt="">
          <div class="title-banner">
              <span class="main-title">Welcom to Course Portal</span>
              <span class="other-inf">Огромный выбор курсов на любые темы</span>
          </div>
      </div>
      <div class="main-content">
          <div class="all-courses">
              <span>Все курсы</span>
              <div class="row">
                  <div class="course">
                      <div class="logo-course"><img src="images/atoms_dva.jpg" alt=""></div>
                      <div class="course-name"><a href="course.html">Изучение квантового мира</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>30</span></div>
                          <div class="begin"><span>10-05-2015</span></div>
                          <div class="duration">1.5 месяца</div>
                      </div>
                      <div class="registration"><a href="course.html">Просмотреть</a></div>
                  </div>
                  <div class="course">
                      <div class="logo-course"><img src="images/math.jpg"></div>
                      <div class="course-name"><a href="/">Высшая математика с Владом</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>30</span></div>
                          <div class="begin"><span>10-05-2015</span></div>
                          <div class="duration">1.5 месяца</div>
                      </div>
                      <div class="registration"><a href="/">Просмотреть</a></div>
                  </div>
                  <div class="course">
                      <div class="logo-course"><img src="images/russian.png"></div>
                      <div class="course-name"><a href="/">Подготовка к ЦТ по русскому языку</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>30</span></div>
                          <div class="begin"><span>10-05-2015</span></div>
                          <div class="duration">1.5 месяца</div>
                      </div>
                      <div class="registration"><a href="/">Просмотреть</a></div>
                  </div>
                  <div class="course">
                      <div class="logo-course"><img src="images/computer.jpg"></div>
                      <div class="course-name"><a href="/">Основы работы с компьютером</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>12</span></div>
                          <div class="begin"><span>20-05-2015</span></div>
                          <div class="duration">2 месяца</div>
                      </div>
                      <div class="registration"><a href="/">Подать заявку</a></div>
                  </div>
              </div>
              <div class="row">
                  <div class="course">
                      <div class="logo-course"><img src="images/atoms_dva.jpg" alt=""></div>
                      <div class="course-name"><a href="">Изучение квантового мира</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>30</span></div>
                          <div class="begin"><span>10-05-2015</span></div>
                          <div class="duration">1.5 месяца</div>
                      </div>
                      <div class="registration"><a href="">Просмотреть</a></div>
                  </div>
                  <div class="course">
                      <div class="logo-course"><img src="images/math.jpg"></div>
                      <div class="course-name"><a href="/">Высшая математика с Владом</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>30</span></div>
                          <div class="begin"><span>10-05-2015</span></div>
                          <div class="duration">1.5 месяца</div>
                      </div>
                      <div class="registration"><a href="/">Просмотреть</a></div>
                  </div>
                  <div class="course">
                      <div class="logo-course"><img src="images/russian.png"></div>
                      <div class="course-name"><a href="/">Подготовка к ЦТ по русскому языку</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>30</span></div>
                          <div class="begin"><span>10-05-2015</span></div>
                          <div class="duration">1.5 месяца</div>
                      </div>
                      <div class="registration"><a href="/">Просмотреть</a></div>
                  </div>
                  <div class="course">
                      <div class="logo-course"><img src="images/computer.jpg"></div>
                      <div class="course-name"><a href="/">Основы работы с компьютером</a></div>
                      <div class="course-info">
                          <div class="number-listeners"><span>12</span></div>
                          <div class="begin"><span>20-05-2015</span></div>
                          <div class="duration">2 месяца</div>
                      </div>
                      <div class="registration"><a href="/">Подать заявку</a></div>
                  </div>
              </div>
          </div>

          <div class="more-courses">
              <a href="/">Больше курсов</a>
          </div>
          <div class="stab"></div>
      </div>
      <footer class="main-footer">
          COURSE PORTAL

      </footer>

      </div>
  <a href="" class="overlay" id="overlay"></a>
  <div class="regestration-window">
      <div class="window-header main-header">
          COURSE PORTAL
      </div>





      <form class="form-regestration" action="Controller" method="post">
          <input type="hidden" name="command" value="login" />

          <input class="input-field" placeholder="Введите логин" type="text" name="login"/>
          <input class="input-field" placeholder="Введите пароль" type="password" name="password"/>

          <button class="signin-button submit" type="submit">${signIn}</button>
          <div class="or"><span>ИЛИ</span></div>

          <button class="signin-button submit" type="submit">${registration}</button>
      </form>

  </div>
  </body>


</html>
