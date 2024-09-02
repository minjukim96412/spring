package festival.service;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import festival.dao.FestivalMapper;
import festival.domain.Festival;

@Service
public class FestivalDetailService {

    private static final String DETAIL_URL = "https://apis.data.go.kr/B551011/KorService1/detailCommon1";
    private static final String INTRO_URL = "https://apis.data.go.kr/B551011/KorService1/detailIntro1";
    private static final String SERVICE_KEY = "EyHOodgNqMLEewH%2FnSA8q7WYMe%2BsjXAgadnnvZAsgaVxywhQtJGwrCYb8A0rln82sgmoH3fHw8KQEEVvwrFwnA%3D%3D";

    private final FestivalMapper festivalMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public FestivalDetailService(FestivalMapper festivalMapper, RestTemplate restTemplate) {
        this.festivalMapper = festivalMapper;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public void updateFestivalDetails() {
        List<Festival> festivals = festivalMapper.getFestivalsWithNullOverviewYN();

        for (Festival festival : festivals) {
            String detailUrl = DETAIL_URL + "?serviceKey=" + SERVICE_KEY
                    + "&MobileOS=ETC"
                    + "&MobileApp=AppTest"
                    + "&_type=json"
                    + "&contentId=" + festival.getContentid()
                    + "&contentTypeId=15"
                    + "&overviewYN=Y";

            try {
                URI uri = new URI(detailUrl);
                String jsonResponse = restTemplate.getForObject(uri, String.class);

                // JSON 파싱
                JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
                JsonObject overview = jsonObject.getAsJsonObject("response")
                                               .getAsJsonObject("body")
                                               .getAsJsonObject("items")
                                               .getAsJsonArray("item")
                                               .get(0)
                                               .getAsJsonObject();

                String overviewText = overview.has("overview") ? overview.get("overview").getAsString() : null;

                if (overviewText != null && !overviewText.isEmpty()) {
                    festival.setOverviewYN(overviewText);
                    festivalMapper.updateFestivalOverviewYN(festival);
                }

            } catch (Exception e) {
                e.printStackTrace(); // 예외 발생 시 로그
            }
        }
    }

    @Transactional
    public void updateAdditionalFestivalDetails() {
        List<Festival> festivals = festivalMapper.getFestivalsWithNullAdditionalDetails();

        for (Festival festival : festivals) {
            String introUrl = INTRO_URL + "?serviceKey=" + SERVICE_KEY
                    + "&MobileOS=ETC"
                    + "&MobileApp=AppTest"
                    + "&_type=json"
                    + "&contentId=" + festival.getContentid()
                    + "&contentTypeId=15";

            try {
                URI uri = new URI(introUrl);
                String jsonResponse = restTemplate.getForObject(uri, String.class);

                // JSON 파싱
                JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
                JsonObject items = jsonObject.getAsJsonObject("response")
                                             .getAsJsonObject("body")
                                             .getAsJsonObject("items")
                                             .getAsJsonArray("item")
                                             .get(0)
                                             .getAsJsonObject();

                String playtime = items.has("playtime") ? items.get("playtime").getAsString() : null;
                String usetimefestival = items.has("usetimefestival") ? items.get("usetimefestival").getAsString() : null;

                boolean isUpdated = false;

                if (playtime != null) {
                    festival.setPlaytime(playtime);
                    isUpdated = true;
                }

                if (usetimefestival != null) {
                    festival.setUsetimefestival(usetimefestival);
                    isUpdated = true;
                }

                if (isUpdated) {
                    festivalMapper.updateFestivalAdditionalDetails(festival);
                }

            } catch (Exception e) {
                e.printStackTrace(); // 예외 발생 시 로그
            }
        }
    }
}
