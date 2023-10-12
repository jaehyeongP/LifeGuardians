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
                            <a href="/" class="d-flex align-items-center"><img
                                    src="/resource/assets/img/logo/lg.jpeg" class="img-fluid">
                                <h2>Life Guardians</h2>
                            </a>
                        </div>
                    </div>

                    <div class="row mt-5">
                        <div class="col-md-12">
                            <h3>병원 유저 회원가입</h3>
                            <form action="" id="signup" method="POST" novalidate>
                                <hr>
                                <div id="login-info" class="form-group row">
                                    <!--아이디-->
                                    <div class="input-group mb-1">
                                        <input id="username" class="form-control" name="" type="text" placeholder="아이디"
                                               aria-label="Recipient's username" aria-describedby="button-addon2">
                                        <button class="btn btn-outline-secondary" type="button" id="button-addon2">
                                            중복확인
                                        </button>
                                    </div>

                                    <div id="password" class="col-6">
                                        <input class="form-control" name="" type="password" placeholder="비밀번호">
                                    </div>

                                    <div id="confirm-password" class="col-6 mb-1">
                                        <input class="form-control" name="" type="password" placeholder="비밀번호 확인">
                                    </div>

                                    <div class="input-group mb-1">
                                        <input type="text" class="form-control" placeholder="이메일" aria-label="이메일"
                                               aria-describedby="button-addon2">
                                        <button class="btn btn-outline-secondary" type="button" id="button-addon3">인증
                                        </button>
                                    </div>
                                </div>
                                <hr>

                                <div class="mb-3">
                                    <!--이름-->
                                    <div class="input-group mb-1">
                                        <input id="address" class="form-control" type="text" placeholder="주소">
                                    </div>

                                    <div class="input-group mb-1">
                                        <input id="extraAddress" class="form-control" type="text"
                                               placeholder="상세주소">
                                    </div>

                                    <hr>

                                    <div class="input-group mb-1">
                                        <input type="hidden" class="form-control" placeholder="hp-id">
                                    </div>

                                    <label class="mb-1">병원 이름</label>
                                    <div class="input-group mb-1">
                                        <input id="dutyName" class="form-control" name="" type="text"
                                               placeholder="병원 이름">
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-4">
                                            <label class="col-6">병원 분류</label>
                                            <input class="form-control col-auto" type="text" placeholder="병원 분류"
                                                   readonly>
                                        </div>

                                        <div class="col-8">
                                            <label class="col-6">전화 번호</label>
                                            <input type="text" class="form-control col-6" placeholder="전화번호">
                                        </div>
                                    </div>

                                </div>
                                <hr>

                                <div class="form-control btn btn-outline-primary">
                                    <button type="submit" style="opacity: 90%; font-size: 16px; margin-top: -5px;"
                                            class="btn btn-red btn-md btn-block">회원가입
                                    </button>
                                </div>

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
                        <tr>
                            <th>병원 이름</th>
                            <th>병원 분류</th>
                        </tr>
                        <tr>
                            <td id="div1">test1</td>
                            <td id="div2">test2</td>
                        </tr>
                    </table>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary">선택</button>
            </div>
        </div>
    </div>
</div>