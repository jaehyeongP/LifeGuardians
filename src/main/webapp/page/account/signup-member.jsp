<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
  <jsp:include page="/fragments/head.jsp"/>
</head>

<body>
<main id="main" class="bg-secondary">
  <div class="container">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
      <div>

        <div class="card" style="width: 40rem;">
          <div class="card-body">

            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
              <div class="logo me-auto w-25">
                <a href="/" class="d-flex align-items-center"><img src="/resource/assets/img/logo/lg.jpeg" class="img-fluid">
                  <h2>Life Guardians</h2>
                </a>
              </div>
            </div>

            <div class="row mt-5">
              <div class="col-12">
                <h3>일반 유저 회원가입</h3>
                <form action="" id="signup" method="POST" novalidate>
                  <hr>
                  <div class="mb-3">
                    <!--아이디-->
                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="아이디" aria-label="Recipient's username" aria-describedby="button-addon2">
                      <button class="btn btn-outline-secondary" type="button" id="button-addon2">중복확인</button>
                    </div>

                    <!--비밀번호-->
                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="비밀번호">
                    </div>

                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="비밀번호 확인">
                    </div>

                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="이메일" aria-label="이메일" aria-describedby="button-addon2">
                      <button class="btn btn-outline-secondary" type="button" id="button-addon3">인증</button>
                    </div>
                  </div>
                  <hr>

                  <div class="mb-3">
                    <!--이름-->
                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="이름">
                    </div>

                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="성별">
                    </div>

                    <div class="col-4 input-group mb-1">
                      <input type="text" class="form-control col-4" placeholder="주민등록번호 앞자리">
                    </div>
                    <span>-</span>

                    <div class="col-4 input-group mb-1">
                      <input type="text" class="form-control col-4" placeholder="주민등록번호 뒷자리">
                    </div>

                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="전화번호">
                    </div>
                  </div>
                  <hr>

                  <div class="form-control btn btn-outline-primary">
                    <button type="submit" style="opacity: 90%; font-size: 16px; margin-top: -5px;" class="btn btn-red btn-md btn-block">회원가입</button>
                  </div>

                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>


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