package com.mofei.sports.crawler;

import com.mofei.sports.crawler.cleansing.CleansingData;
import com.mofei.sports.crawler.cleansing.SaveDataService;
import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.entity.BasketballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

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


        Queue<String> queue = generateTaskToQueue();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String url = queue.poll();
//                String url = "http://nba.win007.com/jsData/matchResult/17-18/l1_1_2018_1.js";
                executeTask(url);
            }
        },3000,5000);

    }

    private void executeTask(String url){
        crawler.init(url);

        List<BasketballTeam> basketballTeams = CleansingData.getBasketballTeams(crawler.getCrawlerData());
        if (basketballTeams != null){
            saveDataService.saveBasketballTeams(basketballTeams);
        }

        List<BasketballMatch> basketballMatchList = CleansingData.getBasketballMatches(crawler.getCrawlerData());
        saveDataService.saveBasketballMatches( basketballMatchList);

        for(BasketballMatch match : basketballMatchList){
            String oddsUrl = "http://nba.win007.com/jsData/analyOdds/" + match.getMatchId() + ".js";
            matchOddsCrawler.init(oddsUrl);
            BasketballMatchOdds basketballMatchOdds = CleansingData.getBasketballMatchOdds(
                    matchOddsCrawler.getCrawlerData(),
                    match.getMatchId());
            if (basketballMatchOdds != null){
                saveDataService.saveBasketballMatchOdds(basketballMatchOdds);
            }
        }
    }

    private Queue<String> generateTaskToQueue(){

        Map<String,List<String>> seasons = new HashMap<>();
        for (int i = 0; i < 18; i++) {
            String prev = i < 10 ? "0"+i : i+"";
            String next = (i+1) < 10 ? "0"+(i+1) : (i+1)+"";
            String season = prev + "-" + next;

            List<String> yearAndMonthOfSeason = new ArrayList<>();
            for (int j = 10; j < 17; j++) {
                String month = ""+ (j > 12 ? (j-12) : j);
                String yearMonth = "20" + (j>12 ?  next : prev )+ "_" +  month;
                yearAndMonthOfSeason.add(yearMonth);
            }

            seasons.put(season,yearAndMonthOfSeason);
        }

        Queue<String> queue = new ArrayDeque<>();

        for (Map.Entry<String, List<String>> entry : seasons.entrySet()) {
            for (String s: entry.getValue()){
                String url = "http://nba.win007.com/jsData/matchResult/" + entry.getKey() + "/l1_1_" + s + ".js";
                queue.add(url);
            }
        }

        return queue;

    }
}
