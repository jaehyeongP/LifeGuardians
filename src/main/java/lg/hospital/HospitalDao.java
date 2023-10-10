package lg.hospital;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HospitalDao {
    
    @Insert("insert into Hospital values(#{hpid}, #{username}, #{password}, #{email}, #{address}, #{dutyName}, #{dutyDivName}, #{latitude}, #{longitude}, #{dutyTel1}, #{startTime}, #{endTime}, sysdate, sysdate)")
    void insert(Hospital hospital);
    @Select("select * from Hospital")
    List<Hospital> selectAll();
    @Select("select * from Hospital where hpid=#{hpid}")
    Hospital selectByHpid(@Param("hpid") String hpid);
    @Select("select * from Hospital where dutyName=#{dutyName}")
    List<Hospital> selectByDutyName(@Param("dutyName") String dutyName);
    @Update("update Hospital set username=#{username}, password=#{password}, email=#{email} where hpid=#{hpid}")
    void update(Hospital hospital);
    @Delete("delete from Hospital where hpid=#{hpid}")
    void delete(@Param("hpid") String hpid);
}
