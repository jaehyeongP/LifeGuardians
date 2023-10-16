package lg.handler;

import lg.hospital.HospitalService;
import lg.hospital.HospitalV2;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
import java.util.Optional;

@WebServlet(name = "InitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class InitHandler extends HttpServlet {
    final static int TOTAL_COUNT = 75816;
    final static int PAGE_COUNT = 8;
    final static int NUM_OF_ROWS = TOTAL_COUNT / PAGE_COUNT;

    @Override
    public void init(ServletConfig config) throws ServletException {
//        try {
//            doGet(null, null);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (int i = 1; i <= PAGE_COUNT; i++) {
            NodeList items = getXML(i);

            for (int j = 0; j < items.getLength(); j++) {
                Element item = (Element) items.item(j);
                String hpid = Optional.ofNullable(item.getElementsByTagName("hpid").item(0)).map(Node::getTextContent).orElse("");
                String dutyAddr = Optional.ofNullable(item.getElementsByTagName("dutyAddr").item(0)).map(Node::getTextContent).orElse("");
                String dutyDiv = Optional.ofNullable(item.getElementsByTagName("dutyDiv").item(0)).map(Node::getTextContent).orElse("");
                String dutyDivNam = Optional.ofNullable(item.getElementsByTagName("dutyDivNam").item(0)).map(Node::getTextContent).orElse("");
                String dutyName = Optional.ofNullable(item.getElementsByTagName("dutyName").item(0)).map(Node::getTextContent).orElse("");
                String dutyTel1 = Optional.ofNullable(item.getElementsByTagName("dutyTel1").item(0)).map(Node::getTextContent).orElse("");
                String dutyTel3 = Optional.ofNullable(item.getElementsByTagName("dutyTel3").item(0)).map(Node::getTextContent).orElse("");
                String wgs84Lon = Optional.ofNullable(item.getElementsByTagName("wgs84Lon").item(0)).map(Node::getTextContent).orElse("");
                String wg84Lat = Optional.ofNullable(item.getElementsByTagName("wg84Lat").item(0)).map(Node::getTextContent).orElse("");
                String dutyInf = Optional.ofNullable(item.getElementsByTagName("dutyInf").item(0)).map(Node::getTextContent).orElse("");

                HospitalV2 hospital = HospitalV2.builder().hpid(hpid).dutyAddr(dutyAddr).dutyDiv(dutyDiv).dutyDivNam(dutyDivNam).dutyName(dutyName)
                        .dutyTel1(dutyTel1).dutyTel3(dutyTel3).wgs84Lon(wgs84Lon).wgs84Lat(wg84Lat).dutyInf(dutyInf).build();

                HospitalService hospitalService = new HospitalService();
                hospitalService.addHospitalV2(hospital);
            }
        }
    }

    private NodeList getXML(int page) {
        String serviceKey = "%2BRXcqgyJU2wQ1wKwZWb2vk6V3cEycHNk3oTG9oWZGtzch4LaRtpTljHTXj8dpf%2B0pC6ZLJTXps%2F38chREtY55w%3D%3D";
        try {
            StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B552657/HsptlAsembySearchService/getHsptlMdcncFullDown"); /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + serviceKey);
            urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(NUM_OF_ROWS), "UTF-8"));
            urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(page), "UTF-8"));

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
