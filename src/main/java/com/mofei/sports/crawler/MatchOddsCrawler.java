package com.mofei.sports.crawler;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MatchOddsCrawler extends Crawler {
    private Long matchId;
    @Override
    public void init(String strURL) {
        super.init(strURL);
        this.matchId = Long.valueOf(findMatchIdFromUrl(strURL));
    }

    public Long getMatchId() {
        return matchId;
    }

    private String findMatchIdFromUrl(String url){
        String s = "http://nba.win007.com/jsData/analyOdds/289788.js?1532707729000";
        String regex = "\\d+.js";

        Pattern pattern = Pattern.compile(regex);
        List<String> list = new ArrayList<String>();
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            String str = m.group();
            return str.substring(0,str.length()-3);
        }
        return null;
    }
}
