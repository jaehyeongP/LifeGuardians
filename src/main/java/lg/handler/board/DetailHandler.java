package lg.handler.board;

import lg.board.Board;
import lg.board.BoardService;
import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";
        if(req.getMethod().equals("GET")){
            page = "/page/board/detail.jsp";

            int board_id = Integer.parseInt(req.getParameter("board_id"));
            BoardService boardService = new BoardService();

            Board board = boardService.getBoard(board_id);
            System.out.println(board);
            req.setAttribute("board", board);
        }

        return page;
    }
}
