package lg.reservation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
