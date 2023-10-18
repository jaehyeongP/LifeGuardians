package lg.board;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class BoardService {
    private SqlSessionFactory sqlSessionFactory;

    public BoardService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addBoard(Board board){
        SqlSession session = sqlSessionFactory.openSession();
        BoardDao dao = session.getMapper(BoardDao.class);

        dao.insert(board);

        session.commit();
        session.close();
    }

    public ArrayList<Board> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        BoardDao dao = session.getMapper(BoardDao.class);

        ArrayList<Board> list = dao.selectAll();
        session.close();

        return list;
    }

    public Board getBoard(int board_id){
        SqlSession session = sqlSessionFactory.openSession();
        BoardDao dao = session.getMapper(BoardDao.class);

        Board board = dao.select(board_id);
        session.close();
        return board;
    }

    public void editBoard(Board board){
        SqlSession session = sqlSessionFactory.openSession();
        BoardDao dao = session.getMapper(BoardDao.class);

        dao.update(board);
        session.commit();
        session.close();
    }

    public void deleteBoard(int board_id, int member_id){
        SqlSession session = sqlSessionFactory.openSession();
        BoardDao dao = session.getMapper(BoardDao.class);

        dao.delete(board_id, member_id);
        session.commit();
        session.close();
    }
}
