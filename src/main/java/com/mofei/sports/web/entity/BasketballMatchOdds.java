package com.mofei.sports.web.entity;

import com.mofei.sports.web.entity.odds.OddsCompany;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BasketballMatchOdds implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "match_id")
    private Long matchId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "match_id",referencedColumnName = "match_id")
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

