package lg.handler.hospital;

import lg.handler.Handler;
import lg.review.Review;
import lg.review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReviewHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if (request.getMethod().equals("GET")) {
            page = "/page/hospital/review_add.jsp";
        } else {

            String hpid = request.getParameter("hpid");
            int rate = Integer.parseInt(request.getParameter("rate"));
            int member_id= Integer.parseInt((String) request.getSession().getAttribute("member_id"));

            String parameter = request.getParameter("tagContent[]");

//            Object username = request.getSession().getAttribute("username");
//            String test = (String) username;
//            Integer.parseInt(test);
//
            ReviewService reviewservice = new ReviewService();
            //service.addReview(new Review(0, rate, content,null,hpid,member_id));
            reviewservice.addReview(Review.builder().rate(rate).hpid(hpid).member_id(member_id).build());
        }
        return page;
    }

}
