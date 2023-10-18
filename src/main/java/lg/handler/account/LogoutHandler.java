package lg.handler.account;

import lg.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            HttpSession session = request.getSession();
            Object username = session.getAttribute("username");

            if(username != null) {      //로그인 상태이면
                session.setAttribute("member_id", null);
                session.setAttribute("hp_id", null);
                session.setAttribute("username", null);
            }
        }
        return "redirect:/";
    }
}
