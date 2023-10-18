package lg.board;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface BoardDao {
    @Insert("insert into board values (seq_board.NEXTVAL, #{member_id}, #{title}, #{content})")
    void insert(Board board);

    @Select("select * from board order by board_id desc")
    ArrayList<Board> selectAll();

    @Select("select * from board where board_id=#{board_id}")
    Board select(@Param("board_id")int board_id);

    @Update("update board set title=#{title}, content=#{content} where member_id=#{member_id}")
    void update(Board board);

    @Delete("delete from board where board_id=#{board_id} and member_id=#{member_id}")
    void delete(@Param("board_id") int board_id, @Param("member_id") int member_id);
}
