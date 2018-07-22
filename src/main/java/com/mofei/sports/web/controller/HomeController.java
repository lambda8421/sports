package com.mofei.sports.web.controller;

import com.mofei.sports.crawler.Crawler;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.service.BasketBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BasketBallService basketBallService;

    @ResponseBody
    @GetMapping("/basketball/team")
    public List<BasketballTeam> getBasketballTeam(){
        return basketBallService.findAll();
    }

    @ResponseBody
    @GetMapping("/index")
    public List<BasketballTeam> index(){
        try {
            return basketBallService.saveAll(
                    new Crawler().captureJavascript("http://nba.win007.com/jsData/matchResult/17-18/l1_1_2017_10.js?version=2018072222"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
