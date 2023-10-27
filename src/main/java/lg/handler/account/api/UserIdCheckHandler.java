package lg.handler.account.api;

import lg.handler.Handler;
import lg.member.Member;
import lg.member.MemberService;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserIdCheckHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        Member member = (new MemberService()).getMemberByUsername(username);
        boolean flag = false;
        if(member==null){
            flag = true;
        }
        JSONObject obj = new JSONObject();
        obj.put("flag",flag);
        String txt = obj.toJSONString();
        return "responsebody/"+txt;
    }
}
