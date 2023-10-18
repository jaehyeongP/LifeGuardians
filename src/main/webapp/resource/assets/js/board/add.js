const btn_add = document.getElementById("btn_add");

btn_add.addEventListener("click", () => {
    if (!confirm("글을 작성하시겠습니까?")) {
        alert("취소되었습니다.")
        return;
    }

    else {
        const title = document.getElementById("title").value;
        const content = document.getElementById("content").value;

        $.ajax({
            type: "POST",
            url: "/board/add.do",
            dataType: 'json',
            data: {
                "title": title,
                "content": content,
            },
            success: function(data) {
                alert("글 작성이 완료되었습니다");
                location.href = "/board/list.do";
            },
            error: function(error) {
                btn_add.disabled=false;
                alert("글 작성 실패: " + JSON.stringify(error.responseJSON));
            },
        });
    }
})