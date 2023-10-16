package lg.hospital;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class HospitalService {
    private SqlSessionFactory sqlSessionFactory;

    public HospitalService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addHospitalV2(HospitalV2 hospital) {
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao hospitalDao = session.getMapper(HospitalDao.class);
        hospitalDao.insertV2(hospital);
        session.commit();
        session.close();
    }

    public void addHospital(Hospital hospital){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao dao = (HospitalDao) session.getMapper(HospitalDao.class);
        dao.insert(hospital);
        session.commit();
        session.close();

    }

    public List<Hospital> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao dao = (HospitalDao) session.getMapper(HospitalDao.class);
        List<Hospital> list = dao.selectAll();
        session.close();
        return list;
    }

    public List<HospitalV2> getAllV2() {
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao hospitalDao = session.getMapper(HospitalDao.class);
        List<HospitalV2> list = hospitalDao.selectAllV2();
        return list;
    }

    // hpid로 검색
    public Hospital getHospitalByHpid(String hpid){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao dao = (HospitalDao) session.getMapper(HospitalDao.class);
        Hospital hospital = dao.selectByHpid(hpid);
        session.close();
        return hospital;
    // dutyName으로 검색
    }public List<Hospital> getHospitalByDutyName(String dutyName){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao dao = (HospitalDao) session.getMapper(HospitalDao.class);
        List<Hospital> list = dao.selectByDutyName(dutyName);
        session.close();
        return list;
    }

    public void editHospital(Hospital hospital){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao mapper = (HospitalDao) session.getMapper(HospitalDao.class);
        mapper.update(hospital);
        session.commit();
        session.close();
    }

    public void delHospital(String hpid){
        SqlSession session = sqlSessionFactory.openSession();
        HospitalDao mapper = (HospitalDao) session.getMapper(HospitalDao.class);
        mapper.delete(hpid);
        session.commit();
        session.close();
    }
}
