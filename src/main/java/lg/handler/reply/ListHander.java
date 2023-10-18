package lg.handler.reply;

import lg.board.Board;
import lg.board.BoardService;
import lg.handler.Handler;
import lg.handler.board.dto.ReplyListResponse;
import lg.hospital.HospitalService;
import lg.reply.Reply;
import lg.reply.ReplyService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListHander implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {

        int board_id = Integer.parseInt(req.getParameter("board_id"));
        ReplyService replyService = new ReplyService();
        ArrayList<Reply> reply = replyService.getAll(board_id);

        ReplyListResponse result = ReplyListResponse.builder().board_id(String.valueOf(board_id)).reply(reply).build();

        try {
            res.getWriter().write(JsonMapper.objectToJson(result));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
