package lg.handler.hospital.api;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import lg.handler.Handler;
import lg.review.Review;
import lg.review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddReviewHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("POST")) {

            String path = "/";
            int size = 100 * 1024;
            try {
                //멀티파트 => 여러타입의 객체를 받아서 사용하게 해줍니다.
                MultipartRequest multipartRequest = new MultipartRequest(request, path, size, "utf-8", new DefaultFileRenamePolicy());
                String hpid = multipartRequest.getParameter("hpid");
                int rate = Integer.parseInt(multipartRequest.getParameter("rate"));
                int member_id=  (int) request.getSession().getAttribute("member_id");

                //          String parameter = request.getParameter("tagContent[]");

//            Object username = request.getSession().getAttribute("username");
//            String test = (String) username;
//            Integer.parseInt(test);
//
                System.out.println("@@@"+rate);
                ReviewService reviewservice = new ReviewService();
                //service.addReview(new Review(0, rate, content,null,hpid,member_id));
                reviewservice.addReview(Review.builder().rate(rate).hpid(hpid).member_id(member_id).build());








            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        return null;
    }

}
