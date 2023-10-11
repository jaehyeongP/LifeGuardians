package lg.member;

import lombok.Setter;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;

@Mapper
public interface MemberDao {

    @Insert("insert into members values (seq_members.nextval, #{username}, #{password}, #{name}, #{idNumber}, #{sex}, #{email}, #{tel}, sysdate, sysdate)")
    void insert(Member member);

    @Select("select * from members")
    List<Member> selectAll();

    @Select("select * from members where name=#{name}")
    List<Member> selectByName(@Param("name") String name);

    @Select("select * from members where username=#{username}")
    Member selectByUsername(@Param("username") String username);

    @Update("update members set password=#{password} where username=#{username}")
    void update(Member member);

    @Delete("delete from members where username=#{username}")
    void delete(@Param("username") String username);

}
