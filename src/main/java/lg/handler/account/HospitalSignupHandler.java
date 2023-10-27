package lg.handler.account;

import lg.handler.Handler;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospitalSignupHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/account/signup_hospital.jsp";

        } else {
            //Login Info
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");

            //Location Info
            String address = request.getParameter("address");
            String extraAddress = request.getParameter("extraAddress").trim();
            String latitude = request.getParameter("latitude");
            String longitude = request.getParameter("longitude");

            //Hospital Info
            String hpid = request.getParameter("hpid");
            String dutyName = request.getParameter("dutyName");
            String dutyDivName = request.getParameter("dutyDivName");
            String dutyTel1 = request.getParameter("dutyTel1");

            HospitalService hospitalService = new HospitalService();

            Hospital hospital = Hospital.builder().hpid(hpid).username(username).password(password).email(email)
                    .address(address).extraAddress(extraAddress).dutyName(dutyName).dutyDivName(dutyDivName).dutyTel1(dutyTel1)
                    .latitude(latitude).longitude(longitude).build();

            hospitalService.addHospital(hospital);

            page = "redirect:/login.do";
        }

        return page;
    }
}
