package lg.board;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Board {
    private int board_id;
    private int member_id;
    private String title;
    private String content;

    public Board(){}

    public Board(int board_id, int member_id, String title, String content) {
        this.board_id = board_id;
        this.member_id = member_id;
        this.title = title;
        this.content = content;
    }
}
