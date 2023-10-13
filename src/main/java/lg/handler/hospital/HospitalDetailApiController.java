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
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class HospitalDetailApiController implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if(request.getMethod().equals("GET")) {
            String hpid = "A2601246";
            NodeList items = getXML(hpid);


            Element item = (Element) items.item(0);
            String hpid1 = item.getElementsByTagName("hpid").item(0).getTextContent();
            String dutyName = item.getElementsByTagName("dutyName").item(0).getTextContent();
            String dutyAddr = item.getElementsByTagName("dutyAddr").item(0).getTextContent();
            String dutyTel1 = item.getElementsByTagName("dutyTel1").item(0).getTextContent();
            String dgidIdName = item.getElementsByTagName("dgidIdName").item(0).getTextContent();

            hospitalDetailVO vo = hospitalDetailVO.builder().hpid(hpid1).dutyName(dutyName).dutyAddr(dutyAddr).dutyTel1(dutyTel1).dgidIdName(dgidIdName).build();


            /** print vo */

            System.out.println(vo.getHpid()+ " | " + vo.getDutyName() + " | " + vo.getDgidIdName());


            //Jackson을 사용하여 List를 Json 문자열로 변환
            String jsonResponse = objectToJson(vo);

            try {
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
