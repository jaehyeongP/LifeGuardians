package lg.review;

import lombok.*;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Review {
    private int review_id;
    private String hpid;
    private int member_id;
    private int rate;
    private Date getDate;

}

