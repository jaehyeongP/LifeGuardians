package lg.handler.account;

import com.oreilly.servlet.MultipartRequest;
import lg.handler.Handler;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.member.Member;
import lg.member.MemberService;

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

            System.out.println(findMember);
            System.out.println(findHospital);


            if (findMember != null) {

                if(findMember.getPassword().equals(password)) {
                    session.setAttribute("member_id", findMember.getMember_id());
                    session.setAttribute("username", findMember.getUsername());
                    System.out.println("Success Member Login!");
                } else {
                    System.out.println("Error Member Login");
                }

            } else if (findHospital != null) {

                if(findHospital.getPassword().equals(password)) {
                    session.setAttribute("member_id", findHospital.getHpid());
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
