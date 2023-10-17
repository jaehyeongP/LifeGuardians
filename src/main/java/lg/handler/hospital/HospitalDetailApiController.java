package lg.handler.hospital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.handler.Handler;
import lg.hospital.hospitalDetailVO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class HospitalDetailApiController implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals("GET")) {
            String hpid = request.getParameter("hpid");
            NodeList items = getXML(hpid);

            Element item = (Element) items.item(0);
            String hpid1 = item.getElementsByTagName("hpid").item(0).getTextContent();
            String dutyName = item.getElementsByTagName("dutyName").item(0).getTextContent();
            String dutyAddr = item.getElementsByTagName("dutyAddr").item(0).getTextContent();
            String dutyTel1 = item.getElementsByTagName("dutyTel1").item(0).getTextContent();
            String dgidIdName = item.getElementsByTagName("dgidIdName").item(0).getTextContent();

            // 진료시간
            String dutyTime1s = item.getElementsByTagName("dutyTime1s").item(0).getTextContent();
            String dutyTime1c = item.getElementsByTagName("dutyTime1c").item(0).getTextContent();
            String dutyTime2s = item.getElementsByTagName("dutyTime2s").item(0).getTextContent();
            String dutyTime2c = item.getElementsByTagName("dutyTime2c").item(0).getTextContent();
            String dutyTime3s = item.getElementsByTagName("dutyTime3s").item(0).getTextContent();
            String dutyTime3c = item.getElementsByTagName("dutyTime3c").item(0).getTextContent();
            String dutyTime4s = item.getElementsByTagName("dutyTime4s").item(0).getTextContent();
            String dutyTime4c = item.getElementsByTagName("dutyTime4c").item(0).getTextContent();
            String dutyTime5s = item.getElementsByTagName("dutyTime5s").item(0).getTextContent();
            String dutyTime5c = item.getElementsByTagName("dutyTime5c").item(0).getTextContent();
            String dutyTime6s = item.getElementsByTagName("dutyTime6s").item(0).getTextContent();
            String dutyTime6c = item.getElementsByTagName("dutyTime6c").item(0).getTextContent();

            // 시작시간 하드코딩
            List<String> startDutyTimes = new ArrayList<>();
            startDutyTimes.add(dutyTime1s);
            startDutyTimes.add(dutyTime2s);
            startDutyTimes.add(dutyTime3s);
            startDutyTimes.add(dutyTime4s);
            startDutyTimes.add(dutyTime5s);
            startDutyTimes.add(dutyTime6s);

            // 끝나는 시간 하드코딩
            List<String> endDutyTimes = new ArrayList<>();
            endDutyTimes.add(dutyTime1c);
            endDutyTimes.add(dutyTime2c);
            endDutyTimes.add(dutyTime3c);
            endDutyTimes.add(dutyTime4c);
            endDutyTimes.add(dutyTime5c);
            endDutyTimes.add(dutyTime6c);

            // vo에 담기
            hospitalDetailVO vo = hospitalDetailVO.builder().hpid(hpid1).dutyName(dutyName).dutyAddr(dutyAddr).dutyTel1(dutyTel1).dgidIdName(dgidIdName).startTime(startDutyTimes).endTime(endDutyTimes).build();

            // 담은 vo를 json으로 변환
            String jsonResponse = objectToJson(vo);

            try {
                // response 객체에 지정
                response.getWriter().write(jsonResponse);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return null;

        } else {

            return null;
        }
    }

    private String objectToJson(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private NodeList getXML(String ignoredHpid) {
        String serviceKey = "%2BRXcqgyJU2wQ1wKwZWb2vk6V3cEycHNk3oTG9oWZGtzch4LaRtpTljHTXj8dpf%2B0pC6ZLJTXps%2F38chREtY55w%3D%3D";
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlBassInfoInqire");
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("HPID", "UTF-8") + "=" + URLEncoder.encode(ignoredHpid, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));

            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());
            Element root = doc.getDocumentElement();

            Element body = (Element) root.getElementsByTagName("body").item(0);
            NodeList items = body.getElementsByTagName("items");

            return items;

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }


}
