package com.mofei.sports.crawler;

import com.mofei.sports.crawler.cleansing.CleansingData;
import com.mofei.sports.crawler.cleansing.SaveDataService;
import com.mofei.sports.web.entity.BasketballMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrawlerRunner implements CommandLineRunner {
    @Autowired
    private Crawler crawler;

    @Autowired
    private MatchOddsCrawler matchOddsCrawler;

    @Autowired
    private SaveDataService saveDataService;

    @Override
    public void run(String...args) throws Exception {
        crawler.init("http://nba.win007.com/jsData/matchResult/17-18/l1_1_2017_10.js?version=2018072503)");

        saveDataService.saveBasketballTeams( CleansingData.getBasketballTeams(crawler.getCrawlerData()));

        List<BasketballMatch> basketballMatchList = CleansingData.getBasketballMatches(crawler.getCrawlerData());
        saveDataService.saveBasketballMatches( basketballMatchList);

        for(BasketballMatch match : basketballMatchList){
            String url = "http://nba.win007.com/jsData/analyOdds/" + match.getMatchId() + ".js";
            matchOddsCrawler.init(url);
            saveDataService.saveBasketballMatchOdds(
                    CleansingData.getBasketballMatchOdds(
                            matchOddsCrawler.getCrawlerData(),
                            match.getMatchId()));
        }

    }
}
