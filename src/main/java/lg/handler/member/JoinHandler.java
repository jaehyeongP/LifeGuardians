package lg.handler.member;

import lg.handler.Handler;
import lg.member.Member;
import lg.member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JoinHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        String view = "/index.jsp";
        if(request.getMethod().equals("GET")){
            request.setAttribute("view", "/member/join.jsp");
        } else{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String idNumber = request.getParameter("idNumber");
            String sex = request.getParameter("sex");
            String eamil = request.getParameter("email");
            String tel = request.getParameter("tel");

            MemberService service = new MemberService();
            service.addMember(new Member(0, username, password, name, idNumber, sex, eamil, tel, null, null));
            view = "redirect:/index.jsp";
        }
        return view;
    }

}