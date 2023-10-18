<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
    </nav><!-- .navbar -->

    <c:if test="${sessionScope.username == null }">
        <a href="/login.do" class="appointment-btn scrollto"><span class="d-none d-md-inline"></span>로그인</a>
    </c:if>

    <c:if test="${sessionScope.username != null}">
        <a href="/logout.do" class="appointment-btn scrollto bg-secondary"><span class="d-none d-md-inline"></span>로그아웃</a>
    </c:if>


</div>