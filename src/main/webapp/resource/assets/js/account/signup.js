window.onload = function () {
    document.getElementById("address").addEventListener("focus", function () { //주소입력칸을 클릭하면
        //카카오 지도 발생
        openKakaoModal();
        $(this).blur(); //포커스 상태가 유지되면 계속 이벤트가 발생하므로 사용
    });
}


function openKakaoModal() {
    new daum.Postcode({
        oncomplete: function (data) {       //선택시 입력값 세팅
            var addr = '';                 // 주소 변수
            var extraAddr = '';            // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') {  // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if (data.userSelectedType === 'R') {
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("extraAddress").value = extraAddr.trim();

            } else {
                document.getElementById("extraAddress").value = '';
            }

            // document.getElementById("address").setAttribute("value", addr);
            document.getElementById("address").value = addr;
        }
    }).open();
}