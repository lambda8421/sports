package com.mofei.sports.web.service.impl;

import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.repository.BasketballMatchOddsRepository;
import com.mofei.sports.web.service.BasketballMatchOddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketballMatchOddsServiceImpl implements BasketballMatchOddsService {
    @Autowired
    private BasketballMatchOddsRepository basketballMatchOddsRepository;

    @Override
    public BasketballMatchOdds save(BasketballMatchOdds basketballMatchOdds) {
        return basketballMatchOddsRepository.save(basketballMatchOdds);
    }

    @Override
    public List<BasketballMatchOdds> saveAll(List<BasketballMatchOdds> basketballMatchOddsList) {
        return basketballMatchOddsRepository.saveAll(basketballMatchOddsList);
    }
}
