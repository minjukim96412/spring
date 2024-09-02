package festival.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import festival.config.AppConfig;
import festival.service.FestivalAPIService;
import festival.service.FestivalDetailService;

public class FestivalMain {
    public static void main(String[] args) {
        // Spring Context 초기화 (Java Config 사용)
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // FestivalAPIService 빈 가져오기
//        FestivalAPIService festivalAPIService = context.getBean(FestivalAPIService.class);

        // API 데이터 가져와서 DB에 저장
//        festivalAPIService.fetchAndStoreFestivalData();

        // FestivalDetailService 빈 가져오기
        FestivalDetailService festivalDetailService = context.getBean(FestivalDetailService.class);

        // 각 contentId에 대한 상세 정보 가져와서 DB에 업데이트
//        festivalDetailService.updateFestivalDetails();

        festivalDetailService.updateAdditionalFestivalDetails();
        
        // Context 종료
        ((AnnotationConfigApplicationContext) context).close();
    }
}
