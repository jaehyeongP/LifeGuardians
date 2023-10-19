package lg.handler.account;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.handler.Handler;
import lg.handler.account.dto.HospitalSignupApiDto;
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HospitalApiDataHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            String mapx = request.getParameter("mapx");
            String mapy = request.getParameter("mapy");
            System.out.println(mapx+ " | " + mapy);

            List<HospitalSignupApiDto> hospitalList = new ArrayList<>();
            NodeList items = getXML(mapx, mapy);

            /** parse logic */
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                String hpid = item.getElementsByTagName("hpid").item(0).getTextContent();
                String dutyName = item.getElementsByTagName("dutyName").item(0).getTextContent();
                String latitude = item.getElementsByTagName("latitude").item(0).getTextContent();
                String longitude = item.getElementsByTagName("longitude").item(0).getTextContent();
                String dutyDivName = item.getElementsByTagName("dutyDivName").item(0).getTextContent();
                String dutyTel1 = item.getElementsByTagName("dutyTel1").item(0).getTextContent();
                String distanceStr = item.getElementsByTagName("distance").item(0).getTextContent();
                Double distance = Double.valueOf(distanceStr);

                HospitalSignupApiDto dto = HospitalSignupApiDto.builder().hpid(hpid).dutyName(dutyName).latitude(latitude).longitude(longitude).dutyDivName(dutyDivName).dutyTel1(dutyTel1).distance(distance).build();

                hospitalList.add(dto);
            }

            //Distance로 정렬
            List<HospitalSignupApiDto> sortedList = hospitalList.stream()
                    .sorted(Comparator.comparingDouble(HospitalSignupApiDto::getDistance)).collect(Collectors.toList());

            //Distance가 0.0인 (해당 건물인) 데이터 추출
            List<HospitalSignupApiDto> filteredList = sortedList.stream()
                    .filter(h -> h.getDistance() == 0.0).collect(Collectors.toList());

            //Jackson을 사용하여 List를 Json 문자열로 변환
            String jsonResponse = objectToJson(filteredList);

            try {
                response.getWriter().write(jsonResponse);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
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

    //API를 호출하여 NodeList를 호출 재사용 어려움
    private NodeList getXML(String mapx, String mapy) {
        String serviceKey = "%2BRXcqgyJU2wQ1wKwZWb2vk6V3cEycHNk3oTG9oWZGtzch4LaRtpTljHTXj8dpf%2B0pC6ZLJTXps%2F38chREtY55w%3D%3D";
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("WGS84_LON", "UTF-8") + "=" + URLEncoder.encode(mapx, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("WGS84_LAT", "UTF-8") + "=" + URLEncoder.encode(mapy, "UTF-8"));
//            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("99999", "UTF-8"));


            URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());
            Element root = doc.getDocumentElement();
            Element body = (Element) root.getElementsByTagName("body").item(0);
            NodeList items = body.getElementsByTagName("item");

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
