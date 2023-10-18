package lg.medicine;

import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

public interface MedicineDao {
    @Insert("insert into medicine values (seq_medicine.NEXTVAL, #{member_id}, #{take_time}, #{itemName}, #{entpName}, #{efcyQesitm}, #{useMethodQesitm}, #{atpnWarnQesitm}, #{atpnQesitm}, #{intrcQesitm}, #{seQesitm}, #{depositMethodQesitm}, #{itemImage})")
    void insert(Medicine medicine);

    @Select("select * from medicine where member_id=#{member_id} order by medicine_id asc")
    ArrayList<Medicine> selectAll(@Param("member_id") int member_id);

    @Select("select * from medicine where medicine_id=#{medicine_id} and member_id=#{member_id}")
    Medicine select(@Param("medicine_id") int medicine_id, @Param("member_id") int member_id);

    @Update("update medicine set take_time=#{take_time} where medicine_id=#{medicine_id} and member_id=#{member_id}")
    void update(Medicine medicine);

    @Delete("delete from medicine where medicine_id=#{medicine_id}")
    void delete(@Param("medicine_id") int medicine_id);
}
