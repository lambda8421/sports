package com.mofei.sports.web.service.impl;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import com.mofei.sports.web.repository.BasketballMatchOddsRepository;
import com.mofei.sports.web.service.BasketballMatchOddsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<BasketballMatchOdds> findAll(PageRequest pageRequest) {
        Page<BasketballMatchOdds> basketballMatchOdds = basketballMatchOddsRepository.findAll(pageRequest);
        return basketballMatchOdds.getContent();
    }
}
