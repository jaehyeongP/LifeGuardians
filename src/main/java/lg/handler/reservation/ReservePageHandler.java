package lg.handler.reservation;

import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReservePageHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")){
            page = "/page/reservation/reserve.jsp";
        }
        return page;
    }
}
