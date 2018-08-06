package com.mofei.sports.web.service;

import com.mofei.sports.web.entity.BasketballMatch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.List;

public interface BasketballMatchService {

    public List<BasketballMatch> findBySeasonAndMonth(int season, int month);

    public List<BasketballMatch> saveAll(List<BasketballMatch> matches);

    public List<BasketballMatch> findAll(PageRequest pageRequest);

}
