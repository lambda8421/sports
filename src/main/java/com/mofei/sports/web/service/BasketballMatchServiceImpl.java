package com.mofei.sports.web.service;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.repository.BasketballMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketballMatchServiceImpl implements BasketballMatchService{

    @Autowired
    private BasketballMatchRepository basketballMatchRepository;
    @Override
    public List<BasketballMatch> findBySeasonAndMonth(int season, int month) {
        return basketballMatchRepository.findAllBySeasonAndMonth(
                season,month
        );
    }
}
