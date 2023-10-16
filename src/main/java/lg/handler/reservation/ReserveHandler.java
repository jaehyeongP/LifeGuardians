package lg.handler.reservation;

import lg.handler.Handler;
import lg.member.Member;
import lg.member.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReserveHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        // 병원 상세페이지에서 예약하기 누르면 환자이름을 받아서 reserve_detail에 보내줌
        int member_id = Integer.parseInt(request.getParameter("member_id"));
        MemberService service = new MemberService();
        Member member = service.getMemberByMemberid(member_id);
        request.setAttribute("member", member);

        if(request.getMethod().equals("GET")){ // get방식

            page = "/page/reservation/reserve.jsp";

        } else { // post방식
            // 예약하기 누르면 예약 확인 form으로 넘겨줘야함
            // parameter : hpid, member_id, member_id

        }

        return page;
    }
}
