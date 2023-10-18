package lg.handler.board;

import lg.board.Board;
import lg.board.BoardService;
import lg.handler.Handler;
import lg.reply.Reply;
import lg.reply.ReplyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class DetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";
        if(req.getMethod().equals("GET")){
            page = "/page/board/detail.jsp";

            int board_id = Integer.parseInt(req.getParameter("board_id"));
            BoardService boardService = new BoardService();
            ReplyService replyService = new ReplyService();

            Board board = boardService.getBoard(board_id);
            ArrayList<Reply> reply = replyService.getAll(board_id);

            req.setAttribute("board", board);
            req.setAttribute("reply", reply);
        }

        return page;
    }
}
