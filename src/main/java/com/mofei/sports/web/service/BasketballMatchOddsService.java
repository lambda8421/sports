package com.mofei.sports.web.service;

import com.mofei.sports.web.entity.BasketballMatchOdds;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface BasketballMatchOddsService {

    public BasketballMatchOdds save(BasketballMatchOdds basketballMatchOdds);

    public List<BasketballMatchOdds> saveAll(List<BasketballMatchOdds> basketballMatchOddsList);

    public List<BasketballMatchOdds> findAll(PageRequest pageRequest);
}
