package lg.reservation;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ReservationService {
    private SqlSessionFactory sqlSessionFactory;
    public ReservationService(){
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }
    public void addReservation(Reservation reservation){
        SqlSession session = sqlSessionFactory.openSession();
        ReservationDao dao = (ReservationDao) session.getMapper(ReservationDao.class);
        dao.insert(reservation);
        session.commit();
        session.close();
    }
    public List<Reservation> getAll(){
        SqlSession session = sqlSessionFactory.openSession();
        ReservationDao dao = (ReservationDao) session.getMapper(ReservationDao.class);
        List<Reservation> list = dao.selectAll();
        session.close();
        return list;
    }
    public List<Reservation> getReservationByHpid(String hpid){
        SqlSession session = sqlSessionFactory.openSession();
        ReservationDao dao = (ReservationDao) session.getMapper(ReservationDao.class);
        List<Reservation> list = dao.selectByHpid(hpid);
        session.close();
        return list;
    }
    public List<Reservation> getReservationByMember(int member_id){
        SqlSession session = sqlSessionFactory.openSession();
        ReservationDao dao = (ReservationDao) session.getMapper(ReservationDao.class);
        List<Reservation> list = dao.selectByMember(member_id);
        session.close();
        return list;
    }

    public void editReservation(Reservation reservation){
        SqlSession session = sqlSessionFactory.openSession();
        ReservationDao mapper = (ReservationDao) session.getMapper(ReservationDao.class);
        mapper.update(reservation);
        session.commit();
        session.close();
    }

    public void delReservation(int reserve_id){
        SqlSession session = sqlSessionFactory.openSession();
        ReservationDao mapper = (ReservationDao) session.getMapper(ReservationDao.class);
        mapper.delete(reserve_id);
        session.commit();
        session.close();
    }
}
