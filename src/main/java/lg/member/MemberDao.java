package lg.member;

import lombok.Setter;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface MemberDao {

    @Insert("insert into member values (#{loginid}, #{password}, #{idNumber}, #{sex}, #{tel}, sysdate)")
    void insert(Member member);

    @Select("select * from member")
    List<Member> selectAll();

    @Select("select * from member where loginid=#{loginid}")
    Member select(@Param("loginid") String loginid);

    @Update("update member set password=#{password} where loginid=#{loginid}")
    void update(Member member);

    @Delete("delete from member where loginid=#{loginid}")
    void delete(@Param("loginid") String loginid);

}
