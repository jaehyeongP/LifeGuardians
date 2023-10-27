
// 병원 상세페이지에서 예약하기 -> 예약창 로드
window.onload = function (){

    try {
        const responseStr = localStorage.getItem("responseJSON");
        const rs = JSON.parse(responseStr);
        let hpidid = rs.hpid;
        let hpdutyName = rs.dutyName;
        $('#dutyName').attr('value', hpdutyName);

        let rsName = rs.name;
        $('#name').attr('value', rsName);

        $('#hpid_for_reserve').attr('value', hpidid);
        // localStorage에 저장된 객체 삭제
        localStorage.removeItem("responseJSON");
    } catch (e) {
    }

}
