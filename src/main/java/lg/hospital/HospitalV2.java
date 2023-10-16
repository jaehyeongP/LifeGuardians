package lg.hospital;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class HospitalV2 {
    private String hpid;
    private String dutyAddr;
    private String dutyDiv;
    private String dutyDivNam;
    private String dutyName;
    private String dutyTel1;
    private String dutyTel3;
    private String wgs84Lon;
    private String wgs84Lat;
    private String dutyInf;
}
