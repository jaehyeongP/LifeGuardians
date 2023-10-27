package lg.handler.reservation;

import lg.handler.Handler;
import lg.handler.reservation.dto.ReservationDetailResponse;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.member.Member;
import lg.member.MemberService;
import lg.reservation.Reservation;
import lg.reservation.ReservationService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReserveHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";

        if(request.getMethod().equals("GET")){ // 병원예약버튼 클릭시
            int member_id = (int) request.getSession().getAttribute("member_id");

            MemberService memberservice = new MemberService();
            Member member = memberservice.getMemberByMemberid(member_id);

            String hpid = request.getParameter("hpid");
            HospitalService hospitalservice = new HospitalService();
            Hospital hospital = hospitalservice.getHospitalByHpid(hpid);

            ReservationDetailResponse responseDto = ReservationDetailResponse.builder().hpid(hospital.getHpid()).dutyName(hospital.getDutyName())
                    .member_id(String.valueOf(member.getMember_id())).username(member.getUsername()).name(member.getName()).build();

            String result = JsonMapper.objectToJson(responseDto);

            try {
                response.getWriter().write(result);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        } else { // post방식 : 예약확인 클릭시 -> db에 값을 넘겨줌
            int member_id = (int) request.getSession().getAttribute("member_id");

            MemberService memberservice = new MemberService();
            Member member = memberservice.getMemberByMemberid(member_id);

            String hpid = request.getParameter("hpid");

            String reserveTime = request.getParameter("datetimepicker");
            String symptoms = request.getParameter("symptoms");
            String status = "예약완료"; // default status : 예약완료

            Reservation reservation = Reservation.builder().member_id(member.getMember_id()).hpid(hpid).reserveTime(reserveTime).symptoms(symptoms).status(status).build();
            ReservationService reservationservice = new ReservationService();
            reservationservice.addReservation(reservation);
            page = "redirect:/";

            return page;
        }

    }

}
