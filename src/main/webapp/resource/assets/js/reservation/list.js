window.onload = function () {
    createTableTitle();
    callAjax();

    document.getElementById('bestImage').addEventListener('click', changeImageBest);
    document.getElementById('goodImage').addEventListener('click', changeImageGood);
    document.getElementById('normalImage').addEventListener('click', changeImageNormal);
    document.getElementById("badImage").addEventListener("click", changeImageBad);
    document.getElementById("worstImage").addEventListener("click",changeImageWorst);
    document.getElementById('add_best').addEventListener('change', changeImageBest);
    document.getElementById('add_good').addEventListener('change', changeImageGood);
    document.getElementById('add_normal').addEventListener('change', changeImageNormal);
    document.getElementById('add_bad').addEventListener("change", changeImageBad);
    document.getElementById("add_worst").addEventListener("change", changeImageWorst);

    $('#review_submit_form').on("submit", function (e) {
        e.preventDefault(); //공부
        let hpid = $('#review_hpid').val();
        calReviewAddHandler(hpid);
    });
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

    let tr = $('<tr>').prop({id: hpid}).on('click', function () {
        selectHP(this)
    });
    let dutyNameTd = $('<td>').prop({id: hpid + "_dutyName", innerHTML: data.dutyName});
    let dutyDivNameTd = $('<td>').prop({id: "extra", innerHTML: data.dutyDivName});
    let dutyTel1Td = $('<td>').prop({id: hpid + "_dutyTel1", innerHTML: data.dutyTel1});

    let reserveIdTd = $('<input>').prop({id: hpid + "_reserveId", type: 'hidden', value: data.reserveId});
    let reserveTimeTd = $('<input>').prop({id: hpid + "_reserveTime", type: 'hidden', value: data.reserveTime});
    let address = $('<input>').prop({id: hpid + "_address", type: 'hidden', value: data.address});
    let detailBtn = $('<div>')
        .prop({id: hpid + "_detail_btn", innerHTML: data.status})
        .on('click', function () {showDetail(this)});

    tr.append(reserveIdTd);
    tr.append(dutyNameTd);
    tr.append(dutyTel1Td);
    tr.append(dutyDivNameTd);
    tr.append(reserveTimeTd);
    tr.append(address);
    tr.append()
    tr.append(detailBtn);

    return tr;
}

// table에서 숨겨진 reserveid를 가져와야함
function selectHP(element) {
    let hpid = $(element).attr('id');

    let address = $(element).find('#' + hpid + '_address').val();
    let reserveId = $(element).find('#' + hpid + '_reserveTime').val();
    let dutyName = $(element).find('#' + hpid + '_dutyName').text();
    $('#map_address').text(address);

    console.log("@@@")
    console.log(dutyName);

    document.getElementById(hpid+'_reserveId').value = reserveId;
    document.getElementById('review_dutyName').value = dutyName;
    document.getElementById('review_hpid').value = hpid;

    $('#review_dutyName').val(dutyName);
    $('#review_hpid').val(hpid);

    setModal();

}
// 예약 상세페이지
function showDetail(element) {
    let hpid = $(element).parent().attr('id');
    let reserveId = $('#'+hpid+'_reserveId').val();

    $.ajax({
        type: "GET",
        url: "/api/reservation/detail.do",
        dataType: 'json',
        data: {"reserveId" : reserveId},

        success: function (jsonData) {
            $('#dutyName_label').text(jsonData.dutyName);
            $('#address_content').html(jsonData.address);
            $('#extraAddress_label').text(jsonData.extraAddress);
            $('#tel_content').html(jsonData.dutyTel1);
            $('#reserve_time_content').html(jsonData.reserveTime);
            $('#symptoms_content').html(jsonData.symptoms);
        },
        error: function (error) {
            console.log("error");
        }
    })
}

function showModal(element) {
    let test = $(element);

    $("#reviewModal").modal('show');
}

function setModal() {
    let dutyName = $('#review_dutyName').val();
    let hpid = $('#review_hpid').val();

    $('#review_hospital_name').text(dutyName + "은(는) 어떠셨나요 ? 이모티콘을 클릭해주세요");
    $('#review_submit_hpid').val(hpid);
}

function editStatus() {

    //todo : $('#status').setAttribute 예약 취소 and deleteHandler

}