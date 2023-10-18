package lg.handler.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class ReservationListResponse {
    private String hpid;
//    private String username;
    private String dutyName;
    private String dutyDivName;
    private String dutyTel1;
    private String address;
    private String extraAddress;
    private String reserveTime;
    private String symptoms;
    private String status;
    private String reserveId;

//    List<HospitalListResponse> hpInfo = new ArrayList<>();
}
