package lg.handler.reservation.api;

import lg.handler.Handler;
import lg.handler.reservation.dto.ReservationListResponse;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.reservation.Reservation;
import lg.reservation.ReservationService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReserveDetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals("GET")) {
            ReservationService reservationService = new ReservationService();
            HospitalService hospitalService = new HospitalService();
            int reserve_id = Integer.parseInt(request.getParameter("reserveId"));
            Reservation reservation = reservationService.getReservationByReserveId(reserve_id);
            Hospital findHospital = hospitalService.getHospitalByHpid(reservation.getHpid());

            ReservationListResponse resultHp =ReservationListResponse.builder()
                    .hpid(reservation.getHpid())
                    .dutyName(findHospital.getDutyName())
                    .dutyDivName(findHospital.getDutyDivName())
                    .dutyTel1(findHospital.getDutyTel1())
                    .address(findHospital.getAddress())
                    .extraAddress(findHospital.getExtraAddress())
                    .reserveTime(reservation.getReserveTime())
                    .symptoms(reservation.getSymptoms())
                    .status(reservation.getStatus())
                    .reserveId(String.valueOf(reservation.getReserve_id())).build();

            String jsonStr = JsonMapper.objectToJson(resultHp);

            try {
                response.getWriter().write(jsonStr);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

}
