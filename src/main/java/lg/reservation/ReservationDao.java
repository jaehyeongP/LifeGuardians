package lg.reservation;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReservationDao {
    @Insert("insert into reservations values (seq_reservations.nextval, #{member_id}, #{hpid}, #{reserveTime}, #{symptoms}, #{status}, sysdate, sysdate)")
    void insert(Reservation reservation);
    @Select("select * from reservations")
    List<Reservation> selectAll();
    @Select("select * from reservations where reserve_id=#{reserve_id}")
    Reservation select(@Param("reserve_id") int reserve_id);
    @Select("select * from reservations where member_id=#{member_id}")
    List<Reservation> selectByMember(@Param("member_id") int member_id);
    @Select("select * from reservations where hpid=#{hpid}")
    List<Reservation> selectByHpid(@Param("hpid") String hpid);
    @Update("update reservations set reserveTime=#{reserveTime}, symptoms=#{symptoms} where reserve_id=#{reserve_id}")
    void update(Reservation reservation);
    @Delete("delete from reservations where reserve_id=#{reserve_id}")
    void delete(@Param("reserve_id") int reserve_id);
}
