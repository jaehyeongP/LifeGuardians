package lg.member;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberDao {

    @Insert("insert into members values (seq_members.nextval, #{username}, #{password}, #{email}, #{name}, #{firstRegNum}, #{lastRegNum}, #{gender}, #{tel}, #{address}, #{extraAddress}, sysdate, sysdate)")
    void insert(Member member);

    @Select("select * from members")
    List<Member> selectAll();

    @Select("select * from members where member_id = #{memberId}")
    Member selectById(@Param("memberId") int memberId);

    @Select("select * from members where name=#{name}")
    List<Member> selectByName(@Param("name") String name);

    @Select("select * from members where username=#{username}")
    Member selectByUsername(@Param("username") String username);

    @Update("update members set password=#{password} where username=#{username}")
    void update(Member member);

    @Delete("delete from members where username=#{username}")
    void delete(@Param("username") String username);

}
