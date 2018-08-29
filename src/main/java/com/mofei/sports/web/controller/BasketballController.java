package com.mofei.sports.web.controller;

import com.mofei.sports.web.base.BasketballLeague;
import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.service.BasketBallService;
import com.mofei.sports.web.service.BasketballMatchOddsService;
import com.mofei.sports.web.service.BasketballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BasketballController {

    @Autowired
    private BasketBallService basketBallService;

    @Autowired
    private BasketballMatchService basketballMatchService;

    @Autowired
    private BasketballMatchOddsService basketballMatchOddsService;

    @GetMapping("/nba/teams")
    @ResponseBody
    public List<BasketballTeam> getNBATeams(){
        List<BasketballTeam> basketballTeams = basketBallService.findAllByLeague(BasketballLeague.NBA);
        return basketballTeams;
    }

    @GetMapping("/nba/teams/matches/{season}/{month}")
    @ResponseBody
    public List<BasketballMatch> getNBATeamsMatches(@PathVariable Integer season, @PathVariable Integer month){
        List<BasketballMatch> basketballMatches = basketballMatchService.findBySeasonAndMonth(season,month);
        return basketballMatches;
    }

    @GetMapping("/nba/matches/{page}")
    @ResponseBody
    public List<BasketballMatch> getNBAMatchesByPage(@PathVariable Integer page){
        PageRequest pageRequest = new PageRequest(page,10);
        List<BasketballMatch> basketballMatches = basketballMatchService.findAll(pageRequest);
        return basketballMatches;
    }

    @GetMapping("/nba/match/odds/{page}")
    @ResponseBody
    public BasketballMatchOdds getNBAMatchOddsByPage(@PathVariable Integer page){
        PageRequest pageRequest = new PageRequest(page,10);
        List<BasketballMatchOdds> basketballMatchOdds = basketballMatchOddsService.findAll(pageRequest);
        return basketballMatchOdds.get(0);
    }
}
