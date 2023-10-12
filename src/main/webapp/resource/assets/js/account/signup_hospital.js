window.onload = function () {
    document.getElementById("address").addEventListener("focus", function () { //주소입력칸을 클릭하면
        //카카오 지도 발생
        openKakaoModal();
        $(this).blur();

        //address의 change event를 강제로 발생 (focus를 blur()하였기에 change이벤트가 발생하지 않으므로)
        let event = new Event("change");
        document.getElementById("address").dispatchEvent(event);
    });

    document.getElementById("address").addEventListener("change", function () { //주소입력칸을 클릭하면
        //카카오 지도 발생
        getHospitalByJson(1, 1);
        $(this).blur();
    });

    document.getElementById("dutyName").addEventListener("click", function () { //주소입력칸을 클릭하면
        //카카오 지도 발생
        $("#hospital-select-modal").modal('show'); // 모달을 표시
        getHospitalByJson(1, 1);
    });


}

function openKakaoModal() {
    new daum.Postcode({
        oncomplete: function (data) { //선택시 입력값 세팅
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
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
                document.getElementById("extraAddress").value = extraAddr;

            } else {
                document.getElementById("extraAddress").value = '';
            }

            document.getElementById("address").value = addr;

        }
    }).open();


}

function getHospitalByJson(mapx, mapy) {

    $.ajax({
        type:"GET",
        url:"/api/getHsptlMdcncLcinfoInqire.do",
        contentType: "application/json",
        dataType: 'json',

        success: function(jsonData){
            console.log(jsonData);

            jsonData.forEach(function(obj) {
                var hpid = obj.hpid;
                var dutyName = obj.dutyName;
                var latitude = obj.latitude;
                var longitude = obj.longitude;

                console.log("hpid: " + hpid);
                console.log("dutyName: " + dutyName);
                console.log("latitude: " + latitude);
                console.log("longitude: " + longitude);

            });

        },
        error:function(error) {

        }
    });


}





