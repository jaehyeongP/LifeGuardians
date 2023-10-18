window.onload = function () {
    createTableTitle();
    callAjax();
}

function callAjax() {
    $.ajax({
        type: "GET",
        url: "/api/reservation/list.do",
        dataType: "json",

        success: function (jsonData) {
            console.log(jsonData);
            $('#hospital-select-tbody').children().remove();
            createTbody(jsonData);

        },
        error: function (error) {

        }
    });
}


function createTbody(jsonData) {
    let tbody = $('#hospital-select-tbody');
    createTableTitle();

    jsonData.forEach(function (data) {
        let tr = createTableData(data);
        tbody.append(tr);
    });
}


function createTableTitle() {
    let tbody = $('#hospital-select-tbody');

    let tableTitle = $('<tr>').prop({id: "title"});
    let dutyNameTitleTh = $('<th>').prop({innerHTML: "병원 이름"});
    let dutyDivNameTitleTh = $('<th>').prop({innerHTML: "분류"});
    let extraAddressTitleTh = $('<th>').prop({innerHTML: "예약상태"});
    let telTitleTh = $('<th>').prop({innerHTML: "전화 번호"});

    tableTitle.append(dutyNameTitleTh);
    tableTitle.append(telTitleTh);
    tableTitle.append(dutyDivNameTitleTh);
    tableTitle.append(extraAddressTitleTh);
    tbody.prepend(tableTitle);
}

function createTableData(data) {
    let hpid = data.hpid;

    let tr = $('<tr>').prop({id: hpid}).on('click', function () {selectHP(this)});
    let dutyNameTd = $('<td>').prop({id: hpid + "_dutyName", innerHTML: data.dutyName});
    let dutyDivNameTd = $('<td>').prop({id:"extra", innerHTML:data.dutyDivName});
    let dutyTel1Td = $('<td>').prop({id: hpid + "_dutyTel1", innerHTML: data.dutyTel1});

    let reserveTimeTd = $('<input>').prop({id: hpid + "_reserveTime", type: 'hidden', value: data.reserveId})
    let address = $('<input>').prop({id: hpid + "_address", type: 'hidden', value: data.address});
    let detailBtn = $('<div>')
        .prop({id:hpid+ "_detail_btn", innerHTML: data.status})
        .on('click', function () {showDetail(this)});


    tr.append(dutyNameTd);
    tr.append(dutyTel1Td);
    tr.append(dutyDivNameTd);
    tr.append(reserveTimeTd);
    tr.append(address);
    tr.append(detailBtn);

    return tr;
}

// table에서 숨겨진 reserveid를 가져와야함
function selectHP(element) {
    let hpid = $(element).attr('id');

    let address = $(element).find('#'+ hpid + '_address').val();
    let reserveId = $(element).find('#'+ hpid + '_reserveTime').val();
    $('#map_address').text(address);

    // $('#hpid_dutyName').attr('value',dutyName);
    // $('#hidden_reserveId').attr('value',reserveId);
    document.getElementById('hidden_reserveId').value = reserveId;


    console.log(hpid);
    console.log(address);
}

// 예약 상세페이지
function showDetail() {
    // $("#reservationModal").modal('show');

    $.ajax({
        type:"GET",
        url:"/api/reservation/list.do",
        dataType: "JSON",

        success: function (jsonData){
            // TODO 예약 상세페이지 + 리뷰할 수 있게 버튼
            console.log(jsonData);
            var hgenDate = jsonData.genDate;
            console.log(hgenDate);
            console.log(jsonData.status);

            // let txt ="";
            // txt += "<h3>" + "예약 상세정보" + "</h3>";
            // txt += "<input id='hidden_reserveId' type='hidden' value='"+jsonData.reserveId+"'>";
            // console.log("10");
            // txt += "예약상태 : "+ jsonData.dutyName+"<br/>";
            // txt += "증상 : "+ jsonData.symptoms+"<br/>";
            // txt += "예약시간 : " + jsonData.reserveTime+ "<br/>";
            // txt += "수정일: "+ jsonData.editDate + "<br/>";
            // txt += "<div style='border:2px solid blue'>";
            // txt += "</div>";
            //
            //
            // $("#reserve_detail").html(txt);
        },
        error:function (error){
            console.log("error");
        }


    })


}

