window.onload = function () {
    // 함수를 따로 호출해줘야함
    getHospitalDetailByJson();


}




// 함수를 생성
function getHospitalDetailByJson(){

    $.ajax({
        type:"GET",
        url:"/api/getHsptlBassInfoInqire.do",
        // contentType: "application/json",
        dataType : 'json',

        // success: function (res){
        //     let txt = "";
        //     for(let b of res){
        //         txt += "<div class='c1' id='div_" + b.num + "'>";
        //         txt += "num: "+b.num+"<br/>";
        //         txt += "writer: "+b.writer+"<br/>";
        //         txt += "w_date: "+b.w_date+"<br/>";
        //         txt += "title: "+b.title+"<br/>";
        //         txt += "content: "+b.content+"<br/>";
        //         if('${sessionScope.loginId}' == b.writer){
        //             txt += "<input type='button' value='수정' class='editf'>";
        //             txt += "<input type='button' value='삭제' class='del'>";
        //         }
        //         txt += "</div>";
        //     }
        //     $("#list").html(txt);

        success: function(jsonData){
            console.log(jsonData);

            var hpid = jsonData.hpid;
            var dutyName = jsonData.dutyName;
            var dgidIdName = jsonData.dgidIdName;

            console.log("hpid: " + hpid);
            console.log("dutyName: " + dutyName);

            let txt ="";
            txt += "<h3>"+"병원 상세정보" + "</h3>";
            txt += "기관 ID : "+ jsonData.hpid+"<br/>";
            txt += "병원이름 : "+ jsonData.dutyName+"<br/>";
            txt += "진료과목 : "+ jsonData.dgidIdName+"<br/>";

            txt += "</div>";

            $("#detail-content").html(txt);
        },
        error:function (error){
            console.log("error");

        }
    });


}