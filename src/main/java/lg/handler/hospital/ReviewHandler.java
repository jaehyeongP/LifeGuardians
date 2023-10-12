package lg.handler.hospital;

import lg.handler.Handler;
import lg.review.Review;
import lg.review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if (request.getMethod().equals("GET")) {
            page = "/page/hospital/detail.jsp";
        } else {
            int rate = Integer.parseInt(request.getParameter("rate"));
            String content = request.getParameter("content");

            ReviewService service = new ReviewService();
            //Review review = service.getReviewMember(rate);
        }
        return page;
    }

}
