package festival.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import festival.service.FestivalAPIService;

@RestController
@RequestMapping("/festival")
public class FestivalController {

    private FestivalAPIService festivalAPIService;

    @Autowired
    public FestivalController(FestivalAPIService festivalAPIService) {
        this.festivalAPIService = festivalAPIService;
    }

    @GetMapping
    public String fetchAndStoreFestivalData() {
        festivalAPIService.fetchAndStoreFestivalData();
        return "Festival data fetched and stored successfully.";
    }
}
