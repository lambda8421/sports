package com.mofei.sports;

import com.mofei.sports.crawler.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {
    @Autowired
    private Crawler crawler;

    @Override
    public void run(String...args) throws Exception {
        crawler.init("http://nba.win007.com/jsData/matchResult/17-18/l1_1_2017_10.js?version=2018072503)");
        crawler.save();
    }
}
