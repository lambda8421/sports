package com.mofei.sports.web.entity.odds;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OddsCompany implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long companyId;

    protected String name;

    private float initialHandicapScore;

    private float initialHostHandicapScoreOdds;

    private float initialGuestHandicapScoreOdds;

    private float instantHandicapScore;

    private float instantHostHandicapScoreOdds;

    private float instantGuestHandicapScoreOdds;

    private float initialTotalScore;

    private float initialHostTotalScoreOdds;

    private float initialGuestTotalScoreOdds;

    private float instantTotalScore;

    private float instantHostTotalScoreOdds;

    private float instantGuestTotalScoreOdds;

    public OddsCompany() {
    }

    public OddsCompany(Long companyId, String name,
                       float initialHandicapScore,
                       float initialHostHandicapScoreOdds, float initialGuestHandicapScoreOdds,
                       float instantHandicapScore, float instantHostHandicapScoreOdds,
                       float instantGuestHandicapScoreOdds, float initialTotalScore,
                       float initialHostTotalScoreOdds, float initialGuestTotalScoreOdds,
                       float instantTotalScore, float instantHostTotalScoreOdds,
                       float instantGuestTotalScoreOdds) {
        this.companyId = companyId;
        this.name = name;

        this.initialHostHandicapScoreOdds = initialHostHandicapScoreOdds;
        this.initialHandicapScore = initialHandicapScore;
        this.initialGuestHandicapScoreOdds = initialGuestHandicapScoreOdds;


        this.instantHostHandicapScoreOdds = instantHostHandicapScoreOdds;
        this.instantHandicapScore = instantHandicapScore;
        this.instantGuestHandicapScoreOdds = instantGuestHandicapScoreOdds;


        this.initialHostTotalScoreOdds = initialHostTotalScoreOdds;
        this.initialTotalScore = initialTotalScore;
        this.initialGuestTotalScoreOdds = initialGuestTotalScoreOdds;


        this.instantHostTotalScoreOdds = instantHostTotalScoreOdds;
        this.instantTotalScore = instantTotalScore;
        this.instantGuestTotalScoreOdds = instantGuestTotalScoreOdds;
    }
}
