package lg.handler.account;

import lg.exception.account.DuplicateUsernameException;
import lg.exception.account.FormValidationException;
import lg.exception.account.UnMatchedConfirmPasswordException;
import lg.handler.Handler;
import lg.member.Member;
import lg.member.MemberService;
import lg.util.PasswordEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberSignupHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";

        if (request.getMethod().equals("GET")) {
            page = "/page/account/signup-member.jsp";
        }

        if (request.getMethod().equals("POST")) {
            try {
                if(formValidate(request)) {
                    memberSignup(request);
                }
                page = "redirect:/login.do";

            } catch (FormValidationException e) {
                request.setAttribute("formError", e.getMessage());
                page="/page/account/signup-member.jsp";

            } catch (DuplicateUsernameException e) {
                request.setAttribute("usernameError", e.getMessage());
                page="/page/account/signup-member.jsp";

            } catch (UnMatchedConfirmPasswordException e) {
                request.setAttribute("passwordError", e.getMessage());
                page="/page/account/signup-member.jsp";

            } finally {

                return page;
            }
        }

        return page;
    }

    private boolean formValidate(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = PasswordEncoder.encodePassword(request.getParameter("password"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String firstRegNum = request.getParameter("firstRegNum");
        String lastRegNum = PasswordEncoder.encodePassword(request.getParameter("lastRegNum"));
        String gender = request.getParameter("gender");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String extraAddress = request.getParameter("extraAddress");

        if (username.isEmpty() || password.isEmpty() || email.isEmpty() ||
                name.isEmpty() || firstRegNum.isEmpty() || lastRegNum.isEmpty() ||
                gender.isEmpty() || tel.isEmpty() || address.isEmpty()) {
            throw new FormValidationException();
        }

        return true;
    }

    private void memberSignup(HttpServletRequest request) {
        MemberService memberService = new MemberService();

        String username = request.getParameter("username");
        String password = PasswordEncoder.encodePassword(request.getParameter("password"));
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String firstRegNum = request.getParameter("firstRegNum");
        String lastRegNum = PasswordEncoder.encodePassword(request.getParameter("lastRegNum"));
        String gender = request.getParameter("gender");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String extraAddress = request.getParameter("extraAddress");

        Member member = Member.builder().username(username).password(password).email(email)
                .name(name).firstRegNum(firstRegNum).lastRegNum(lastRegNum).gender(gender).tel(tel).
                address(address).extraAddress(extraAddress).build();

        memberService.addMember(member);
    }
}