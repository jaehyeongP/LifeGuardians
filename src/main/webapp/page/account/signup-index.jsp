<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<head>
  <jsp:include page="/fragments/head.jsp"/>
</head>

<body>
<main id="main">
  <section id="signup" class="services">
    <div class="container">
      <div class="section-title">
        <h2>회원가입</h2>
      </div>

      <div class="row">
        <div class="col-lg-6 col-md-6 align-items-stretch mt-4 mt-md-0">
          <div class="icon-box card">
            <div class="icon"><i class="bi bi-person-plus-fill"></i></div>
            <h4><a href="/signup/member.do" class="stretched-link">일반 유저</a></h4>
            <p>일반 유저로 등록</p>
          </div>
        </div>

        <div class="col-lg-6 col-md-6 align-items-stretch">
          <div class="icon-box card">
            <div class="icon"><i class="fas fa-hospital-user"></i></div>
            <h4><a href="/signup/hospital.do" class="stretched-link">병원 유저</a></h4>
            <p>병원 유저로 등록</p>
          </div>
        </div>

        <div class="text-center my-5">
          <span>이미 계정이 있으신가요?</span><br/>
          <a href="/login.do">로그인</a>
        </div>
      </div>
    </div>
  </section><!-- End Services Section -->

</main><!-- End #main -->

<footer id="footer" class="fixed-bottom">
  <jsp:include page="/fragments/common/footer.jsp"/>
</footer>

<%-- 위로가기 버튼--%>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<jsp:include page="/fragments/vendor.jsp"/>

<!-- Template Main JS File -->
<script src="/resource/assets/js/main.js"></script>

</body>

</html>