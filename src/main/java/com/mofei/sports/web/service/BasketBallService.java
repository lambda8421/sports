package com.mofei.sports.web.service;


import com.mofei.sports.web.entity.BasketballTeam;

import java.util.List;

public interface BasketBallService {
    public List<BasketballTeam> findAll();

    public List<BasketballTeam> saveAll(List<BasketballTeam> basketballTeams);
}
