package com.mofei.sports.web.entity;

import com.mofei.sports.web.entity.odds.OddsCompany;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class BasketballMatchOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;

    @OneToMany( mappedBy = "basketballMatchOdds")
    private List<OddsCompany> list;
}

