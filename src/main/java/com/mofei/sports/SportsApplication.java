package com.mofei.sports;

import com.mofei.sports.crawler.Crawler;
import com.mofei.sports.web.entity.BasketballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.util.List;

@EnableScheduling
@SpringBootApplication
public class SportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
	}

	//call CrawlerRunner
}
