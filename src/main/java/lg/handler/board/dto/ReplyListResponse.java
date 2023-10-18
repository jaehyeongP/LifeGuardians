package lg.handler.board.dto;

import lg.reply.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class ReplyListResponse {
    private String board_id;
    private ArrayList<Reply> reply;
}
