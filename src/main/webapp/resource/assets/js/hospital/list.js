window.onload = function () {
    navermap("127.1093955", "37.3388728");
    createTableTitle();
    callAjax();
}

function callAjax() {
    $.ajax({
        type: "GET",
        url: "/api/hospital/list/getHsptlMdcncLcinfoInqire.do",
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
    let addressTitleTh = $('<th>').prop({innerHTML: "분류"});
    let extraAddressTitleTh = $('<th>').prop({innerHTML: "상세보기"});
    let telTitleTh = $('<th>').prop({innerHTML: "전화 번호"});

    tableTitle.append(dutyNameTitleTh);
    tableTitle.append(telTitleTh);
    tableTitle.append(addressTitleTh);
    tableTitle.append(extraAddressTitleTh);
    tbody.prepend(tableTitle);
}

function createTableData(data) {
    let hpid = data.hpid;

    let tr = $('<tr>').prop({id: hpid}).on('click', function () {selectHP(this)});
    let dutyNameTd = $('<td>').prop({id: hpid + "_dutyName", innerHTML: data.dutyName});
    let dutyDivNameTd = $('<td>').prop({id:"extra", innerHTML:data.dutyDivName});
    let dutyTel1Td = $('<td>').prop({id: hpid + "_dutyTel1", innerHTML: data.dutyTel1});
    let address = $('<input>').prop({id: hpid + "_address", type: 'hidden', value: data.address});
    let latitudeTd = $('<input>').prop({id: hpid + "_latitude", type: 'hidden', value: data.latitude});
    let longitudeTd = $('<input>').prop({id: hpid + "_longitude", type: 'hidden', value: data.longitude});
    let detailBtn = $('<div>')
        .prop({id:hpid+ "_detail_btn", class: "btn btn-outline-primary", innerHTML: "자세히 보기"})
        .on('click', function () {showModal(this)});

    tr.append(dutyNameTd);
    tr.append(dutyTel1Td);
    tr.append(dutyDivNameTd);
    tr.append(address);
    tr.append(latitudeTd);
    tr.append(longitudeTd);
    tr.append(detailBtn);

    return tr;
}

function selectHP(element) {
    let hpid = $(element).attr('id');
    let address = $(element).find('#'+ hpid + '_address').val();
    let latitude = $(element).find('#'+ hpid + '_latitude').val();
    let longitude = $(element).find('#'+ hpid + '_longitude').val();

    $('#map_address').text(address);
    getHospitalDetailByJson(hpid);
    getReviewAvg(hpid);
    navermap(latitude, longitude);

    console.log(hpid);
    console.log(address);
    console.log(latitude);
    console.log(longitude);
}

function showModal(e) {
    $("#reservationModal").modal('show');
}

