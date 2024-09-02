package festival.service;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import festival.dao.FestivalMapper;
import festival.domain.Festival;
import festival.domain.FestivalResponse;

@Service
public class FestivalAPIService {

    private static final String BASE_URL = "https://apis.data.go.kr/B551011/KorService1/searchFestival1";
    private static final String SERVICE_KEY = "EyHOodgNqMLEewH%2FnSA8q7WYMe%2BsjXAgadnnvZAsgaVxywhQtJGwrCYb8A0rln82sgmoH3fHw8KQEEVvwrFwnA%3D%3D";

    private final FestivalMapper festivalMapper;
    private final RestTemplate restTemplate;
    private final Gson gson;

    @Autowired
    public FestivalAPIService(FestivalMapper festivalMapper, RestTemplate restTemplate, Gson gson) {
        this.festivalMapper = festivalMapper;
        this.restTemplate = restTemplate;
        this.gson = gson;
    }

    public Festival[] fetchFestivalData() {
        String url = BASE_URL + "?serviceKey=" + SERVICE_KEY
                + "&numOfRows=1502"
                + "&pageNo=1"
                + "&MobileOS=ETC"
                + "&MobileApp=App"
                + "&eventStartDate=20230101"
                + "&_type=json";

        try {
            URI uri = new URI(url);
            String jsonResponse = restTemplate.getForObject(uri, String.class);

            FestivalResponse response = gson.fromJson(jsonResponse, FestivalResponse.class);
            List<Festival> festivalsList = response.getResponse().getBody().getItems().getItem();
            return festivalsList.toArray(new Festival[0]);
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 로그
            return new Festival[0];
        }
    }

    @Transactional
    public void fetchAndStoreFestivalData() {
        Festival[] festivals = fetchFestivalData();

        if (festivals.length > 0) {
            // Festival[]를 List<Festival>로 변환
            List<Festival> festivalList = List.of(festivals);
            // 배치 처리
            try {
                festivalMapper.saveFestival(festivalList);
            } catch (Exception e) {
                e.printStackTrace(); // 예외 발생 시 로그
            }
        }
    }
}
