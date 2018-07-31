package com.mofei.sports.web.entity;

import com.mofei.sports.web.entity.odds.OddsCompany;

import javax.persistence.*;
import java.util.List;

@Entity
public class BasketballMatchOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long matchId;

    @OneToMany
    private List<OddsCompany> list;
}

