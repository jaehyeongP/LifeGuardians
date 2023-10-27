package lg.sqlsession;

import lg.board.BoardDao;
import lg.hospital.HospitalDao;
import lg.medicine.MedicineDao;
import lg.member.MemberDao;
import lg.reply.ReplyDao;
import lg.reservation.ReservationDao;
import lg.review.ReviewDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class Factory {
    private static SqlSessionFactory sqlSessionFactory;
    // 초기화 블록:멤버 변수 초기화하는 블록
    static {
        try {
            String resource = "/config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
//			log.info(reader.toString());
            if (sqlSessionFactory == null) {
                //sqlSessionFactory 객체 생성
                //Builder: 객체 생성에 필요한 설정이 가능하고 설정한 내용으로 객체를 생성해줌
                //build(): config.xml의 내용을 설정에 활용하여 설정함
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

                //구현할 맵퍼 등록
                Class[] mapper = { MemberDao.class , ReviewDao.class, HospitalDao.class, MedicineDao.class,
                                    ReservationDao.class,BoardDao.class, ReplyDao.class};
                for (Class m : mapper) {
                    //sqlSessionFactory에 맵퍼를 등록
                    sqlSessionFactory.getConfiguration().addMapper(m);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }


}
