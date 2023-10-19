function edit(medicine_id){
    let take_time = prompt("메모할 내용을 입력해주세요");

    $.ajax({
        type: "POST",
        url: "/medicine/mypage.do",
        dataType:'json',
        data: {
            "medicine_id": medicine_id,
            "take_time": take_time
        },
        success: function(jsonData) {
            alert("메모가 수정되었습니다.");
            window.location.href = "/medicine/mypage.do";

        },
        error: function(error){
            alert("복용시간 변경 실패" + JSON.stringify(error.responseJSON));
        }
    });
}

function del(medicine_id){
    if(!confirm("내 약에서 삭제하시겠습니까?")){
        alert("삭제가 취소되었습니다.");
        return;
    }

    $.ajax({
        type: "POST",
        url: "/medicine/delete.do",
        data: {
            "medicine_id": medicine_id
        },
        success: function(){
            alert("삭제가 완료되었습니다.");
            window.location.reload;
        },
        error: function(error){
            alert("삭제 실패" + JSON.stringify(error.responseJSON));
        }
    });
}

function detail(itemName){
    location.href = "/medicine/detail.do?itemName="+itemName;
}