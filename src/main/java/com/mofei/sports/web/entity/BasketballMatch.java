package com.mofei.sports.web.entity;

import com.mofei.sports.web.base.BasketballMatchType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BasketballMatch {

    @Id
    @GeneratedValue
    private Long id;

    private int thirdId;

    private BasketballMatchType matchType;

    private int  hostTeamId;

    private int hostTeamScore;

    private int hostTeamHalfScore;

    private int  guestTeamId;

    private int guestTeamScore;
    private int guestTeamHalfScore;

    private float handicapScore;

    private float predictTotalScore;

    private int season;

    private int month;

    private Date matchDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getThirdId() {
        return thirdId;
    }

    public void setThirdId(int thirdId) {
        this.thirdId = thirdId;
    }

    public BasketballMatchType getMatchType() {
        return matchType;
    }

    public void setMatchType(BasketballMatchType matchType) {
        this.matchType = matchType;
    }

    public int getHostTeamId() {
        return hostTeamId;
    }

    public void setHostTeamId(int hostTeamId) {
        this.hostTeamId = hostTeamId;
    }

    public int getHostTeamScore() {
        return hostTeamScore;
    }

    public void setHostTeamScore(int hostTeamScore) {
        this.hostTeamScore = hostTeamScore;
    }

    public int getHostTeamHalfScore() {
        return hostTeamHalfScore;
    }

    public void setHostTeamHalfScore(int hostTeamHalfScore) {
        this.hostTeamHalfScore = hostTeamHalfScore;
    }

    public int getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(int guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    public int getGuestTeamScore() {
        return guestTeamScore;
    }

    public void setGuestTeamScore(int guestTeamScore) {
        this.guestTeamScore = guestTeamScore;
    }

    public int getGuestTeamHalfScore() {
        return guestTeamHalfScore;
    }

    public void setGuestTeamHalfScore(int guestTeamHalfScore) {
        this.guestTeamHalfScore = guestTeamHalfScore;
    }

    public float getHandicapScore() {
        return handicapScore;
    }

    public void setHandicapScore(float handicapScore) {
        this.handicapScore = handicapScore;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public float getPredictTotalScore() {
        return predictTotalScore;
    }

    public void setPredictTotalScore(float predictTotalScore) {
        this.predictTotalScore = predictTotalScore;
    }
}
