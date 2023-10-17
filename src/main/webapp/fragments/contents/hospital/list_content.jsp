<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
    <div class="container">

        <div class="row mb-5 text-center">
            <form id="search_form" class="php-email-form px-5" method="get">

                <div class="input-group">
                    <select class="form-select" id="search_type" name="search_type">
                        <option value="medicine_name">병원이름</option>
                        <option value="symptom">진료과목</option>
                        <option value="symptom">주소</option>
                    </select>
                    <input type="text" id="search_medicine" class="form-control" placeholder="병원 검색" style="width: 50%;">
                    <input type="submit" id="search_btn" class="btn btn-primary" value="검색">
                </div>

            </form>
        </div>

        <div class="row">

            <div class="col-md-6">
                <table class="table table-hover align-items-center">
                    <tbody id="hospital-select-tbody">
                    </tbody>
                </table>
            </div>

            <div id="map_div" class="row col-md-6 align-items-center">
                <table class="table table-hover">
                    <tbody>
                    <tr><th id="map_address">병원을 선택해 주세요</th></tr>
                    </tbody>
                </table>

                <div class="card col-10 my-2">map</div>
                <div class="card col-10 my-2">review</div>
            </div>
        </div>

        <div class="row">
            <div class="card">
                test
            </div>
        </div>

    </div>
</section>