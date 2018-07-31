package com.mofei.sports.crawler;

import com.mofei.sports.web.base.BasketballMatchType;
import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.repository.BasketBallRepository;
import com.mofei.sports.web.service.BasketBallService;
import com.mofei.sports.web.service.BasketballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class Crawler {
    @Autowired
    protected BasketballMatchService basketballMatchService;

    private String crawlerData;

    public String getCrawlerData() {
        return crawlerData;
    }

    public void setCrawlerData(String crawlerData) {
        this.crawlerData = crawlerData;
    }

    public void init(String strURL){
        Test test = new Test();
        try {
            URL url = new URL(strURL);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            InputStreamReader input = new InputStreamReader(httpConn.getInputStream(), "utf-8");
            BufferedReader bufReader = new BufferedReader(input);
            String line = "";
            StringBuilder contentBuf = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                contentBuf.append(line);
            }
            crawlerData = contentBuf.toString();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }











}
