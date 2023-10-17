package lg.review;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewDao {
    @Insert("insert into review values(seq_review_id_nextval, #{rate} , #{content} , sysdate, #{hpid},#{member_id} )")

    void insert(Review r);

    @Select("select * from review")
    ArrayList<Review> selectAll();

    @Select("select * from review where member_id=#{member_id} ")
    Review selectByMemberId(@Param("member_id") int member_id);

    @Select("select * from review where hpid=#{hpid}")
    ArrayList<Review> selectByHpid(@Param("hpid") String hpid);
    @Select("select * from review where rate=#{rate}")
    ArrayList<Review> selectByRate(@Param("rate") int rate);

    @Select("select * from review where hpid = #{hpid} and rate = #{rate}")
    ArrayList<Review> selectByHpidAndRate(@Param("hpid") String hpid, @Param("rate") int rate);

    @Select("SELECT rate, COUNT(*) as review_Count, (SELECT AVG(rate) FROM review WHERE hpid = #{hpid} AND rate = r.rate) as average_rate FROM review r WHERE hpid = #{hpid} GROUP BY rate")
    List<Map<String, Object>> selectRateCountsAndAverage(@Param("hpid") String hpid, @Param("rate") int rate );
    @Update("update review set rate=#{rate} where review_id=#{review_id} ")
    void updateByRate(Review review);
    @Delete("delete from review where member_id=#{member_id}")
    void delete(@Param("member_id") int member_id);


}
