package lg.handler.medicine;

import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";

        if(request.getMethod().equals("GET")) {
            page = "/page/medicine/list.jsp";
        }

        return page;
    }
}
