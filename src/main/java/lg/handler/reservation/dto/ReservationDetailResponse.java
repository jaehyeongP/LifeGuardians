package lg.handler.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
public class ReservationDetailResponse {
    private String hpid;
    private String dutyName;
    private String member_id;
    private String username;
    private String name;


}
