package lg.handler.hospital.page;

import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddReviewPageHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if (request.getMethod().equals("GET")) {
            page = "/page/hospital/review_add.jsp"; //이벤트가 발생하면  get 동작 ?
        }
        return page;
    }

}
