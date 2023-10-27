package lg.medicine;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Medicine {
    private int medicine_id;
    private int member_id;
    private String take_time;
    private String itemName;
    private String entpName;
    private String efcyQesitm;
    private String useMethodQesitm;
    private String atpnWarnQesitm;
    private String atpnQesitm;
    private String intrcQesitm;
    private String seQesitm;
    private String depositMethodQesitm;
    private String itemImage;

    public Medicine() {}

    public Medicine(int medicine_id, int member_id, String take_time, String itemName, String entpName, String efcyQesitm, String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm, String depositMethodQesitm, String itemImage) {
        this.medicine_id = medicine_id;
        this.member_id = member_id;
        this.take_time = take_time;
        this.itemName = itemName;
        this.entpName = entpName;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
        this.atpnWarnQesitm = atpnWarnQesitm;
        this.atpnQesitm = atpnQesitm;
        this.intrcQesitm = intrcQesitm;
        this.seQesitm = seQesitm;
        this.depositMethodQesitm = depositMethodQesitm;
        this.itemImage = itemImage;
    }
}
