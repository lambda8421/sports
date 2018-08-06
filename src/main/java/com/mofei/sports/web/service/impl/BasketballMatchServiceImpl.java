package com.mofei.sports.web.service.impl;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.repository.BasketballMatchRepository;
import com.mofei.sports.web.service.BasketballMatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class BasketballMatchServiceImpl implements BasketballMatchService {

    @Autowired
    private BasketballMatchRepository basketballMatchRepository;
    @Override
    public List<BasketballMatch> findBySeasonAndMonth(int season, int month) {
        return basketballMatchRepository.findAllBySeasonAndMonth(
                season,month
        );
    }

    @Override
    public List<BasketballMatch> saveAll(List<BasketballMatch> matches) {
        return basketballMatchRepository.saveAll(matches);
    }

    @Override
    public List<BasketballMatch> findAll(PageRequest pageRequest) {
        Page<BasketballMatch> basketballMatches = basketballMatchRepository.findAll(pageRequest);
        return basketballMatches.getContent();
    }
}
