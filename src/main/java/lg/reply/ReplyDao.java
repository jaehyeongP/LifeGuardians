package lg.reply;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface ReplyDao {
    @Insert("insert into reply values(seq_reply.NEXTVAL, #{board_id}, #{hpid}, #{reply_content}, #{dutyName})")
    void insert(Reply reply);

    @Select("select * from reply where board_id=#{board_id} order by reply_id asc")
    ArrayList<Reply> selectAll(@Param("board_id") int board_id);

    @Update("update reply set reply_content=#{reply_content} where hpid=#{hpid}")
    void update(Reply reply);

    @Delete("delete from reply where reply_id=#{reply_id} and hpid=#{hpid}")
    void delete(@Param("reply_id") int reply_id, @Param("hpid") String hpid);
}
