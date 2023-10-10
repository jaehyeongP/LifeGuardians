package lg.handler.medicine;

import lg.handler.Handler;
import lg.medicine.Medicine;
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
import java.util.ArrayList;
import java.util.Arrays;

public class ListHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {
        String page = "";
        if(req.getMethod().equals("GET")) {
            page = "/page/medicine/list.jsp";

            try{
                String service_key = "%2FSUYfwzsdwBIFFtVsIomdyk8cXWUZ7CYhDti4oMnbPwiD2bOnlot%2Fysx8v2SmilVyyUY4BNmSyR3r0d9viGo5w%3D%3D";
                String pageNo = "1";
//            if(!req.getParameter("pageNo").equals("1"))
//                pageNo = req.getParameter("pageNo");
                String search_type = req.getParameter("search_type");
                String search_keyword = req.getParameter("search_keyword");

                String urlstr = "https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?pageNo=" + pageNo + "&numOfRows=12&serviceKey=" + service_key + "&type=json";

                URL url = new URL(urlstr);

                URLConnection conn = url.openConnection();
                InputStream in = conn.getInputStream();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(in));
                JSONObject body = (JSONObject) obj.get("body");
                JSONArray items = (JSONArray) body.get("items");
                ArrayList<Medicine> list = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    JSONObject item = (JSONObject) items.get(i);
                    String itemSeq = (String) item.get("itemSeq");
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

                    list.add(new Medicine(itemSeq, entpName, itemName, efcyQesitm, useMethodQesitm, atpnWarnQesitm, atpnQesitm, intrcQesitm, seQesitm, depositMethodQesitm, itemImage));
                }
                req.setAttribute("list", list);
            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

        } else {


        }

        return page;
    }
}
