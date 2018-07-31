package com.mofei.sports.web.repository;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketballMatchOddsRepository extends JpaRepository<BasketballMatchOdds,Long> {
    @Override
    <S extends BasketballMatchOdds> S save(S s);

    @Override
    <S extends BasketballMatchOdds> List<S> saveAll(Iterable<S> iterable);
}
