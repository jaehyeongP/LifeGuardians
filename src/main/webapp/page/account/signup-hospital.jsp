<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
  <jsp:include page="/fragments/head.jsp"/>
</head>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>

  window.onload = function(){
    document.getElementById("address").addEventListener("click", function(){ //주소입력칸을 클릭하면
      //카카오 지도 발생
      new daum.Postcode({
        oncomplete: function(data) { //선택시 입력값 세팅
          var addr = ''; // 주소 변수
          var extraAddr = ''; // 참고항목 변수

          //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
          if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
            addr = data.roadAddress;
          } else { // 사용자가 지번 주소를 선택했을 경우(J)
            addr = data.jibunAddress;
          }

          // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
          if(data.userSelectedType === 'R'){
            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
              extraAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
              extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraAddr !== ''){
              extraAddr = ' (' + extraAddr + ')';
            }
            // 조합된 참고항목을 해당 필드에 넣는다.
            document.getElementById("extraAddress").value = extraAddr;

          } else {
            document.getElementById("extraAddress").value = '';
          }

          document.getElementById("address").value = addr;

        }
      }).open();
    });
  }

</script>

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
                <h3>병원 유저 회원가입</h3>
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
                      <input id="address" class="form-control" type="text"  placeholder="주소">
                    </div>

                    <div class="input-group mb-1">
                      <input id="extraAddress" class="form-control" type="text"  placeholder="상세주소">
                    </div>

                    <hr>

                    <div class="input-group mb-1">
                      <input type="hidden" class="form-control" placeholder="hp-id">
                    </div>

                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="병원 이름">
                    </div>

                    <div class="input-group mb-1">
                      <input type="text" class="form-control" placeholder="전화번호">
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