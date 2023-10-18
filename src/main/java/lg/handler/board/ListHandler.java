package lg.handler.board;

import lg.board.Board;
import lg.board.BoardService;
import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class ListHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";
        if(req.getMethod().equals("GET")){
            page = "/page/board/list.jsp";

            BoardService boardService = new BoardService();
            ArrayList<Board> list = boardService.getAll();

            req.setAttribute("list", list);
        }
        return page;
    }
}
