package lg.reply;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Reply {
    private int reply_id;
    private int board_id;
    private String hpid;
    private String reply_content;
    private String dutyName;
}
