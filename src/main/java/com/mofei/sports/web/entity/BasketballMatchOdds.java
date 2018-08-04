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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "basketballMatchOdds")
    private List<OddsCompany> list;

    public BasketballMatchOdds() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public List<OddsCompany> getList() {
        return list;
    }

    public void setList(List<OddsCompany> list) {
        this.list = list;
    }

    public void addList(OddsCompany oddsCompany){
        this.list.add(oddsCompany);
    }
}

