package com.mofei.sports.crawler.cleansing;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.service.BasketBallService;
import com.mofei.sports.web.service.BasketballMatchOddsService;
import com.mofei.sports.web.service.BasketballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveDataService {
    @Autowired
    BasketBallService basketBallService;

    @Autowired
    BasketballMatchService basketballMatchService;

    @Autowired
    BasketballMatchOddsService basketballMatchOddsService;



    public void saveBasketballMatches(List<BasketballMatch> basketballMatchList){
        basketballMatchService.saveAll(basketballMatchList);
    }

    public void saveBasketballTeams(List<BasketballTeam> basketballTeams){
        basketBallService.saveAll(basketballTeams);
    }

    public void saveAllBasketballMatchOdds(List<BasketballMatchOdds> basketballMatchOdds){
        basketballMatchOddsService.saveAll(basketballMatchOdds);
    }
    public void saveBasketballMatchOdds(BasketballMatchOdds basketballMatchOdds){
        basketballMatchOddsService.save(basketballMatchOdds);
    }
}
