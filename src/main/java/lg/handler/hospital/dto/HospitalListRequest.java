package lg.handler.hospital.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Builder
public class HospitalListRequest {
    private String hpid;
    private String dutyName;
    private String latitude;
    private String longitude;
    private Double distance;

}
