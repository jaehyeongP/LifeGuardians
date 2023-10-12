package lg.review;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

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

    @Update("update review set rate=#{rate} where review_id=#{review_id} ")
    void updateByRate(Review review);
    @Update("update review set content=#{content} where review_id=#{review_id} ")
    void updateByContent(Review review);

    @Delete("delete from review where member_id=#{member_id}")
    void delete(@Param("member_id") int member_id);
}
