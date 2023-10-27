package lg.handler.reply.api;

import lg.handler.Handler;
import lg.handler.board.dto.ReplyAddResponse;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.reply.Reply;
import lg.reply.ReplyService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        if(req.getMethod().equals("POST")){
            HospitalService hospitalService = new HospitalService();
            String hp_id = (String) req.getSession().getAttribute("hp_id");
            int board_id = Integer.parseInt(req.getParameter("board_id"));
            String reply_content = req.getParameter("reply_content");

            Hospital findHospital = hospitalService.getHospitalByHpid(hp_id);
            ReplyService replyService = new ReplyService();

            replyService.addReply(Reply.builder().board_id(board_id).hpid(hp_id).reply_content(reply_content).dutyName(findHospital.getDutyName()).build());
            ReplyAddResponse result = ReplyAddResponse.builder().board_id(String.valueOf(board_id)).dutyName(findHospital.getDutyName()).reply_content(reply_content).hpid(hp_id).build();

            try {
                res.getWriter().write(JsonMapper.objectToJson(result));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
