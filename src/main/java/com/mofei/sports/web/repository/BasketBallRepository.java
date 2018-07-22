package com.mofei.sports.web.repository;

import com.mofei.sports.web.entity.BasketballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketBallRepository extends JpaRepository<BasketballTeam,Long> {

    @Override
    public List<BasketballTeam> findAll();

    @Override
    <S extends BasketballTeam> S save(S entity);

    @Override
    <S extends BasketballTeam> List<S> saveAll(Iterable<S> entities);
}
