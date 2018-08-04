package com.mofei.sports.crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String s = "http://nba.win007.com/jsData/analyOdds/289788.js?1532707729000";
        String regex = "\\d+.js";

        Pattern pattern = Pattern.compile(regex);
        List<String> list = new ArrayList<String>();
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            list.add(m.group());
        }
        System.out.println(list.toString());
    }
}
