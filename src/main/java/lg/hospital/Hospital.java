package lg.hospital;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    private String hpid;
    private String username;
    private String password;
    private String email;
    private String address;
    private String dutyName;
    private String dutyDivName;
    private String latitude;
    private String longitude;
    private String dutyTel1;
    private String startTime;
    private String endTime;
    private Date genDate;
    private Date editDate;
}