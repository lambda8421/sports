package com.mofei.sports.web.entity.odds;

import com.mofei.sports.web.entity.BasketballMatchOdds;

import javax.persistence.*;

@Entity
public class OddsCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public OddsCompany(String name, float initialHandicapScore, float initialHostHandicapScoreOdds, float initialGuestHandicapScoreOdds, float instantHandicapScore, float instantHostHandicapScoreOdds, float instantGuestHandicapScoreOdds, float initialTotalScore, float initialHostTotalScoreOdds, float initialGuestTotalScoreOdds, float instantTotalScore, float instantHostTotalScoreOdds, float instantGuestTotalScoreOdds) {
        this.name = name;
        this.initialHandicapScore = initialHandicapScore;
        this.initialHostHandicapScoreOdds = initialHostHandicapScoreOdds;
        this.initialGuestHandicapScoreOdds = initialGuestHandicapScoreOdds;
        this.instantHandicapScore = instantHandicapScore;
        this.instantHostHandicapScoreOdds = instantHostHandicapScoreOdds;
        this.instantGuestHandicapScoreOdds = instantGuestHandicapScoreOdds;
        this.initialTotalScore = initialTotalScore;
        this.initialHostTotalScoreOdds = initialHostTotalScoreOdds;
        this.initialGuestTotalScoreOdds = initialGuestTotalScoreOdds;
        this.instantTotalScore = instantTotalScore;
        this.instantHostTotalScoreOdds = instantHostTotalScoreOdds;
        this.instantGuestTotalScoreOdds = instantGuestTotalScoreOdds;
    }
}
