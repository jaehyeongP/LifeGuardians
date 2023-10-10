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
import java.net.URLEncoder;
import java.util.ArrayList;

public class DetailHandler implements Handler {
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) {

        String page = "";
        if(req.getMethod().equals("GET")) {
            page = "/page/medicine/detail.jsp";

            try{
                String service_key = "%2FSUYfwzsdwBIFFtVsIomdyk8cXWUZ7CYhDti4oMnbPwiD2bOnlot%2Fysx8v2SmilVyyUY4BNmSyR3r0d9viGo5w%3D%3D";
                String item_seq = req.getParameter("itemSeq");
                System.out.println(item_seq);

                String urlstr = "https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?&serviceKey=" + service_key + "&itemSeq=" + item_seq + "&type=json";
                URL url = new URL(urlstr);
                System.out.println(url);

                URLConnection conn = url.openConnection();
                InputStream in = conn.getInputStream();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(in));
                System.out.println(obj);

                JSONObject body = (JSONObject) obj.get("body");
                System.out.println(body);
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

                Medicine medicine = new Medicine("0", entpName, itemName, efcyQesitm, useMethodQesitm, atpnWarnQesitm, atpnQesitm, intrcQesitm, seQesitm, depositMethodQesitm, itemImage);

                req.setAttribute("medicine", medicine);
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
