package lg.hospital;

import lg.handler.hospital.dto.HospitalListResponse;
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
    private String extraAddress;
    private String dutyName;
    private String dutyDivName;
    private String dutyTel1;
    private String latitude;
    private String longitude;
    private Date genDate;
    private Date editDate;

    public HospitalListResponse toDto() {
        return HospitalListResponse.builder().hpid(hpid).dutyName(dutyName).address(address).extraAddress(extraAddress)
                .dutyDivName(dutyDivName).dutyTel1(dutyTel1).latitude(latitude).longitude(longitude).build();
    }

}
