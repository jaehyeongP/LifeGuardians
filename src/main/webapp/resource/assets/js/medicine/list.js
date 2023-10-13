const btn_search = document.getElementById("btn_search");
const medicineList = document.getElementById("medicineList");
let totalCount = 4789;
let _totalPages = Math.ceil(totalCount / 12); // 400

var search_type = document.getElementById("search_type").value;
var search_keyword = document.getElementById("search_keyword").value;

window.onload = function() {
    callPagination();
    $.ajax({
        type: "GET",
        url: "/api/DrbEasyDrugInfoService.do",
        contentType: "application/json",
        dataType: "json",

        success: function(jsonData){
            let tag = '';

            for(let i=0; i<jsonData.list.length; i++){
                if(jsonData.list[i].itemImage == null){
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
                        <div class="card-body">
                            <h5 class="card-title">${jsonData.list[i].itemName}</h5>
                            <p class="card-text">${jsonData.list[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData.list[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
                else {
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <img src="${jsonData.list[i].itemImage}" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${jsonData.list[i].itemName}</h5>
                            <p class="card-text">${jsonData.list[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData.list[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
            }
            medicineList.innerHTML = tag;
        },
        error: function(error){
            console.log(error);
        }
    });
}

btn_search.addEventListener("click", () => {
    search_keyword = document.getElementById("search_keyword").value;
    search_type = document.getElementById("search_type").value;
    $.ajax({
        type: "GET",
        url: "/api/DrbEasyDrugInfoService.do",
        dataType: "json",
        data: {
            "search_keyword": search_keyword,
            "search_type": search_type
        }, 
        success: function(jsonData){
            let tag = '';
            totalCount = parseInt(jsonData.totalCount);
            _totalPages = Math.ceil(totalCount / 12);

            for(let i=0; i<jsonData.list.length; i++){
                if(jsonData.list[i].itemImage == null){
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
                        <div class="card-body">
                            <h5 class="card-title">${jsonData.list[i].itemName}</h5>
                            <p class="card-text">${jsonData.list[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData.list[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
                else {
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <img src="${jsonData.list[i].itemImage}" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${jsonData.list[i].itemName}</h5>
                            <p class="card-text">${jsonData.list[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData.list[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
            }
            medicineList.innerHTML = tag;
            $("#pagination").twbsPagination("changeTotalPages", _totalPages, 1);
        },
    });
})

if(totalCount % 10 > 0){
	_totalPages++;
}

function callPagination() {
    _totalPages = Math.ceil(totalCount / 12);

    $('#pagination').twbsPagination({
        totalPages: _totalPages,
        visiblePages: 5,
        startPage : 1,
        initiateStartPageClick: false,
        first : "처음",
        prev : "이전",
        next : "다음",
        last : "마지막",
        nextClass : "page-item next",
        prevClass : "page-item prev",
        lastClass : "page-item last",
        firstClass : "page-item first",
        pageClass : "page-item",
        activeClass : "active",
        disabledClass : "disabled",
        anchorClass : "page-link",
    
        onPageClick: function (event, page) {

            $.ajax({
              type: "GET",
              url: "/api/DrbEasyDrugInfoService.do",
              dataType: "json",
              data: {
                  "search_keyword": search_keyword,
                  "search_type": search_type,
                  "pageNo": page
              }, 
              success: function(jsonData){
                totalCount = parseInt(jsonData.totalCount);
                let tag = '';
    
                for(let i=0; i<jsonData.list.length; i++){
                    if(jsonData.list[i].itemImage == null){
                        tag += `
                        <div class="card col-md-3 mb-5 mb-md-0">
                            <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
                            <div class="card-body">
                                <h5 class="card-title">
                        `;
                        tag += jsonData.list[i].itemName;
                        tag += `
                        </h5>
                                  <p class="card-text">
                        `;
                        tag += jsonData.list[i].efcyQesitm;
                        tag += `
                        </p>
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                </div>
                            </div>
                            <div class="card-footer">
                            <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=
                          `;
                        tag += jsonData.list[i].itemName;
                        tag += `
                        ">상세보기</a>
                            </div>
                        </div>
                        `;
                    }
                    else {
                        tag += `
                        <div class="card col-md-3 mb-5 mb-md-0">
                            <img src="
                        `;
                        tag += jsonData.list[i].itemImage
                        tag += `
                        " class="card-img-top">
                            <div class="card-body">
                                <h5 class="card-title">
                        `;
                        tag += jsonData.list[i].itemName;
                        tag += `
                        </h5>
                                  <p class="card-text">
                        `;
                        tag += jsonData.list[i].efcyQesitm;
                        tag += `
                        </p>
                                <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                                </div>
                            </div>
                            <div class="card-footer">
                            <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=
                          `;
                        tag += jsonData.list[i].itemName;
                        tag += `
                        ">상세보기</a>
                            </div>
                        </div>
                        `;
                    }
                }
                medicineList.innerHTML = tag;
              }
            });
        }
    });
}