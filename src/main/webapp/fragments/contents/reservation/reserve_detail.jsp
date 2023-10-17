<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    body {
        background-color: #f5f5f5;
    }
    .container {
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        padding: 20px;
    }
    h1 {
        color: #007BFF;
    }
</style>

<div class="container mt-5">
    <h1 class="text-center">병원 방문 예약</h1>

    <!-- 예약 양식 -->
<%--    다 작성시에는 모달창 띄우기--%>
    <form action="" id="reserve" method="POST" novalidate>
        <div class="form-group">
            <label for="name">환자 이름 *</label>
            <input type="text" class="form-control" value="${member.username}" id="name" readonly>
        </div>

        <div class="form-group">
            <label for="phone">연락 받을 휴대전화 *</label>
            <input type="tel" class="form-control" id="phone" placeholder="전화번호를 입력해주세요">
        </div>

        <%--datetimepicker--%>
        <div class="form_group">
            <label for="datetimepicker">예약 일시</label><br/>
            <input type="text" id="datetimepicker" readonly="readonly" />
        </div>

        <div class="form-group">
            <label for="message">증상</label>
            <textarea class="form-control" id="message" rows="3" placeholder="증상을 입력해주세요"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">예약 신청</button>

    </form>
</div>


<!-- 모달 창 -->
<div class="modal fade" id="reservationModal" tabindex="-1" role="dialog" aria-labelledby="reservationModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="reservationModalLabel">예약 확인</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <%--                    <span aria-hidden="true">&times;</span>--%>
                </button>
            </div>
            <div class="modal-body">
                <!-- 예약 정보를 모달 내에 표시합니다 -->
                <h2>예약 정보</h2>
                <p><strong>이름:</strong> John Doe</p>
                <p><strong>전화번호:</strong> 123-456-7890</p>
                <p><strong>예약 일자:</strong> 2023-10-15</p>
                <p><strong>예약 일시:</strong> 0930</p>
                <p><strong>추가 메시지:</strong> 추가 메시지를 입력하세요</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                <a href="" class="btn btn-primary">예약 상태 확인</a>
            </div>
        </div>
    </div>
</div>


