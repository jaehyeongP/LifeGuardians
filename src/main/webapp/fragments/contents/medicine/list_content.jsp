<%--
  Created by IntelliJ IDEA.
  User: chaewon
  Date: 2023/10/10
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section>
  <div class="container">

    <div class="row mb-5 text-center">

      <form id="search_form" class="px-5" method="get">
        <div class="input-group">                   
          <select id="search_type" class="form-select" name="search_type">
            <option value="medicine_name">약이름</option>
            <option value="symptom">증상</option>
          </select>
          <input type="text" id="search_keyword" class="form-control" name="search_keyword" placeholder="약 검색" style="width: 50%;">
          <input type="button" id="btn_search" class="btn btn-primary" value="검색">
        </div>
      </form>

    </div>

    <input id="totalCount"  type="hidden" value="${totalCount}">
    
    <div id="medicineList" class="row"></div>

  </div>
</section>

<section>
  <div class="container">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination"></ul>
    </nav>
</div>
</section>

<script src="/resource/assets/js/jquery.twbsPagination.min.js" type="text/javascript"></script>
<script type="text/javascript">
const medicineList = document.getElementById("medicineList");
let totalCount = document.getElementById("totalCount").value;
let _totalPages = totalCount / 12

const search_type = document.getElementById("search_type").value;
const search_keyword = document.getElementById("search_keyword").value;

if(totalCount % 10 > 0){
	_totalPages++;
}

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
            let tag = '';

            for(let i=0; i<jsonData.length; i++){
                if(jsonData[i].itemImage == null){
                    tag += `
                    <div class="card col-md-3 mb-5 mb-md-0">
                        <h4 style="width: 155px; height: 85px;">이미지가 없어용</h4>
                        <div class="card-body">
                            <h5 class="card-title">
                    `;
                    tag += jsonData[i].itemName;
                    tag += `
                    </h5>
                              <p class="card-text">
                    `;
                    tag += jsonData[i].efcyQesitm;
                    tag += `
                    </p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=
                      `;
                    tag += jsonData[i].itemName;
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
                    tag += jsonData[i].itemImage
                    tag += `
                    " class="card-img-top">
                        <div class="card-body">
                            <h5 class="card-title">
                    `;
                    tag += jsonData[i].itemName;
                    tag += `
                    </h5>
                              <p class="card-text">
                    `;
                    tag += jsonData[i].efcyQesitm;
                    tag += `
                    </p>
                            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            </div>
                        </div>
                        <div class="card-footer">
                        <a class="btn btn-outline-primary" href="/medicine/detail.do?itemName=
                      `;
                    tag += jsonData[i].itemName;
                    tag += `
                    ">상세보기</a>
                        </div>
                    </div>
                    `;
                }
            }
            medicineList.innerHTML = tag;
          },
        });
    }
});
</script>