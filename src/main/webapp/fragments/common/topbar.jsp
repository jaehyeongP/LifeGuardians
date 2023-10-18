<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ======= Top Bar ======= -->
<div class="container d-flex justify-content-between">
    <div class="contact-info d-flex align-items-center">

        <c:if test="${sessionScope.username == null}">
            <i class="bi bi-gear"></i> <a href="#">로그인</a>
        </c:if>

        <c:if test="${sessionScope.username != null}">
            <i class="bi bi-gear"></i><a href="/member/mypage.do">${sessionScope.username}님 반갑습니다</a>
            <i class="bi bi-calendar-check"></i><a href="/hospital/reservation/list.do"> 내 예약 관리</a>
            <i class="bi bi-capsule"></i><a href="/medicine/mypage.do"> 내 약 관리</a>
        </c:if>

    </div>

    <div class="d-flex social-links align-items-center">
        <a href="https://edu.kosta.or.kr" target="_blank"><div class="kosta-icon"></div></a>
        <a href="https://www.notion.so/8743349320224985957abdbf9007beec?v=df86c217eed04f83b38f9adf0014e4a9" target="_blank"><div class="notion-icon"></div></a>
        <a href="https://github.com/sehoh/LifeGuardians" target="_blank"><div class="github-icon"></div></a>

    </div>
</div>
