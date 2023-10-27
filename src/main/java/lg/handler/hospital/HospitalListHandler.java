package lg.handler.hospital;

import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospitalListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/hospital/list.jsp";
        }

        return page;
    }
}
