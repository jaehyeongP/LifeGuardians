
// 병원 상세페이지에서 예약하기 -> 예약창 로드
window.onload = function (){

    try {
        const hospitalStr = localStorage.getItem("hospital");
        const hp = JSON.parse(hospitalStr);
        let hpidid = hp.hpid;
        let hpdutyName = hp.dutyName;
        // console.log(hp);
        // console.log(hpidid);
        // console.log(hp.dutyName);
        $('#dutyName').attr('value', hpdutyName);
        // TODO : 현재 로그인한 환자의 이름을 #username에 집어넣기

        // localStorage에 저장된 hpid, dutyName, hospital객체 삭제
        localStorage.removeItem("hospital");
        console.log(hp);
        console.log(hospitalStr);
    } catch (e) {
        console.log(e);


    }

}
