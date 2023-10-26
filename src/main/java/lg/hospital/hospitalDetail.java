package lg.hospital;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class hospitalDetail {
    private String hpid;
    private String dutyName;
    private String dutyAddr;
    private String dutyTel1;
    private String dutyTel3;
    private String dgidIdName;
    private List<String> startTime;
    private List<String> endTime;
}
