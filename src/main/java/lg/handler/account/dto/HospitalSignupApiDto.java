package lg.handler.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class HospitalSignupApiDto {
    private String hpid;
    private String dutyName;
    private String latitude;
    private String longitude;
    private String dutyDivName;
    private String dutyTel1;
    private Double distance;
}
