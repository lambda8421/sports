package com.mofei.sports.crawler.cleansing;

import com.mofei.sports.web.base.BasketballMatchType;
import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.entity.odds.OddsCompany;

import java.text.SimpleDateFormat;
import java.util.*;

public class CleansingData {

    public static BasketballMatchOdds getBasketballMatchOdds(String crawlerData,Long matchId) {

        String tidyData;
        if (crawlerData.length() > 28){
            tidyData = crawlerData.substring(15, crawlerData.length() - 13);
        }else {
            System.out.println(crawlerData);
            System.out.println(matchId);
            return null;
        }


        String[] oddsData = tidyData.split("\\^");

        List<List<String>> lists = new ArrayList<>();
        for (String odds : oddsData) {
            String[] tmp = odds.split(";");
            List<String> oddsList = new ArrayList<>();
            oddsList.add(tmp[0]);
            oddsList.add(tmp[1]);
            Collections.addAll(oddsList, tmp[2].split(","));
            lists.add(oddsList);
        }

        BasketballMatchOdds basketballMatchOdds = generateBasketballMatchesOdds(lists,matchId);


        return basketballMatchOdds;
    }

    private static List<BasketballMatchOdds> generateBasketballMatchesOddsList(List<List<String>> lists) {
        return null;
    }

    private static BasketballMatchOdds generateBasketballMatchesOdds(List<List<String>> lists,Long matchId) {
        BasketballMatchOdds odds = new BasketballMatchOdds();
        odds.setMatchId(matchId);
        List<OddsCompany> oddsCompanies = new ArrayList<>();
        for (List<String> ss : lists) {
            OddsCompany oddsCompany = new OddsCompany(
                    Long.valueOf(ss.get(0)),
                    ss.get(1),
                    ss.size() > 2 ? (ss.get(2).equals("") ? 0 : Float.valueOf(ss.get(2))):0,
                    ss.size() > 3 ? (ss.get(3).equals("") ? 0 :Float.valueOf(ss.get(3))):0,
                    ss.size() > 4 ? (ss.get(4).equals("") ? 0 :Float.valueOf(ss.get(4))):0,
                    ss.size() > 5 ? (ss.get(5).equals("") ? 0 :Float.valueOf(ss.get(5))):0,
                    ss.size() > 6 ? (ss.get(6).equals("") ? 0 :Float.valueOf(ss.get(6))):0,
                    ss.size() > 7 ? (ss.get(7).equals("") ? 0 :Float.valueOf(ss.get(7))):0,
                    ss.size() > 8 ? ( ss.get(8).equals("") ? 0 : Float.valueOf(ss.get(8))):0,
                    ss.size() > 9 ? ( ss.get(9).equals("") ? 0 :Float.valueOf(ss.get(9))):0,
                    ss.size() > 10 ? ( ss.get(10).equals("") ? 0 :Float.valueOf(ss.get(10))):0,
                    ss.size() > 11 ? ( ss.get(11).equals("") ? 0 :Float.valueOf(ss.get(11))):0,
                    ss.size() > 12 ? ( ss.get(12).equals("") ? 0 :Float.valueOf(ss.get(12))):0,
                    ss.size() > 13 ? ( ss.get(13).equals("") ? 0 :Float.valueOf(ss.get(13))):0);
            oddsCompanies.add(oddsCompany);
        }
        odds.setList(oddsCompanies);

        return odds;
    }

    //get basketball team data
    public static List<BasketballTeam> getBasketballTeams(String crawlerData) {

        String[] arrData = crawlerData.split(";");

        if (arrData.length < 2){
            return null;
        }
        String arrTeam = arrData[1];

        arrTeam = arrTeam.substring(15, arrTeam.length() - 1);

        String[] teamsArr = arrTeam.split(",");

        List<List<String>> lists = cleanData(teamsArr);

        List<BasketballTeam> basketballTeams = generateBasketballTeamList(lists);


        return basketballTeams;
    }

    private static List<List<String>> cleanData(String[] arr) {
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (s.startsWith("[")) {
                list = new ArrayList<>();
                list.add(s.substring(1));
                continue;
            }

            if (s.endsWith("]")) {
                list.add(s.substring(0, s.length() - 2));
                lists.add(list);
                continue;
            }

            list.add(s);
        }
        return lists;
    }

    private static List<BasketballTeam> generateBasketballTeamList(List<List<String>> lists) {
        List<BasketballTeam> basketballTeams = new ArrayList<>();
        for (List<String> ss : lists) {
            BasketballTeam basketballTeam = new BasketballTeam();
            basketballTeam.setTeamNumber(Integer.valueOf(ss.get(0)));
            basketballTeam.setNameZH(ss.get(1).replace("'", ""));
            basketballTeam.setNameZHHK(ss.get(2));
            basketballTeam.setNameEN(ss.get(3));
            basketballTeam.setShortNameZH(ss.get(4));
            basketballTeam.setShortNameZHHK(ss.get(5));
            basketballTeam.setShortNameEN(ss.get(6));
            basketballTeams.add(basketballTeam);
        }
        return basketballTeams;
    }

    private static List<BasketballMatch> generateBasketballMatchesList(List<List<String>> lists) {
        List<BasketballMatch> BasketballMatches = new ArrayList<>();
        for (List<String> list : lists) {

//            try {
//                Float.valueOf(list.get(10));
//            }catch (Exception e){
//                System.out.println(list.toString());
//            }

            if (list.size() > 11){
                BasketballMatch basketballMatch = new BasketballMatch();
                basketballMatch.setMatchId(Long.valueOf(list.get(0)));
                basketballMatch.setMatchType(BasketballMatchType.of(Integer.valueOf(list.get(1))));
                String date = list.get(2).replace("'", "");
                basketballMatch.setSeason(Integer.valueOf(date.substring(0, 4)));
                basketballMatch.setSeason(Integer.valueOf(date.substring(5, 7)));
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try {
                    basketballMatch.setMatchDate(formatter.parse(date));
                } catch (Exception e) {
                    basketballMatch.setMatchDate(new Date());
                    System.out.println(e.getStackTrace());
                }
                basketballMatch.setHostTeamId(Integer.valueOf(list.get(3)));
                basketballMatch.setGuestTeamId(Integer.valueOf(list.get(4)));
                basketballMatch.setHostTeamScore(list.get(5).equals("") ?  0 : Integer.valueOf(list.get(5)) );
                basketballMatch.setGuestTeamScore(list.get(6).equals("") ?  0 :Integer.valueOf(list.get(6)));
                basketballMatch.setHostTeamHalfScore(list.get(7).equals("") || list.get(7).equals("''") ?  0 : Integer.valueOf(list.get(7)));
                basketballMatch.setGuestTeamHalfScore(list.get(8).equals("") || list.get(8).equals("''")?  0 : Integer.valueOf(list.get(8)));
                basketballMatch.setHandicapScore(list.get(10).equals("") ? 0: Float.valueOf(list.get(10)));
                basketballMatch.setPredictTotalScore(list.get(11).equals("") ? 0: Float.valueOf(list.get(11)));
                BasketballMatches.add(basketballMatch);
            }
        }
        return BasketballMatches;
    }

    // getBasketballMatches
    public static List<BasketballMatch> getBasketballMatches(String crawlerData) {

        /*
        [ [289789,1,'2017-10-18 10:30',27,21,121,122,71,62,-1,9.5,231,1,1],
            [289789,1,'2017-10-18 10:30',27,21,121,122,71,62,-1,9.5,231,1,1]
        ]
         */

        String[] arrData = crawlerData.split(";");
        String arrTeam = null;
        if (arrData.length > 4){
            arrTeam = arrData[4];
        }else {
            return null;
        }

        int firstIndex = arrTeam.indexOf('[');
        int lastIndex = arrTeam.lastIndexOf(']');

        arrTeam = arrTeam.substring(firstIndex + 2, lastIndex - 1);

        String splitStr = "],\\[";
        String[] matchesArr = arrTeam.split(splitStr);

        List<List<String>> lists = new ArrayList<>();
        for (String match : matchesArr) {
            String[] strings1 = match.split(",");
            lists.add(Arrays.asList(strings1));
        }

        List<BasketballMatch> BasketballMatches = generateBasketballMatchesList(lists);

        return BasketballMatches;
    }
}
