package lg.handler.board.dto;

import lg.reply.Reply;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class ReplyAddResponse {
    private String board_id;
    private String hpid;
    private String reply_content;
    private String dutyName;

}
