package lg.handler.medicine;

import lg.handler.Handler;
import lg.medicine.Medicine;
import lg.medicine.MedicineService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class MedicineMypageHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";
        if(req.getMethod().equals("GET")){
            page = "/page/medicine/mypage.jsp";

            int member_id = (int) req.getSession().getAttribute("member_id");

            MedicineService medicineService = new MedicineService();
            ArrayList<Medicine> list = medicineService.getAll(member_id);

            req.setAttribute("list", list);

        } else {
            int member_id = (int) req.getSession().getAttribute("member_id");
            int  medicine_id = Integer.parseInt(req.getParameter("medicine_id"));
            String take_time = req.getParameter("take_time");

            MedicineService medicineService = new MedicineService();
            medicineService.editMedicine(Medicine.builder().medicine_id(medicine_id).member_id(member_id).take_time(take_time).build());

            try {
                res.getWriter().write(JsonMapper.objectToJson("test"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;

        }
        return page;
    }
}
