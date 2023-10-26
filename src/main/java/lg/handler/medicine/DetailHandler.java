package lg.handler.medicine;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import lg.handler.Handler;
import lg.medicine.Medicine;
import lg.medicine.MedicineService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class DetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res){

        String page = "";
        if(req.getMethod().equals("GET")) {
            page = "/page/medicine/detail.jsp";

            try{
                String service_key = "%2FSUYfwzsdwBIFFtVsIomdyk8cXWUZ7CYhDti4oMnbPwiD2bOnlot%2Fysx8v2SmilVyyUY4BNmSyR3r0d9viGo5w%3D%3D";
                String item_name = URLEncoder.encode(req.getParameter("itemName"), "UTF-8");

                String urlstr = "https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?&serviceKey=" + service_key + "&itemName=" + item_name + "&type=json";
                URL url = new URL(urlstr);

                URLConnection conn = url.openConnection();
                InputStream in = conn.getInputStream();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(in));

                JSONObject body = (JSONObject) obj.get("body");
                JSONArray items = (JSONArray) body.get("items");

                JSONObject item = (JSONObject) items.get(0);
                String entpName = (String) item.get("entpName");
                String itemName = (String) item.get("itemName");
                String efcyQesitm = (String) item.get("efcyQesitm");
                String useMethodQesitm = (String) item.get("useMethodQesitm");
                String atpnWarnQesitm = (String) item.get("atpnWarnQesitm");
                String atpnQesitm = (String) item.get("atpnQesitm");
                String intrcQesitm = (String) item.get("intrcQesitm");
                String seQesitm = (String) item.get("seQesitm");
                String depositMethodQesitm = (String) item.get("depositMethodQesitm");
                String itemImage = (String) item.get("itemImage");

                Medicine medicine = new Medicine(0, 0, "", itemName, entpName, efcyQesitm, useMethodQesitm, atpnWarnQesitm, atpnQesitm, intrcQesitm, seQesitm, depositMethodQesitm, itemImage);

                req.setAttribute("medicine", medicine);
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        } else {

            String path = "/Users/Administrator/IdeaProjects/LifeGuardians/medicineImg/";
            int size = 100 * 1024;
            MultipartRequest multi = null;
            try {
                multi = new MultipartRequest(req, path, size, "utf-8", new DefaultFileRenamePolicy());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            int member_id = Integer.parseInt(multi.getParameter("member_id"));
            String itemName = multi.getParameter("itemName");
            String entpName = multi.getParameter("entpName");
            String efcyQesitm = multi.getParameter("efcyQesitm");
            String useMethodQesitm = multi.getParameter("useMethodQesitm");
            String atpnWarnQesitm = multi.getParameter("atpnWarnQesitm");
            String atpnQesitm = multi.getParameter("atpnQesitm");
            String intrcQesitm = multi.getParameter("intrcQesitm");
            String seQesitm = multi.getParameter("seQesitm");
            String depositMethodQesitm = multi.getParameter("depositMethodQesitm");
            String itemImage = multi.getParameter("itemImage");

            MedicineService medicineService = new MedicineService();
            medicineService.addMedicine(new Medicine(0, member_id, "", itemName, entpName, efcyQesitm, useMethodQesitm, atpnWarnQesitm, atpnQesitm, intrcQesitm, seQesitm, depositMethodQesitm, itemImage));

            page = "redirect:/page/medicine/list.jsp";
        }
        return page;
    }
}
