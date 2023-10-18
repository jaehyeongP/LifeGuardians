<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- form--%>
<div class="container">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
        <div>

            <div class="card align-items-center" style="width: 40rem;">
                <div class="card-body">

                    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto my-5">
                        <div class="logo me-auto w-25">
                            <a href="/" class="d-flex align-items-center"><img src="/resource/assets/img/logo/lg.jpeg" class="img-fluid"><h2>Life Guardians</h2>
                            </a>
                        </div>
                    </div>

                    <div class="row mt-5">
                        <div class="col-md-12">
                            <h3>병원 유저 회원가입</h3>
                            <form action="/signup/hospital.do" id="signup" method="POST" novalidate>
                                <hr>
                                <div id="login_info" class="form-group row">
                                    <!--아이디-->
                                    <div class="input-group mb-1">
                                        <input id="username" class="form-control" name="username" type="text" placeholder="아이디" aria-describedby="check_duplicate_username_btn">
                                        <button id="check_duplicate_username_btn"  class="btn btn-outline-secondary" type="button" onclick="checkDuplicate()">중복확인</button>
                                    </div>
                                    <div id="res" class="ms-1 mb-1"></div>

                                    <div id="password_div" class="col-6">
                                        <input id="pw" class="form-control" name="password" onchange="isSame()" type="password" placeholder="비밀번호">
                                    </div>

                                    <div id="confirm_password_div" class="col-6 mb-2">
                                        <input id="pwCheck" class="form-control" name="confirmPassword" onchange="isSame()" type="password" placeholder="비밀번호 확인">
                                    </div>
                                    <div id="same" class="ms-1 mb-2"></div>

                                    <div class="input-group mb-1">
                                        <input id="email" class="form-control" name="email" type="text" placeholder="이메일" aria-label="이메일" aria-describedby="button-addon2">
                                        <button class="btn btn-outline-secondary" type="button" id="button-addon3">인증
                                        </button>
                                    </div>
                                </div>
                                <hr>

                                <div id="hospital_info" class="mb-3">
                                    <!--이름-->
                                    <div class="input-group mb-1">
                                        <input id="address" class="form-control" name="address" value="" type="text" placeholder="주소">
                                    </div>

                                    <div class="input-group mb-1">
                                        <input id="extraAddress" class="form-control" name="extraAddress" value="" type="text" placeholder="상세주소">
                                    </div>
                                    <hr>

                                    <label class="mb-1">병원 이름</label>
                                    <div class="input-group mb-1">
                                        <input id="duty_name" class="form-control" name="dutyName" value="" type="text" placeholder="병원 이름" readonly>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-4">
                                            <label class="col-6">병원 분류</label>
                                            <input id="duty_div_name" class="form-control col-auto" name="dutyDivName" value="" type="text" placeholder="병원 분류" readonly>
                                        </div>

                                        <div class="col-8">
                                            <label class="col-6">전화 번호</label>
                                            <input id="duty_tel_1" class="form-control col-6" name="dutyTel1" value="" type="text" placeholder="전화번호">
                                        </div>

                                        <div>
                                            <input id="hp_id" name="hpid" value="" type="hidden">
                                            <input id="latitude" name="latitude" value="" type="hidden">
                                            <input id="longitude" name="longitude" value="" type="hidden">
                                        </div>
                                    </div>
                                </div>
                                <hr>

                                <button class="form-control btn btn-outline-primary" type="submit">회원가입</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div id="hospital-select-modal" class="modal fade" data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 id="staticBackdropLabel" class="modal-title fs-5">병원 선택</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="list-group">
                    <table class="table table-hover align-items-center">
                        <tbody id="hospital-select-tbody">

                        </tbody>
                    </table>
                </div>
            </div>

            <div>
                <nav aria-label="Page navigation">
                    <ul class="pagination" id="pagination"></ul>
                </nav>
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>