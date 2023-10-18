package lg.handler.board;

import lg.board.Board;
import lg.board.BoardService;
import lg.handler.Handler;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";
        if(req.getMethod().equals("GET")){
            page = "/page/board/add.jsp";
        } else {
            int member_id = (int) req.getSession().getAttribute("member_id");
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            BoardService boardService = new BoardService();
            boardService.addBoard(new Board(0, member_id, title, content));

            try {
                res.getWriter().write(JsonMapper.objectToJson("test"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;
        }
        return page;
    }
}
