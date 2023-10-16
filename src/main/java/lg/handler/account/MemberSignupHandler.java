package lg.handler.account;

import lg.handler.Handler;
import lg.member.Member;
import lg.member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberSignupHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/account/signup-member.jsp";

        } else {
            MemberService memberService = new MemberService();

            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            String name = request.getParameter("name");
            int firstRegNum = Integer.parseInt(request.getParameter("firstRegNum"));
            int lastRegNum = Integer.parseInt(request.getParameter("lastRegNum"));
            String gender = request.getParameter("gender");
            String tel = request.getParameter("tel");
            String address = request.getParameter("address");
            String extraAddress = request.getParameter("extraAddress");

            Member member = Member.builder().username(username).password(password).email(email)
                    .name(name).firstRegNum(firstRegNum).lastRegNum(lastRegNum).gender(gender).tel(tel).
                    address(address).extraAddress(extraAddress).build();

            memberService.addMember(member);

            page = "redirect:/login.do";
        }

        return page;
    }
}
