<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--모달창--%>

<!-- 버튼을 클릭하면 모달 창이 열립니다 -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#reservationModal">
    예약 확인
</button>

<!-- 모달 창 -->
<div class="modal fade" id="reservationModal" tabindex="-1" role="dialog" aria-labelledby="reservationModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="reservationModalLabel">예약 확인</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- 예약 정보를 모달 내에 표시합니다 -->
                <h2>예약 정보</h2>
                <p><strong>이름:</strong> John Doe</p>
                <p><strong>이메일:</strong> johndoe@example.com</p>
                <p><strong>전화번호:</strong> 123-456-7890</p>
                <p><strong>예약 일자:</strong> 2023-10-15</p>
                <p><strong>추가 메시지:</strong> 추가 메시지를 입력하세요</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                <a href="" class="btn btn-primary">예약 상태 확인</a>
            </div>
        </div>
    </div>
</div>

