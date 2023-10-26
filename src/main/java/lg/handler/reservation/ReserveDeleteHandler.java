package lg.handler.reservation;

import lg.handler.Handler;
import lg.reservation.ReservationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReserveDeleteHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")){
            int reserve_id = Integer.parseInt(request.getParameter("reserve_id"));

            ReservationService reservationservice = new ReservationService();
            reservationservice.delReservation(reserve_id);
            page = "redirect:/";
        }

        return page;
    }
}
