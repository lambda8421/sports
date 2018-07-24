package com.mofei.sports.crawler;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballTeam;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Crawler crawler = new Crawler();

        try {
            crawler.init("http://nba.win007.com/jsData/matchResult/17-18/l1_1_2017_10.js?version=2018072503");
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }

        List<BasketballTeam> basketballTeams =  crawler.getBasketballTeams();
        List<BasketballMatch> getBasketballMatches =  crawler.getBasketballMatches();

        System.out.println("xx");
    }
}
