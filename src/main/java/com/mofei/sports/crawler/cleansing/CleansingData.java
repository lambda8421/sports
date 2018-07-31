package com.mofei.sports.crawler.cleansing;

import com.mofei.sports.web.base.BasketballMatchType;
import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballTeam;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CleansingData {

    //get basketball team data
    public static  List<BasketballTeam> getBasketballTeams(String crawlerData) {

        String[] arrData =  crawlerData.split(";");

        String arrTeam = arrData[1];

        arrTeam = arrTeam.substring(15,arrTeam.length()-1);

        String[] teamsArr = arrTeam.split(",");

        List<List<String>> lists = cleanData(teamsArr);

        List<BasketballTeam> basketballTeams = generateBasketballTeamList(lists);


        return basketballTeams;
    }

    private static List<List<String>> cleanData(String[] arr){
        List<List<String>> lists = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (String s: arr){
            if (s.startsWith("[")){
                list = new ArrayList<>();
                list.add(s.substring(1));
                continue;
            }

            if (s.endsWith("]")){
                list.add(s.substring(0,s.length()-2));
                lists.add(list);
                continue;
            }

            list.add(s);
        }
        return lists;
    }

    private static List<BasketballTeam> generateBasketballTeamList(List<List<String>> lists){
        List<BasketballTeam> basketballTeams = new ArrayList<>();
        for (List<String> ss : lists){
            BasketballTeam basketballTeam = new BasketballTeam();
            basketballTeam.setTeamNumber(Integer.valueOf(ss.get(0)));
            basketballTeam.setNameZH(ss.get(1).replace("'",""));
            basketballTeam.setNameZHHK(ss.get(2));
            basketballTeam.setNameEN(ss.get(3));
            basketballTeam.setShortNameZH(ss.get(4));
            basketballTeam.setShortNameZHHK(ss.get(5));
            basketballTeam.setShortNameEN(ss.get(6));
            basketballTeams.add(basketballTeam);
        }
        return basketballTeams;
    }

    private static List<BasketballMatch> generateBasketballMatchesList(List<List<String>> lists){
        List<BasketballMatch> BasketballMatches = new ArrayList<>();
        for (List<String> list : lists){
            BasketballMatch basketballMatch = new BasketballMatch();



            basketballMatch.setThirdId(Integer.valueOf(list.get(0)));
            basketballMatch.setMatchType(BasketballMatchType.of(Integer.valueOf(list.get(1))));
            String date = list.get(2).replace("'","");
            basketballMatch.setSeason(Integer.valueOf(date.substring(0,4)));
            basketballMatch.setSeason(Integer.valueOf(date.substring(5,7)));
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            try {
                basketballMatch.setMatchDate(formatter.parse(date));
            }catch (Exception e){
                basketballMatch.setMatchDate(new Date());
                System.out.println(e.getStackTrace());
            }
            basketballMatch.setHostTeamId(Integer.valueOf(list.get(3)));
            basketballMatch.setGuestTeamId(Integer.valueOf(list.get(4)));
            basketballMatch.setHostTeamScore(Integer.valueOf(list.get(5)));
            basketballMatch.setGuestTeamScore(Integer.valueOf(list.get(6)));
            basketballMatch.setHostTeamHalfScore(Integer.valueOf(list.get(7)));
            basketballMatch.setGuestTeamHalfScore(Integer.valueOf(list.get(8)));
            basketballMatch.setHandicapScore(Float.valueOf(list.get(10)));
            basketballMatch.setPredictTotalScore(Float.valueOf(list.get(11)));
            BasketballMatches.add(basketballMatch);
        }
        return BasketballMatches;
    }

    // getBasketballMatches
    public static List<BasketballMatch> getBasketballMatches(String crawlerData){

        /*
        [ [289789,1,'2017-10-18 10:30',27,21,121,122,71,62,-1,9.5,231,1,1],
            [289789,1,'2017-10-18 10:30',27,21,121,122,71,62,-1,9.5,231,1,1]
        ]
         */

        String[] arrData =  crawlerData.split(";");
        String arrTeam = arrData[4];

        int firstIndex = arrTeam.indexOf('[');
        int lastIndex = arrTeam.lastIndexOf(']');

        arrTeam = arrTeam.substring(firstIndex+2,lastIndex-1);

        String splitStr = "],\\[";
        String[] matchesArr = arrTeam.split(splitStr);

        List<List<String>> lists = new ArrayList<>();
        for (String match: matchesArr){
            String[] strings1 = match.split(",");
            lists.add(Arrays.asList(strings1));
        }

        List<BasketballMatch> BasketballMatches = generateBasketballMatchesList(lists);

        return  BasketballMatches;
    }
}
