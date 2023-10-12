package lg.hospital;

import lg.member.Member;
import lg.member.MemberDao;
import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class HospitalService {
    private SqlSessionFactory sqlSessionFactory;

    public HospitalService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addHospitalUser() {

    }

    public List<Hospital> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao hospitalDao = session.getMapper(HospitalDao.class);
        List<Hospital> list = hospitalDao.findAll();
        session.close();
        return list;
    }

    public Hospital getHospital(String hpid) {
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao hospitalDao = session.getMapper(HospitalDao.class);
        Hospital hospital = hospitalDao.findByHpId(hpid);
        session.close();
        return hospital;
    }

}
