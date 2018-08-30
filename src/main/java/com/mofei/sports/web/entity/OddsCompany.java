package com.mofei.sports.web.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OddsCompany implements Serializable{
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getInitialHandicapScore() {
        return initialHandicapScore;
    }

    public void setInitialHandicapScore(float initialHandicapScore) {
        this.initialHandicapScore = initialHandicapScore;
    }

    public float getInitialHostHandicapScoreOdds() {
        return initialHostHandicapScoreOdds;
    }

    public void setInitialHostHandicapScoreOdds(float initialHostHandicapScoreOdds) {
        this.initialHostHandicapScoreOdds = initialHostHandicapScoreOdds;
    }

    public float getInitialGuestHandicapScoreOdds() {
        return initialGuestHandicapScoreOdds;
    }

    public void setInitialGuestHandicapScoreOdds(float initialGuestHandicapScoreOdds) {
        this.initialGuestHandicapScoreOdds = initialGuestHandicapScoreOdds;
    }

    public float getInstantHandicapScore() {
        return instantHandicapScore;
    }

    public void setInstantHandicapScore(float instantHandicapScore) {
        this.instantHandicapScore = instantHandicapScore;
    }

    public float getInstantHostHandicapScoreOdds() {
        return instantHostHandicapScoreOdds;
    }

    public void setInstantHostHandicapScoreOdds(float instantHostHandicapScoreOdds) {
        this.instantHostHandicapScoreOdds = instantHostHandicapScoreOdds;
    }

    public float getInstantGuestHandicapScoreOdds() {
        return instantGuestHandicapScoreOdds;
    }

    public void setInstantGuestHandicapScoreOdds(float instantGuestHandicapScoreOdds) {
        this.instantGuestHandicapScoreOdds = instantGuestHandicapScoreOdds;
    }

    public float getInitialTotalScore() {
        return initialTotalScore;
    }

    public void setInitialTotalScore(float initialTotalScore) {
        this.initialTotalScore = initialTotalScore;
    }

    public float getInitialHostTotalScoreOdds() {
        return initialHostTotalScoreOdds;
    }

    public void setInitialHostTotalScoreOdds(float initialHostTotalScoreOdds) {
        this.initialHostTotalScoreOdds = initialHostTotalScoreOdds;
    }

    public float getInitialGuestTotalScoreOdds() {
        return initialGuestTotalScoreOdds;
    }

    public void setInitialGuestTotalScoreOdds(float initialGuestTotalScoreOdds) {
        this.initialGuestTotalScoreOdds = initialGuestTotalScoreOdds;
    }

    public float getInstantTotalScore() {
        return instantTotalScore;
    }

    public void setInstantTotalScore(float instantTotalScore) {
        this.instantTotalScore = instantTotalScore;
    }

    public float getInstantHostTotalScoreOdds() {
        return instantHostTotalScoreOdds;
    }

    public void setInstantHostTotalScoreOdds(float instantHostTotalScoreOdds) {
        this.instantHostTotalScoreOdds = instantHostTotalScoreOdds;
    }

    public float getInstantGuestTotalScoreOdds() {
        return instantGuestTotalScoreOdds;
    }

    public void setInstantGuestTotalScoreOdds(float instantGuestTotalScoreOdds) {
        this.instantGuestTotalScoreOdds = instantGuestTotalScoreOdds;
    }
}
