package lg.member;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class Member {
    private int member_id;
    private String username;
    private String password;
    private String email;

    private String name;
    private int firstRegNum;
    private int lastRegNum;
    private String gender;
    private String tel;

    private String address;
    private String extraAddress;
    private Date genDate;
    private Date editDate;
}
