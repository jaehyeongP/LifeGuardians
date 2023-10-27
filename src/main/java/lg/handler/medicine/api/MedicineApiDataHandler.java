package lg.handler.medicine.api;

import lg.handler.Handler;
import lg.medicine.Medicine;
import lg.util.JsonMapper;
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
import java.util.HashMap;
import java.util.Map;

public class MedicineApiDataHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String service_key = "%2FSUYfwzsdwBIFFtVsIomdyk8cXWUZ7CYhDti4oMnbPwiD2bOnlot%2Fysx8v2SmilVyyUY4BNmSyR3r0d9viGo5w%3D%3D";

        if(request.getMethod().equals("GET")){
            String pageNo = "1";
            try{
                String search_keyword = "";
                String search_type = "";

                if(request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals(pageNo))
                    pageNo = request.getParameter("pageNo");

                String urlstr = "https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?&pageNo=" + pageNo + "&numOfRows=12&serviceKey=" + service_key + "&type=json";

                if(request.getParameter("search_keyword") != null && request.getParameter("search_type") != null){
                    search_keyword = URLEncoder.encode(request.getParameter("search_keyword"), "UTF-8");
                    search_type = request.getParameter("search_type");
                    if(search_type.equals("medicine_name"))
                        urlstr = urlstr + "&itemName=" + search_keyword;
                    else if(search_type.equals("symptom"))
                        urlstr = urlstr + "&efcyQesitm=" + search_keyword;
                }

                URL url = new URL(urlstr);

                URLConnection conn = url.openConnection();
                InputStream in = conn.getInputStream();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(in));
                JSONObject body = (JSONObject) obj.get("body");

                String totalCount = String.valueOf(body.get("totalCount"));

                JSONArray items = (JSONArray) body.get("items");
                ArrayList<Medicine> list = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    JSONObject item = (JSONObject) items.get(i);
                    String entpName = (String) item.get("entpName");
                    String itemName = (String) item.get("itemName");
                    String efcyQesitm = (String) item.get("efcyQesitm");
                    String useMethodQesitm = (String) item.get("useMethodQesitm");
                    String atpnWarnQesitm = (String) item.get("atpnWarnQersitm");
                    String atpnQesitm = (String) item.get("atpnQesitm");
                    String intrcQesitm = (String) item.get("intrcQesitm");
                    String seQesitm = (String) item.get("seQesitm");
                    String depositMethodQesitm = (String) item.get("depositMethodQesitm");
                    String itemImage = (String) item.get("itemImage");

                    list.add(new Medicine(0, 0, "", itemName, entpName, efcyQesitm, useMethodQesitm, atpnWarnQesitm, atpnQesitm, intrcQesitm, seQesitm, depositMethodQesitm, itemImage));
                }
                Map<String, Object> map = new HashMap<>();
                map.put("list", list);
                map.put("totalCount", totalCount);

                String jsonMap = JsonMapper.objectToJson(map);

                try{
                    response.getWriter().write(jsonMap);
                } catch (IOException e){
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}
