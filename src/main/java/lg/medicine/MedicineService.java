package lg.medicine;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;

public class MedicineService {
    private SqlSessionFactory sqlSessionFactory;

    public MedicineService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addMedicine(Medicine medicine){
        SqlSession session = sqlSessionFactory.openSession();
        MedicineDao dao = session.getMapper(MedicineDao.class);

        dao.insert(medicine);

        session.commit();
        session.close();
    }

    public ArrayList<Medicine> getAll(int member_id){
        SqlSession session = sqlSessionFactory.openSession();
        MedicineDao dao = session.getMapper(MedicineDao.class);

        ArrayList<Medicine> list = dao.selectAll(member_id);
        session.close();

        return list;
    }

    public Medicine getMedicine(int medicine_id, int member_id){
        SqlSession session = sqlSessionFactory.openSession();
        MedicineDao dao = session.getMapper(MedicineDao.class);

        Medicine medicine = dao.select(medicine_id, member_id);
        session.close();

        return medicine;
    }

    public void updateMedicine(Medicine medicine){
        SqlSession session = sqlSessionFactory.openSession();
        MedicineDao dao = session.getMapper(MedicineDao.class);

        dao.update(medicine);
        session.commit();
        session.close();
    }

    public void deleteMedicine(int medicine_id){
        SqlSession session = sqlSessionFactory.openSession();
        MedicineDao dao = session.getMapper(MedicineDao.class);

        dao.delete(medicine_id);
        session.commit();
        session.close();
    }
}
