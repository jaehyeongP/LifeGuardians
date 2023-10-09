<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- ======= Header ======= -->
  <div class="container d-flex align-items-center">

    <!--        <h1 class="logo me-auto"><a href="index.html">LG</a></h1>-->

    <h1 class="logo me-auto"><a href="/"><img src="/resource/assets/img/logo/lg.jpeg"></a></h1>
    <!-- Uncomment below if you prefer to use an image logo -->
    <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

    <nav id="navbar" class="navbar order-last order-lg-0">
      <ul>
        <li><a class="nav-link" href="/hp/list.do">병원</a></li>
        <li><a class="nav-link" href="/md/list.do">약</a></li>
        <li><a class="nav-link" href="/board/list.do">게시판</a></li>

        <!--                <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>-->
        <!--                    <ul>-->
        <!--                        <li><a href="#">Drop Down 1</a></li>-->
        <!--                        <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>-->
        <!--                            <ul>-->
        <!--                                <li><a href="#">Deep Drop Down 1</a></li>-->
        <!--                                <li><a href="#">Deep Drop Down 2</a></li>-->
        <!--                                <li><a href="#">Deep Drop Down 3</a></li>-->
        <!--                                <li><a href="#">Deep Drop Down 4</a></li>-->
        <!--                                <li><a href="#">Deep Drop Down 5</a></li>-->
        <!--                            </ul>-->
        <!--                        </li>-->
        <!--                        <li><a href="#">Drop Down 2</a></li>-->
        <!--                        <li><a href="#">Drop Down 3</a></li>-->
        <!--                        <li><a href="#">Drop Down 4</a></li>-->
        <!--                    </ul>-->
        <!--                </li>-->
      </ul>
      <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->

    <c:if test="${sessionScope.loginId == null }">
      <a href="/member/login.jsp" class="appointment-btn scrollto"><span class="d-none d-md-inline"></span>로그인</a>
    </c:if>

<%--    <c:if test="${sessionScope.loginId != null }">--%>
<%--      <a href="/member/logout.do" class="appointment-btn scrollto"><span class="d-none d-md-inline"></span>로그아웃</a>--%>
<%--    </c:if>--%>



  </div>