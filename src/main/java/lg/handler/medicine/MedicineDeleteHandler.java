package lg.handler.medicine;

import lg.handler.Handler;
import lg.medicine.MedicineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MedicineDeleteHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";

        if(req.getMethod().equals("POST")){
            int medicine_id = Integer.parseInt(req.getParameter("medicine_id"));

            MedicineService medicineService = new MedicineService();
            medicineService.deleteMedicine(medicine_id);

            page = "redirect:/page/medicine/mypage.jsp";
        }
        return page;
    }
}
