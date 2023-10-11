package lg.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    private String member_id;
    private String username;
    private String password;
    private String name;
    private String idNumber;
    private String sex;
    private String email;
    private String tel;
    private Date genDate;
    private Date editDate;
}
