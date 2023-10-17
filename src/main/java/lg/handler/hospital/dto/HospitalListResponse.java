package lg.handler.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Builder
public class HospitalListResponse {
    private String hpid;
    private String dutyName;
    private String address;
    private String extraAddress;
    private String dutyDivName;
    private String dutyTel1;
    private String latitude;
    private String longitude;


}
