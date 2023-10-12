package lg.hospital;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder

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
