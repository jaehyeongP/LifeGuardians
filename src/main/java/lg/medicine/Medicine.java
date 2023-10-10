package lg.medicine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Medicine {
    private int medicine_id;
    private int member_id;
    private Date take_time;
    private String itemSeq;
    private String entpName;
    private String itemName;
    private String efcyQesitm;
    private String useMethodQesitm;
    private String atpnWarnQesitm;
    private String atpnQesitm;
    private String intrcQesitm;
    private String seQesitm;
    private String depositMethodQesitm;
    private String itemImage;

    public Medicine() {}

    public Medicine(int medicine_id, int member_id, Date take_time, String entpName, String itemName, String efcyQesitm, String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm, String depositMethodQesitm, String itemImage) {
        this.medicine_id = medicine_id;
        this.member_id = member_id;
        this.take_time = take_time;
        this.entpName = entpName;
        this.itemName = itemName;
        this.efcyQesitm = efcyQesitm;
        this.useMethodQesitm = useMethodQesitm;
        this.atpnWarnQesitm = atpnWarnQesitm;
        this.atpnQesitm = atpnQesitm;
        this.intrcQesitm = intrcQesitm;
        this.seQesitm = seQesitm;
        this.depositMethodQesitm = depositMethodQesitm;
        this.itemImage = itemImage;
    }

    public Medicine(String itemSeq, String entpName, String itemName, String efcyQesitm, String useMethodQesitm, String atpnWarnQesitm, String atpnQesitm, String intrcQesitm, String seQesitm, String depositMethodQesitm, String itemImage) {
        this.itemSeq = itemSeq;
        this.entpName = entpName;
        this.itemName = itemName;
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
