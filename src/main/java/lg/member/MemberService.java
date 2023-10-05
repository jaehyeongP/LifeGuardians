package lg.member;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MemberService {
    private SqlSessionFactory sqlSessionFactory;

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

    public Member getMember(String id){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao dao = (MemberDao) session.getMapper(MemberDao.class);
        Member member = dao.select(id);
        session.close();
        return member;
    }

    public void editMember(Member m){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao mapper = (MemberDao) session.getMapper(MemberDao.class);
        mapper.update(m);
        session.commit();
        session.close();
    }

    public void delMember(String loginid){
        SqlSession session = sqlSessionFactory.openSession();
        MemberDao mapper = (MemberDao) session.getMapper(MemberDao.class);
        mapper.delete(loginid);
        session.commit();
        session.close();
    }
}
