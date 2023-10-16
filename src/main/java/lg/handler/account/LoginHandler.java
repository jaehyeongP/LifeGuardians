package lg.handler.account;

import lg.handler.Handler;
import lg.member.Member;
import lg.member.MemberService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/account/login.jsp";
        } else {
            String msg = "로그인 실패";

            String username = request.getParameter("username");
            String passowrd = request.getParameter("password");

            MemberService service = new MemberService();
            Member member = service.getMember(username);

            if (member != null && passowrd.equals(member.getPassword())){
                // 로그인 처리
                HttpSession session = request.getSession();
                session.setAttribute("member_id", member.getMember_id());
                session.setAttribute("username", username);
                msg = "로그인 성공 / "+ username+ "님 환영합니다 ";

            }
            request.setAttribute("msg", msg);
            page = "redirect:/index.jsp";
        }

        return page;
    }
}
