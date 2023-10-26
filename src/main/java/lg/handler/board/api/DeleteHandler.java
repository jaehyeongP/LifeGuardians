package lg.handler.board.api;

import lg.board.BoardService;
import lg.handler.Handler;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {

        if(req.getMethod().equals("POST")){
            int member_id = (int) req.getSession().getAttribute("member_id");
            int board_id = Integer.parseInt(req.getParameter("board_id"));

            BoardService boardService = new BoardService();
            boardService.deleteBoard(board_id, member_id);

            try {
                res.getWriter().write(JsonMapper.objectToJson("test"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
