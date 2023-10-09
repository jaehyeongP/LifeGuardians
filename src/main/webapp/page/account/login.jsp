<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="utf-8">
<head>
    <jsp:include page="/fragments/head.jsp"/>
</head>

<body>
<main id="main">
    <div class="container align-items-center">

        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
            <div class="logo me-auto w-25">
                <a href="/" class="align-items-center"><img src="/resource/assets/img/logo/lg.jpeg" class="img-fluid"></a>
            </div>
        </div>

            <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
                <div class="card mb-5">
                    <div class="card-body">
                        <h5 class="card-title text-center">로그인</h5>

                        <form class="" method="post" action="login">
                            <div class="form-label-group">
                                <input type="text" id="loginId" class="form-control" name="loginId" placeholder="아이디" required autofocus>
                            </div><br>

                            <div class="form-label-group">
                                <input type="password" id="password" class="form-control" name="password" placeholder="비밀번호" required>
                            </div>
                            <hr>

                            <div class="d-flex justify-content-around">
<%--                                <button class="btn btn-lg btn-secondary btn-block" onclick="location='/signup'">회원가입</button>--%>
<%--                                <button class="btn btn-lg btn-block" type="submit" style="background: #1977cc; color: white;">로그인</button>--%>

                                <button class="btn appointment-btn appointment-btn-lg btn-lg btn-secondary btn-block" onclick="location='/signup'" style="background: #6c757d">회원가입</button>
                                <button class="btn appointment-btn btn-lg btn-block" type="submit" style="background: #1977cc; color: white;">로그인</button>
                            </div>
                            <hr class="my-4">
                            <div class="text-center">
                                계정을 잊어버리셨나요?<br/>
                                <a href="#">아이디 찾기</a> or <a href="#">비밀번호 찾기</a>
                            </div>

                        </form>
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