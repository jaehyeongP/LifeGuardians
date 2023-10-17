package lg.review;

import lg.sqlsession.Factory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReviewService {

    private SqlSessionFactory sqlSessionFactory;

    public ReviewService() {
        sqlSessionFactory = Factory.getSqlSessionFactory();
    }

    public void addReview(Review review) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        dao.insert(review);
        session.commit();
        session.close();

    }

    public ArrayList<Review> getAll() {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<Review> list = dao.selectAll();
        session.close();
        return list;
    }

    public Review getReviewMember(String member_id) {
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        Review review = dao.selectByMemberId(Integer.parseInt(member_id));
        session.close();
        return review;
    }
    public ArrayList<Review> getReviewHpid(String hpid){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<Review> list = dao.selectByHpid(hpid);
        session.close();
        return list;
    }

    public ArrayList<Review> getRate(int rate){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        ArrayList<Review> list = dao.selectByRate(rate);
        session.close();
        return list;
     }


    public List<Map<String, Object>> getRateCountsAndAverage(String hpid){
       SqlSession session = sqlSessionFactory.openSession();
      ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
//        Map<String, Object> result = dao.selectRateCountsAndAverage(hpid, 5);
        List<Map<String, Object>> result = dao.selectRateCountsAndAverage(hpid, 5);
//        Map<String, Object> result2 = dao.selectRateCountsAndAverage(hpid, 3);
        List<Map<String, Object>> result2 = dao.selectRateCountsAndAverage(hpid, 3);

       System.out.println("!!!");
       System.out.println(result);
       System.out.println(result2);


      session.close();
       return result;
    }




    public void eidtReviewByRate(Review r){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        dao.updateByRate(r);
        session.commit();
        session.close();

    }
    public void delReview(int memberId){
        SqlSession session = sqlSessionFactory.openSession();
        ReviewDao dao = (ReviewDao) session.getMapper(ReviewDao.class);
        dao.delete(memberId);
        session.commit();
        session.close();
    }


    public ArrayList<Review> getReviewHpidAndRate(String hpid, int rate) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ReviewDao reviewDao = sqlSession.getMapper(ReviewDao.class);
        ArrayList<Review> list = reviewDao.selectByHpidAndRate(hpid, rate);
        sqlSession.close();
        return list;
    }
}
