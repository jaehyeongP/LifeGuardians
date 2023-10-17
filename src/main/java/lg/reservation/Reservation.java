package lg.reservation;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Builder
public class Reservation {
    private int reserve_id;
    private int member_id;
    private String hpid;
    private Date reserveTime;
    private String symptoms;
    private String status;
    private Date genDate;
    private Date editDate;

}
