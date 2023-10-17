package lg.handler.hospital;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lg.handler.Handler;
import lg.review.Review;
import lg.review.ReviewService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RateHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {

        if (request.getMethod().equals("GET")) {
            ReviewService reviewService = new ReviewService();
            HashMap<Integer, Integer> sumMap = new HashMap<>();
            HashMap<String, Double> avgMap = new HashMap<>();
            int totalSum = 0;

            String hpid = request.getParameter("hpid");  // query parameter에서 hpid 값 가져오기
            ArrayList<Review> listAll = reviewService.getAll();

            for (Review review : listAll) {
                int rate = review.getRate();
                totalSum += rate;
                sumMap.put(rate, sumMap.getOrDefault(rate, 0) + rate);
            }

            System.out.println(sumMap);

            for (int rate : sumMap.keySet()) {
                double ratio = (double) sumMap.get(rate) / totalSum * 100;
                avgMap.put("avg"+rate, ratio);
                System.out.println("Rate " + rate + " Ratio: " + ratio + "%");
            }

            System.out.println(avgMap);

            String json = objectToJson(avgMap);  //받아온 list 객체를 JSON 형식의 문자열로 변환해서  String json에 담음.


            try {
                response.getWriter().write(json);


            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else {

        }
        return null;
    }

    private void caclAvg(String hpid) {

        ReviewService reviewService = new ReviewService();
        ArrayList<Review> reviewList = reviewService.getAll();

        for (Review review : reviewList) {
            int rate = review.getRate();

            if (rate == 1) {

            }

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

}


