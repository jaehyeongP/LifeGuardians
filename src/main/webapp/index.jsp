<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="utf-8">
<head>
    <jsp:include page="fragments/head.jsp"/>
</head>

<body>

<div id="topbar" class="d-flex align-items-center fixed-top">
    <jsp:include page="fragments/common/topbar.jsp"/>
</div>

<header id="header" class="fixed-top">
    <jsp:include page="fragments/common/header.jsp"/>
</header>

<main id="main">
    <section id="services" class="services">
        <div class="container">

            <div class="section-title">
                <h2>기능</h2>
                <p>웹의 주요 기능</p>
            </div>

            <div class="row">
                <div class="col-lg-4 col-md-6 align-items-stretch">
                    <div class="icon-box card">
                        <div class="icon"><i class="fas fa-hospital-user"></i></div>
                        <h4><a href="/hospital/list.do" class="stretched-link">병원</a></h4>
                        <p>병원 검색 및 예약</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 align-items-stretch mt-4 mt-md-0">
                    <div class="icon-box card">
                        <div class="icon"><i class="fas fa-pills"></i></div>
                        <h4><a href="/medicine/list.do" class="stretched-link">약</a></h4>
                        <p>약 검색 및 관리</p>
                    </div>
                </div>

                <div class="col-lg-4 col-md-6 align-items-stretch mt-4 mt-lg-0">
                    <div class="icon-box card">
                        <div class="icon"><i class="fas fa-notes-medical"></i></div>
                        <h4><a href="/board/list.do" class="stretched-link">게시판</a></h4>
                        <p>자유 게시판 및 질문 게시판</p>
                    </div>
                </div>
            </div>
        </div>
    </section><!-- End Services Section -->

    <!-- ======= Frequently Asked Questions Section ======= -->
    <section id="faq" class="faq section-bg">
        <div class="container">
            <div class="section-title">
                <h2>Q&A</h2>
                <p>자주 묻는 질문</p>
            </div>

            <div class="faq-list">
                <ul>
                    <li data-aos="fade-up" data-aos-delay="100">
                        <i class="bx bx-help-circle icon-help"></i> <a data-bs-toggle="collapse"
                                                                       data-bs-target="#faq-list-1" class="collapsed">타이레놀을
                        음료수와 먹어도 되나요?<i class="bx bx-chevron-down icon-show"></i><i
                                class="bx bx-chevron-up icon-close"></i></a>
                        <div id="faq-list-1" class="collapse" data-bs-parent=".faq-list">
                            <p>
                                안됩니다.
                            </p>
                        </div>
                    </li>

                    <li data-aos="fade-up" data-aos-delay="100">
                        <i class="bx bx-help-circle icon-help"></i> <a data-bs-toggle="collapse"
                                                                       data-bs-target="#faq-list-2" class="collapsed">
                        자주 묻는 질문2 <i class="bx bx-chevron-down icon-show"></i><i
                            class="bx bx-chevron-up icon-close"></i></a>
                        <div id="faq-list-2" class="collapse" data-bs-parent=".faq-list">
                            <p>
                                답변2
                            </p>
                        </div>
                    </li>

                    <li data-aos="fade-up" data-aos-delay="200">
                        <i class="bx bx-help-circle icon-help"></i> <a data-bs-toggle="collapse"
                                                                       data-bs-target="#faq-list-3" class="collapsed">
                        자주 묻는 질문3 <i class="bx bx-chevron-down icon-show"></i><i
                            class="bx bx-chevron-up icon-close"></i></a>
                        <div id="faq-list-3" class="collapse" data-bs-parent=".faq-list">
                            <p>
                                답변3
                            </p>
                        </div>
                    </li>

                    <li data-aos="fade-up" data-aos-delay="300">
                        <i class="bx bx-help-circle icon-help"></i> <a data-bs-toggle="collapse"
                                                                       data-bs-target="#faq-list-4" class="collapsed">자주
                        묻는 질문4<i
                                class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
                        <div id="faq-list-4" class="collapse" data-bs-parent=".faq-list">
                            <p>
                                답변4
                            </p>
                        </div>
                    </li>

                    <li data-aos="fade-up" data-aos-delay="400">
                        <i class="bx bx-help-circle icon-help"></i> <a data-bs-toggle="collapse"
                                                                       data-bs-target="#faq-list-5" class="collapsed">
                        자주 묻는 질문5<i
                            class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
                        <div id="faq-list-5" class="collapse" data-bs-parent=".faq-list">
                            <p>
                                답변5
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </section><!-- End Frequently Asked Questions Section -->

    <!-- ======= Testimonials Section ======= -->
    <section id="testimonials" class="testimonials h-50">
        <div class="container">
            <div class="testimonials-slider swiper-container" data-aos="fade-up" data-aos-delay="100">
                <div class="swiper-wrapper">
                    <div class="swiper-slide">
                        <div class="testimonial-wrap">
                            <div class="testimonial-item">
                                <img src="/resource/assets/img/testimonials/testimonials-1.jpg" class="testimonial-img"
                                     alt="">
                                <h3>Saul Goodman</h3>
                                <h4>팀장 &amp; 역할</h4>
                                <p>
                                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                    각자 프로젝트 후기를 남길까요?
                                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                </p>
                            </div>
                        </div>
                    </div><!-- End testimonial item -->
                    <div class="swiper-slide">
                        <div class="testimonial-wrap">
                            <div class="testimonial-item">
                                <img src="/resource/assets/img/testimonials/testimonials-2.jpg" class="testimonial-img"
                                     alt="">
                                <h3>Sara Wilsson</h3>
                                <h4>팀원 역할</h4>
                                <p>
                                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                    안녕하세요
                                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                </p>
                            </div>
                        </div>
                    </div><!-- End testimonial item -->
                    <div class="swiper-slide">
                        <div class="testimonial-wrap">
                            <div class="testimonial-item">
                                <img src="/resource/assets/img/testimonials/testimonials-3.jpg" class="testimonial-img"
                                     alt="">
                                <h3>Sara Wilsson</h3>
                                <h4>팀원, 역할</h4>
                                <p>
                                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                    반갑습니다.
                                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                </p>
                            </div>
                        </div>
                    </div><!-- End testimonial item -->
                    <div class="swiper-slide">
                        <div class="testimonial-wrap">
                            <div class="testimonial-item">
                                <img src="/resource/assets/img/testimonials/testimonials-4.jpg" class="testimonial-img"
                                     alt="">
                                <h3>Sara Wilsson</h3>
                                <h4>팀원, 역할1</h4>
                                <p>
                                    <i class="bx bxs-quote-alt-left quote-icon-left"></i>
                                    잘부탁드립니다.
                                    <i class="bx bxs-quote-alt-right quote-icon-right"></i>
                                </p>
                            </div>
                        </div>
                    </div><!-- End testimonial item -->
                </div>
                <div class="swiper-pagination">

                </div>
            </div>
        </div>
    </section><!-- End Testimonials Section -->

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