package lg.handler.hospital.api;

import lg.handler.Handler;
import lg.handler.hospital.dto.HospitalListRequest;
import lg.handler.hospital.dto.HospitalListResponse;
import lg.hospital.Hospital;
import lg.hospital.HospitalService;
import lg.member.Member;
import lg.member.MemberService;
import lg.util.JsonMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class HospitalLocationApiHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
        if (request.getMethod().equals("GET")) {
            String mapx = "";
            String mapy = "";

            HospitalService hospitalService = new HospitalService();
            HttpSession session = request.getSession();

            String username = Optional.ofNullable((String) session.getAttribute("username")).orElse(null);
            Integer memberId = Optional.ofNullable((Integer) session.getAttribute("member_id")).orElse(null);

            //로그인 하지 않았으면 오리역(현재위치)을 기준으로 정렬
            if (username == null) {
                mapx = "127.1093955";
                mapy = "37.3388728";

            } else {
                MemberService memberService = new MemberService();
                Member member = memberService.getMemberByUsername(username);
                String address = member.getAddress();                           //로그인 시 현재 주소를 참조하여

                Map<String, String> coordinate = NaverReverseGeoCode(address);  //주소를 좌표로 변환
                mapx = coordinate.get("mapx");
                mapy = coordinate.get("mapy");
            }

            NodeList items = getXML(mapx, mapy);                                //사용자의 위치를 기반으로 거리를 계산
            List<HospitalListRequest> publicDataList = parseData(items);
            List<Hospital> hospitalList = hospitalService.getAll();

            List<Hospital> findHospitalList = publicDataList.stream()
                    .map(publicData -> hospitalList.stream().filter(hospital -> hospital.getHpid().equals(publicData.getHpid())).findFirst().orElse(null))
                    .filter(hospital -> hospital != null)                       //공공데이터 상 주변의 병원과 병원 회원의 hpid를 비교하여 리스트 생성
                    .collect(Collectors.toList());


            List<HospitalListResponse> result = findHospitalList.stream().map(e -> e.toDto()).collect(Collectors.toList());

            String jsonResponse = JsonMapper.objectToJson(result);                         //필요한 데이터를 ResponseDto에 담아 리스트로 전달

            try {
                response.getWriter().write(jsonResponse);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private List<HospitalListRequest> parseData(NodeList items) {
        List<HospitalListRequest> result = new ArrayList<>();
        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);
            String hpid = item.getElementsByTagName("hpid").item(0).getTextContent();
            String dutyName = item.getElementsByTagName("dutyName").item(0).getTextContent();
            String latitude = item.getElementsByTagName("latitude").item(0).getTextContent();
            String longitude = item.getElementsByTagName("longitude").item(0).getTextContent();
            String distanceStr = item.getElementsByTagName("distance").item(0).getTextContent();
            Double distance = Double.valueOf(distanceStr);

            HospitalListRequest dto = HospitalListRequest.builder().hpid(hpid).dutyName(dutyName).latitude(latitude).longitude(longitude).distance(distance).build();
            result.add(dto);
        }

        //데이터를 거리로 정렬
        List<HospitalListRequest> sortedList = result.stream()
                .sorted(Comparator.comparingDouble(HospitalListRequest::getDistance)).collect(Collectors.toList());

        //거리가 1.0 이하인 데이터만 추출
        List<HospitalListRequest> filteredList = sortedList.stream()
                .filter(h -> h.getDistance() <= 300.0).collect(Collectors.toList());

        return filteredList;
    }

    private NodeList getXML(String mapx, String mapy) {
        String serviceKey = "%2BRXcqgyJU2wQ1wKwZWb2vk6V3cEycHNk3oTG9oWZGtzch4LaRtpTljHTXj8dpf%2B0pC6ZLJTXps%2F38chREtY55w%3D%3D";
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncLcinfoInqire"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("WGS84_LON", "UTF-8") + "=" + URLEncoder.encode(mapx, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("WGS84_LAT", "UTF-8") + "=" + URLEncoder.encode(mapy, "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));

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

    private Map<String, String> NaverReverseGeoCode(String address) {
        Map<String, String> result = new HashMap<>();

        String clientId = "ip4ofz4q9s ";  //clientId
        String clientSecret = "G22s6GpAiAepbjkZpULgnhNTOeTX0IJ90gosVDfa ";  //clientSecret

        try {
            String addr = URLEncoder.encode(address, "UTF-8");  //주소입력
            String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=" + addr; //json

            URL url = new URL(apiURL.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(response.toString());
            JSONArray jsonArray = (JSONArray) jsonObject.get("addresses");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject item = (JSONObject) jsonArray.get(i);
                String roadAddress = (String) item.get("roadAddress");
                String jibunAddress = (String) item.get("jibunAddress");
                String x = (String) item.get("x");
                String y = (String) item.get("y");

                result.put("mapx", x);
                result.put("mapy", y);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}