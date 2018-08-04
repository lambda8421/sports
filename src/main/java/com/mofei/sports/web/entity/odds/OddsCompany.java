package com.mofei.sports.web.entity.odds;

import com.mofei.sports.web.entity.BasketballMatch;
import com.mofei.sports.web.entity.BasketballMatchOdds;

import javax.persistence.*;

@Entity
public class OddsCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private BasketballMatchOdds basketballMatchOdds;

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


    public BasketballMatchOdds getBasketballMatchOdds() {
        return basketballMatchOdds;
    }

    public void setBasketballMatchOdds(BasketballMatchOdds basketballMatchOdds) {
        this.basketballMatchOdds = basketballMatchOdds;
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
