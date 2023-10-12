package lg.handler.account;

import lg.handler.Handler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class HospitalSignupHandler implements Handler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        //TODO : Api호출하는 Controller와 현재 Handler를 병합할까 고민중
        String page = "";
        if(request.getMethod().equals("GET")) {
            page = "/page/account/signup_hospital.jsp";

        } else {
            //TODO : 회원 가입 처리
        }

        return page;
    }
}
