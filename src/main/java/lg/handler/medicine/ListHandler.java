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
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ListHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        String service_key = "%2FSUYfwzsdwBIFFtVsIomdyk8cXWUZ7CYhDti4oMnbPwiD2bOnlot%2Fysx8v2SmilVyyUY4BNmSyR3r0d9viGo5w%3D%3D";
        String page = "";

        if(request.getMethod().equals("GET")) {
            page = "/page/medicine/list.jsp";

            String urlstr = "https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList?&numOfRows=12&serviceKey=" + service_key + "&type=json";
            try{
                URL url = new URL(urlstr);

                URLConnection conn = url.openConnection();
                InputStream in = conn.getInputStream();
                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(in));
                JSONObject body = (JSONObject) obj.get("body");

                int totalCount = Integer.parseInt(String.valueOf(body.get("totalCount")));
                request.setAttribute("totalCount", totalCount);

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        return page;
    }
}
