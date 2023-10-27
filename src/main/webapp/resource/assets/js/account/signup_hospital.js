window.onload = function () {
    document.getElementById("address").addEventListener("focus", function () { //주소입력칸을 클릭하면
        //카카오 지도 발생
        openKakaoModal();
        $(this).blur(); //포커스 상태가 유지되면 계속 이벤트가 발생하므로 사용
    });

    document.getElementById("address").addEventListener("change", function () { //주소입력칸의 값이 변경되면
        let address = document.getElementById("address").value;
        getHospital(address);
        $(this).blur();
    });
}

function getHospital(address) {
    naver.maps.Service.geocode({
        query: address
    }, function(status, response) {
        if (status === naver.maps.Service.Status.ERROR) {
            return alert('Something Wrong!');
        }
        if (response.v2.meta.totalCount === 0) {
            return alert('올바른 주소를 입력해주세요.');
        }
        var htmlAddresses = [],
            item = response.v2.addresses[0],
            point = new naver.maps.Point(item.x, item.y);
        if (item.roadAddress) {
            htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
        }
        if (item.jibunAddress) {
            htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
        }
        if (item.englishAddress) {
            htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
        }

        getHospitalByJson(item.x, item.y);
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

            //address의 change event를 강제로 발생 (focus를 blur()하였기에 change이벤트가 발생하지 않으므로)
            let event = new Event("change");
            document.getElementById("address").dispatchEvent(event);
        }
    }).open();
}

function getHospitalByJson(mapx, mapy) {
    $.ajax({
        type:"GET",
        url:"/api/hospital/getHsptlMdcncLcinfoInqire.do",
        dataType: 'json',
        data: {"mapx" : mapx, "mapy" : mapy},

        success: function(jsonData){
            createTbody(jsonData);          //선택된 주소를 통해 변환된 좌표를 이용하여 Modal의 Table Body를 생성
        },
        error:function(error) {

        }, complete: function () {
            $("#hospital-select-modal").modal('show'); //api의 호출이 완료되면 모달을 표시
        }
    });
}

function createTbody(jsonData) {
    let tbody = $('#hospital-select-tbody');
    tbody.children().remove();

    let tableTitle = $('<tr>').prop({id : "test"});
    let dutyNameTitleTd = $('<th>').prop({innerHTML: "병원 이름"});
    let dutyDivNameTitleTd = $('<th>').prop({innerHTML: "병원 분류"});
    tableTitle.append(dutyNameTitleTd);
    tableTitle.append(dutyDivNameTitleTd);

    jsonData.forEach(function(data) {
        let hpid = data.hpid;
        let dutyName = data.dutyName;
        let dutyDivName = data.dutyDivName;
        let dutyTel1 = data.dutyTel1;
        let latitude = data.latitude;
        let longitude = data.longitude;

        let tr = $('<tr>').prop({id : hpid});
        let dutyNameTd = $('<td>').prop({id:"dutyName_btn"});
        let dutyNameBtn = $('<div>')
            .prop({id:hpid+ "_dutyName", class: "btn btn-outline-primary", innerHTML: dutyName})
            .on('click', function () {selectHP(this)});
        let dutyDivNameTd = $('<td>').prop({id: hpid + "_dutyDivName", innerHTML: dutyDivName});
        let dutyTel1Td = $('<input>').prop({id: hpid + "_dutyTel1", type:'hidden', innerHTML: dutyTel1});
        let latitudeTd = $('<input>').prop({id: hpid + "_latitude", type:'hidden', innerHTML: latitude});
        let longitudeTd = $('<input>').prop({id: hpid + "_longitude", type:'hidden', innerHTML: longitude});

        dutyNameTd.append(dutyNameBtn);
        tr.append(dutyNameTd);
        tr.append(dutyDivNameTd);
        tr.append(dutyTel1Td);
        tr.append(latitudeTd);
        tr.append(longitudeTd);
        tbody.append(tr);
    });
    tbody.prepend(tableTitle);
}

function selectHP(element) {
    //부모 요소의 id를 통해 hpid를 참조
    let selectHp = $(element).parent().parent();
    let hpId = selectHp.attr('id');

    //hpid를 통해 각각의 데이터를 참조
    let dutyName = selectHp.find('#'+ hpId + '_dutyName').text();
    let dutyDivName = selectHp.find('#'+ hpId + '_dutyDivName').text();
    let dutyTel1 = selectHp.find('#'+ hpId + '_dutyTel1').text();
    let latitude = selectHp.find('#'+ hpId + '_latitude').text();
    let longitude = selectHp.find('#'+ hpId + '_longitude').text();

    //set input values
    $('#hp_id').attr('value', hpId);
    $('#duty_name').attr('value', dutyName);
    $('#duty_div_name').attr('value', dutyDivName);
    $('#duty_tel_1').attr('value', dutyTel1);
    $('#latitude').attr('value', latitude);
    $('#longitude').attr('value', longitude);
}