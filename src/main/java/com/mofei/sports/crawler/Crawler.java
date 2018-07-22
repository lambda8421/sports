package com.mofei.sports.crawler;

import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.repository.BasketBallRepository;
import com.mofei.sports.web.service.BasketBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Crawler {

    @Autowired
    public BasketBallService service;

    public  List<BasketballTeam> captureJavascript(String strURL) throws Exception {
        URL url = new URL(strURL);
        try {
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            String[] arrData  = contentBuf.toString().split(";");

            String arrTeam = arrData[1];

            arrTeam = arrTeam.substring(15,arrTeam.length()-1);

            String[] teamsArr = arrTeam.split(",");

            List<List<String>> lists = new ArrayList<>();
            List<String> list = new ArrayList<>();
            for (String s: teamsArr){
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

            List<BasketballTeam> basketballTeams = generateBasketballTeamList(lists);

            service.saveAll(basketballTeams);

//        System.out.println(arrTeam);
//
//
//        System.out.println("captureJavascript()的结果：\n" + contentBuf.toString());

            return basketballTeams;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return null;
        }







    }


    public  List<BasketballTeam> generateBasketballTeamList(List<List<String>> lists){
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
}
