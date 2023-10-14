window.onload = function () {


    let spinner = document.getElementById('spinner');
    spinner.style.visibility = 'visible';

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

        success: function(jsonData){
            console.log(jsonData);

            var hpid = jsonData.hpid;
            var dutyName = jsonData.dutyName;
            var dgidIdName = jsonData.dgidIdName;
            var arrStart = jsonData.startTime;
            var arrEnd = jsonData.endTime;


            $("#test").html(dutyName);



            console.log("hpid: " + hpid);
            console.log("dutyName: " + dutyName);

            let txt ="";
            txt += "<h3>"+"병원 상세정보" + "</h3>";
            txt += "기관 ID : "+ jsonData.hpid+"<br/>";
            txt += "병원이름 : "+ jsonData.dutyName+"<br/>";
            txt += "진료과목 : "+ jsonData.dgidIdName+"<br/>";


            txt += "진료시간" + "<br/>";
            txt += "<div style='border:1px solid blue'>";
            txt += "월요일 : " + arrStart[0] +"~"+ arrEnd[0]+"<br/>";
            txt += "화요일 : " + arrStart[1] +"~"+ arrEnd[1]+"<br/>";
            txt += "수요일 : " + arrStart[2] +"~"+ arrEnd[2]+"<br/>";
            txt += "목요일 : " + arrStart[3] +"~"+ arrEnd[3]+"<br/>";
            txt += "금요일 : " + arrStart[4] +"~"+ arrEnd[4]+"<br/>";
            txt += "토요일 : " + arrStart[5] +"~"+ arrEnd[5]+"<br/>";
            txt += "</div>";


            $("#detail-content").html(txt);
        },
        error:function (error){
            console.log("error");

        }
    });


}