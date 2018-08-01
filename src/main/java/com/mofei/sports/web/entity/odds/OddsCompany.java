package com.mofei.sports.web.entity.odds;

import com.mofei.sports.web.entity.BasketballMatchOdds;

import javax.persistence.*;

@Entity
public class OddsCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private float oddsValue;

    @ManyToOne
    private BasketballMatchOdds basketballMatchOdds;
}
