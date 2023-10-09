<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- ======= Header ======= -->
  <div class="container d-flex align-items-center">
    <div class="logo me-auto">
        <%-- TODO: Change Text to Image --%>
        <a href="/" class="d-flex"><img src="/resource/assets/img/logo/lg.jpeg">
            <h2>Life Guardians</h2>
        </a>
    </div>

    <nav id="navbar" class="navbar order-last order-lg-0">
      <ul>
        <li><a class="nav-link" href="/hospital/list.do">병원</a></li>
        <li><a class="nav-link" href="/medicine/list.do">약</a></li>
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
      <a href="/login.do" class="appointment-btn scrollto"><span class="d-none d-md-inline"></span>로그인</a>
    </c:if>

<%--    <c:if test="${sessionScope.loginId != null }">--%>
<%--      <a href="/member/logout.do" class="appointment-btn scrollto"><span class="d-none d-md-inline"></span>로그아웃</a>--%>
<%--    </c:if>--%>



  </div>