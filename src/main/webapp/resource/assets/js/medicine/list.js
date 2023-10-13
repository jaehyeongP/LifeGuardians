const btn_search = document.getElementById("btn_search");

window.onload = function() {
    $.ajax({
        type: "GET",
        url: "/api/DrbEasyDrugInfoService.do",
        contentType: "application/json",
        dataType: "json",

        success: function(jsonData){
            let tag = '';

            for(let i=0; i<jsonData.length; i++){
                if(jsonData[i].itemImage == null){
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
                        <div class="card-body">
                            <h5 class="card-title">${jsonData[i].itemName}</h5>
                            <p class="card-text">${jsonData[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
                else {
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <img src="${jsonData[i].itemImage}" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${jsonData[i].itemName}</h5>
                            <p class="card-text">${jsonData[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
            }
            medicineList.innerHTML = tag;
        },
    });
}

btn_search.addEventListener("click", () => {
    const search_type = document.getElementById("search_type").value;
    const search_keyword = document.getElementById("search_keyword").value;

    $.ajax({
        type: "GET",
        url: "/api/DrbEasyDrugInfoService.do",
        dataType: "json",
        data: {
            "search_keyword": search_keyword,
            "search_type": search_type
        }, 
        success: function(jsonData){
            console.log(search_keyword, search_type);
            let tag = '';

            for(let i=0; i<jsonData.length; i++){
                if(jsonData[i].itemImage == null){
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
                        <div class="card-body">
                            <h5 class="card-title">${jsonData[i].itemName}</h5>
                            <p class="card-text">${jsonData[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
                else {
                    tag += 
                    `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <img src="${jsonData[i].itemImage}" class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">${jsonData[i].itemName}</h5>
                            <p class="card-text">${jsonData[i].efcyQesitm}</p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=${jsonData[i].itemName}">상세보기</a>
                        </div>
                    </div>
                    `;
                }
            }
            medicineList.innerHTML = tag;
        },
    });
})
