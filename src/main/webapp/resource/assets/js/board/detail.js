const btn_delete = document.getElementById("btn_delete");

btn_delete.addEventListener("click", () => {
    if (!confirm("글을 삭제하시겠습니까?")) {
        alert("취소되었습니다.")
        return;
    }

    else {
        const board_id = document.getElementById("board_id").value;
        console.log(board_id);
        $.ajax({
            type: "POST",
            url: "/board/delete.do",
            dataType: 'json',
            data: {
                "board_id": board_id
            },
            success: function(data) {
                alert("삭제가 완료되었습니다.");
                location.href = "/board/list.do";
            },
            error: function(error) {
                btn_delete.disabled=false;
                alert("글 삭제 실패: " + JSON.stringify(error.responseJSON));
            },
        });
    }
})