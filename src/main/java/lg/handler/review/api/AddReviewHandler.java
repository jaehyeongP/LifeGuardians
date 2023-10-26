package lg.handler.review.api;

import lg.handler.Handler;
import lg.review.Review;
import lg.review.ReviewService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddReviewHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("POST")) {
            String hpid = request.getParameter("hpid");
            int rate = Integer.parseInt(request.getParameter("rate"));
            int member_id = Integer.parseInt(request.getSession().getAttribute("member_id").toString());

            ReviewService reviewservice = new ReviewService();

            reviewservice.addReview(Review.builder().rate(rate).hpid(hpid).member_id(member_id).build());

            Map<String, Object> map = new HashMap<>();
            map.put("status", "ok");
            String json = JsonMapper.objectToJson(map);

            try {
                response.getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
