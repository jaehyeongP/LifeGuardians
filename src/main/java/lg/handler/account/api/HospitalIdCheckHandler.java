package lg.handler.account.api;

import lg.handler.Handler;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.member.Member;
import lg.member.MemberService;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospitalIdCheckHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        Hospital hospital = new HospitalService().getHospitalByUsername(username);
        boolean flag = false;
        if(hospital==null){
            flag = true;
        }
        JSONObject obj = new JSONObject();
        obj.put("flag",flag);
        String txt = obj.toJSONString();
        return "responsebody/"+txt;
    }
}
