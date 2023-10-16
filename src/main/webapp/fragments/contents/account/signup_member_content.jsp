<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
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
                        <form action="/signup/member.do" id="signup" method="POST" novalidate>
                            <hr>
                            <div id="login_info" class="form-group row">
                                <!--아이디-->
                                <div class="input-group mb-1">
                                    <input id="username" class="form-control" name="username" type="text" placeholder="아이디" aria-describedby="check_duplicate_username_btn">
                                    <button id="check_duplicate_username_btn" class="btn btn-outline-secondary" type="button" onclick="checkDuplicate()">중복확인</button>
                                </div>
                                <div id="res" class="ms-1 mb-2"></div>

                                <div id="password_div" class="col-6">
                                    <input id="password" class="form-control" name="password" onchange="isSame()" type="password" placeholder="비밀번호">
                                </div>

                                <div id="confirm_password_div" class="col-6 mb-2">
                                    <input id="pwCheck" class="form-control" name="confirmPassword" onchange="isSame()" type="password" placeholder="비밀번호 확인">
                                </div>
                                <div id="same" class="ms-1 mb-1"></div>

                                <div class="input-group mb-1">
                                    <input id="email" class="form-control" name="email" type="text"
                                           placeholder="이메일" aria-label="이메일" aria-describedby="button-addon2">
                                    <button class="btn btn-outline-secondary" type="button" id="button-addon3">인증</button>
                                </div>
                            </div>
                            <hr>

                            <div id="user_info" class="form-group row">
                                <%-- 이름 --%>
                                <div class="mb-2 col-8">
                                    <input id="name" class="form-control" name="name" type="text" placeholder="이름">
                                </div>

                                <div class="col-4 mb-2">
                                    <select id="gender" class="form-select" name="gender">
                                        <option selected>성별</option>
                                        <option value="male">남자</option>
                                        <option value="female">여자</option>
                                    </select>
                                </div>

                                <div class="col-6 mb-2">
                                    <input id="first_reg_num" class="form-control" name="firstRegNum" type="text" placeholder="주민등록번호 앞자리">
                                </div>
                                <div class="col-6 mb-2">
                                    <input id="last_reg_num" class="form-control" name="lastRegNum" type="password" placeholder="주민등록번호 뒷자리">
                                </div>

                                <div class="input-group mb-2">
                                    <input id="tel" class="form-control" name="tel" type="text" placeholder="전화번호">
                                </div>

                                <div class="input-group mb-2">
                                    <input id="address" class="form-control" name="address" value="" type="text" placeholder="주소">
                                </div>

                                <div class="input-group mb-2">
                                    <input id="extraAddress" class="form-control" name="extraAddress" value="" type="text" placeholder="상세주소">
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