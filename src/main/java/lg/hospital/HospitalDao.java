package lg.hospital;


import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HospitalDao {

    @Insert("insert into HospitalV2 values(#{hpid}, #{dutyAddr}, #{dutyDiv}, #{dutyDivNam}, #{dutyName}, #{dutyTel1}, #{dutyTel3}, #{wgs84Lon}, #{wgs84Lat}, #{dutyInf})")
    void insertV2(HospitalV2 hospital);
    
    @Insert("insert into Hospital values(#{hpid}, #{username}, #{password}, #{email}, #{address}, #{extraAddress}, #{dutyName}, #{dutyDivName}, #{dutyTel1}, #{latitude}, #{longitude}, sysdate, sysdate)")
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

    @Select("select * from HospitalV2")
    List<HospitalV2> selectAllV2();

    @Select("select * from hospital where username = #{username}")
    Hospital selectByUsername(@Param("username") String username);
}
