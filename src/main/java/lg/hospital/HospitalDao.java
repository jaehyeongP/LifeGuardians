package lg.hospital;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface HospitalDao {

    @Select("")
    List<Hospital> findAll();
    @Select("")
    Hospital findByHpId(String hpid);


}
