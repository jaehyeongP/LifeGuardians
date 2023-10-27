const btn_reply = document.getElementById("btn_reply");
const replyList = document.getElementById("replyList");


btn_reply.addEventListener("click", () => {
    
    const board_id = document.getElementById("board_id").value;
    const reply_content = document.getElementById("reply_content").value;

    $.ajax({
        type: "POST",
        url: "/api/reply/add.do",
        dataType: 'json',
        data: {
            "board_id": board_id,
            "reply_content": reply_content
        },
        success: function(data) {
            alert("댓글 등록 완료");
            location.reload();


            
        },
        error: function(error) {
            btn_reply.disabled=false;
            alert("병원 유저만 댓글 작성이 가능합니다.");
        },
    });
});