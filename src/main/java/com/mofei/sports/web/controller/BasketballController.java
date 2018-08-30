package com.mofei.sports.web.controller;

import com.mofei.sports.web.base.BasketballLeague;
import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.entity.OddsCompany;
import com.mofei.sports.web.repository.OddsCompanyRepository;
import com.mofei.sports.web.service.BasketBallService;
import com.mofei.sports.web.service.BasketballMatchOddsService;
import com.mofei.sports.web.service.BasketballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class BasketballController {

    @Autowired
    private BasketBallService basketBallService;

    @Autowired
    private BasketballMatchService basketballMatchService;

    @Autowired
    private BasketballMatchOddsService basketballMatchOddsService;

    @Autowired
    private OddsCompanyRepository oddsCompanyRepository;

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

    @GetMapping(value = "/nba/match/odds/{page}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OddsCompany getNBAMatchOddsByPage(@PathVariable Integer page){
        PageRequest pageRequest = new PageRequest(page,10);
        List<BasketballMatchOdds> basketballMatchOdds = basketballMatchOddsService.findAll(pageRequest);
        OddsCompany oddsCompany = basketballMatchOdds.get(0).getList().get(0);
        return oddsCompany;
    }

    @GetMapping(value = "/nba/odds/company/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public OddsCompany getNBAMatchOddsByPage(@PathVariable Long id){

        Optional<OddsCompany> oddsCompany= oddsCompanyRepository.findById(id);
        return oddsCompany.get();
    }
}
