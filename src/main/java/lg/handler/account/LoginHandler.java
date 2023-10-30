package lg.handler.account;

import lg.handler.Handler;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.member.Member;
import lg.member.MemberService;
import lg.util.PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/account/login.jsp";
        } else {
            String msg = "로그인 실패";
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            MemberService memberService = new MemberService();
            HospitalService hospitalService = new HospitalService();

            Member findMember = Optional.ofNullable(memberService.getMemberByUsername(username)).orElse(null);
            Hospital findHospital = Optional.ofNullable(hospitalService.getHospitalByUsername(username)).orElse(null);
            HttpSession session = request.getSession();

            if (findMember != null) {
                if(PasswordEncoder.verifyPassword(password, findMember.getPassword())) {
                    session.setAttribute("member_id", findMember.getMember_id());
                    session.setAttribute("username", findMember.getUsername());
                    System.out.println("Success Member Login!");
                } else {
                    System.out.println("Error Member Login");
                }

            } else if (findHospital != null) {
                if(PasswordEncoder.verifyPassword(password, findHospital.getPassword())) {
                    session.setAttribute("hp_id", findHospital.getHpid());
                    session.setAttribute("username", findHospital.getDutyName());
                    System.out.println("Success Hosptial Login!");
                } else {
                    System.out.println("Error Hospital Login");
                }
            } else {
                System.out.println("NotFoundUsers");
            }

            request.setAttribute("msg", msg);
            page = "redirect:/";
        }
        return page;
    }
}
