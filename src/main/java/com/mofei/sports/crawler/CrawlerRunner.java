package com.mofei.sports.crawler;

import com.mofei.sports.crawler.cleansing.CleansingData;
import com.mofei.sports.crawler.cleansing.SaveDataService;
import com.mofei.sports.web.entity.BasketballMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        crawler.init("http://nba.win007.com/jsData/matchResult/17-18/l1_1_2017_12.js?version=2018072503)");

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

        addTaskToQueue();

    }

    public Map<String, List<String>> addTaskToQueue(){

        Map<String,List<String>> seasons = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            String prev = i < 10 ? "0"+i : i+"";
            String next = (i+1) < 10 ? "0"+(i+1) : (i+1)+"";
            String season = prev + "-" + next;

            List<String> yearAndMonthOfSeason = new ArrayList<>();
            for (int j = 10; j < 17; j++) {
                String month = j > 12 ? "0"+(j-12):""+j;
                String yearMonth = "20" + (j>12 ?  next : prev )+ "_" +  month;
                yearAndMonthOfSeason.add(yearMonth);
            }

            seasons.put(season,yearAndMonthOfSeason);
        }

        return seasons;

    }
}
