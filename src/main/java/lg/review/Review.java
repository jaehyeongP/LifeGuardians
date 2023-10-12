package lg.review;

import java.util.Date;



public class Review {
    private int review_id;
    private int rate;
    private String content;
    private Date getDate;
    private String hpid;
    private String member_id;


    public Review(){

    }

    public Review(int review_id, int rate, String content, Date getDate, String hpid, String member_id) {
        this.review_id = review_id;
        this.rate = rate;
        this.content = content;
        this.getDate = getDate;
        this.hpid = hpid;
        this.member_id = member_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public String getHpid() {
        return hpid;
    }

    public void setHpid(String hpid) {
        this.hpid = hpid;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    @Override
    public String toString() {
        return "Review{" +
                "review_id=" + review_id +
                ", rate=" + rate +
                ", content='" + content + '\'' +
                ", getDate=" + getDate +
                ", hpid='" + hpid + '\'' +
                ", member_id='" + member_id + '\'' +
                '}';
    }
}

