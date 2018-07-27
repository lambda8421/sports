package com.mofei.sports.web.repository;

import com.mofei.sports.web.entity.BasketballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketballMatchRepository extends JpaRepository<BasketballMatch,Long>{

    public List<BasketballMatch> findAllBySeasonAndMonth(int season, int month);

    @Override
    <S extends BasketballMatch> List<S> saveAll(Iterable<S> entities);
}
