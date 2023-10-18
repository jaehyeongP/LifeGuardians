package lg.reply;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class ReplyService {
    private SqlSessionFactory sqlSessionFactory;

    public ReplyService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addReply(Reply reply){
        SqlSession session = sqlSessionFactory.openSession();
        ReplyDao dao = session.getMapper(ReplyDao.class);

        dao.insert(reply);

        session.commit();
        session.close();
    }

    public ArrayList<Reply> getAll(int board_id) {
        SqlSession session = sqlSessionFactory.openSession();
        ReplyDao dao = session.getMapper(ReplyDao.class);

        ArrayList<Reply> list = dao.selectAll(board_id);
        session.close();

        return list;
    }

    public void editReply(Reply reply){
        SqlSession session = sqlSessionFactory.openSession();
        ReplyDao dao = session.getMapper(ReplyDao.class);

        dao.update(reply);

        session.commit();
        session.close();
    }

    public void deleteReply(int reply_id, String hpid){
        SqlSession session = sqlSessionFactory.openSession();
        ReplyDao dao = session.getMapper(ReplyDao.class);

        dao.delete(reply_id, hpid);

        session.commit();
        session.close();
    }
}
