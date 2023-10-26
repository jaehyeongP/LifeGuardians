package lg.handler.review.api;

import lg.handler.Handler;
import lg.review.Review;
import lg.review.ReviewService;
import lg.util.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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

            for (int rate : sumMap.keySet()) {
                double ratio = (double) sumMap.get(rate) / totalSum * 100;
                avgMap.put("avg"+rate, ratio);
            }

            String json = JsonMapper.objectToJson(avgMap);

            try {
                response.getWriter().write(json);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
}


