package com.mofei.sports.web.service;

import com.mofei.sports.web.entity.BasketballMatch;

import java.util.List;

public interface BasketballMatchService {

    public List<BasketballMatch> findBySeasonAndMonth(int season, int month);

    public List<BasketballMatch> saveAll(List<BasketballMatch> matches);
}
