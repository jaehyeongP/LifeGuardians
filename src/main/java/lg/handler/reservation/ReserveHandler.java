package lg.handler.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.handler.Handler;
import lg.handler.reservation.dto.ReservationDetailResponse;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.member.Member;
import lg.member.MemberService;
import lg.reservation.Reservation;
import lg.reservation.ReservationService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class ReserveHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";

        if(request.getMethod().equals("GET")){ // 병원예약버튼 클릭시
            int member_id = (int) request.getSession().getAttribute("member_id");

            MemberService memberservice = new MemberService();
            Member member = memberservice.getMemberByMemberid(member_id);

            String hpid = request.getParameter("hpid");
            System.out.println(hpid);
            HospitalService hospitalservice = new HospitalService();
            Hospital hospital = hospitalservice.getHospitalByHpid(hpid);


            ReservationDetailResponse responseDto = ReservationDetailResponse.builder().hpid(hospital.getHpid()).dutyName(hospital.getDutyName())
                    .member_id(String.valueOf(member.getMember_id())).username(member.getUsername()).name(member.getName()).build();


            String result = objectToJson(responseDto);
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
            System.out.println("만약 여기서 hpid가 안뜨면 hpid가 문제인거임!");
            System.out.println(hpid);
            System.out.println("hpid를 다시봅시다");
            String reserveTime = request.getParameter("datetimepicker");
            String symptoms = request.getParameter("symptoms");
            String status = "예약완료"; // default status : 예약완료

            Reservation reservation = Reservation.builder().member_id(member.getMember_id()).hpid(hpid).reserveTime(reserveTime).symptoms(symptoms).status(status).build();
            ReservationService reservationservice = new ReservationService();
            reservationservice.addReservation(reservation);
            page = "/page/reservation/reserve.jsp"; //? 홈페이지로? 아님 다시 병원 상세페이지로?
            page = "redirect:/";

            return page;
        }

    }

    private String objectToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
