package lg.member;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MemberService {
    private SqlSessionFactory sqlSessionFactory;

    //todo : password encoding

    public MemberService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addMember(Member member){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);
        dao.insert(member);
        session.commit();
        session.close();
    }

    public List<Member> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);
        List<Member> list = dao.selectAll();
        session.close();
        return list;
    }
    public List<Member> getMemberByName(String name){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);
        List<Member> list = dao.selectByName(name);
        session.close();
        return list;
    }
    public Member getMember(String username){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);
        Member member = dao.selectByUsername(username);
        session.close();
        return member;
    }

    public void editMember(Member member){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao mapper = (MemberDao) session.getMapper(MemberDao.class);
        mapper.update(member);
        session.commit();
        session.close();
    }

    public void delMember(String username){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao mapper = (MemberDao) session.getMapper(MemberDao.class);
        mapper.delete(username);
        session.commit();
        session.close();
    }
}
