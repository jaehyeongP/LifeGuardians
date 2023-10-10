package lg.handler.account;

import lg.handler.Handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/account/login.jsp";
        } else {


        }

        return page;
    }
}
