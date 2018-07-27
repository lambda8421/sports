package com.mofei.sports;

import com.mofei.sports.crawler.Crawler;
import com.mofei.sports.web.entity.BasketballTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SportsApplication {

    @Autowired
    private static Crawler crawler;

	public static void main(String[] args) {
		SpringApplication.run(SportsApplication.class, args);
	}
}
