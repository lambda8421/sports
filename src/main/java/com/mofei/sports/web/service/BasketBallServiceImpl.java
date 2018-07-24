package com.mofei.sports.web.service;

import com.mofei.sports.web.base.BasketballLeague;
import com.mofei.sports.web.entity.BasketballTeam;
import com.mofei.sports.web.repository.BasketBallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketBallServiceImpl implements BasketBallService {
    @Autowired
    private BasketBallRepository basketBallRepository;

    @Override
    public List<BasketballTeam> findAll() {
        return basketBallRepository.findAll();
    }

    @Override
    public List<BasketballTeam> findAllByLeague(BasketballLeague league) {
        return basketBallRepository.findAllByLeague(league);
    }

    @Override
    public List<BasketballTeam> saveAll(List<BasketballTeam> basketballTeams) {
        return basketBallRepository.saveAll(basketballTeams);
    }
}
