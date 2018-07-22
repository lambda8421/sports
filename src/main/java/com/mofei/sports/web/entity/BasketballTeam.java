package com.mofei.sports.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BasketballTeam {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private int teamNumber;

    public enum League{
        NBA,CBA,
    }

    private String nameZH;

    private String nameZHHK;

    private String shortNameZH;

    private String shortNameZHHK;

    private String nameEN;

    private String shortNameEN;


    public BasketballTeam() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(int teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getNameZH() {
        return nameZH;
    }

    public void setNameZH(String nameZH) {
        this.nameZH = nameZH;
    }

    public String getNameZHHK() {
        return nameZHHK;
    }

    public void setNameZHHK(String nameZHHK) {
        this.nameZHHK = nameZHHK;
    }

    public String getShortNameZH() {
        return shortNameZH;
    }

    public void setShortNameZH(String shortNameZH) {
        this.shortNameZH = shortNameZH;
    }

    public String getShortNameZHHK() {
        return shortNameZHHK;
    }

    public void setShortNameZHHK(String shortNameZHHK) {
        this.shortNameZHHK = shortNameZHHK;
    }

    public String getNameEN() {
        return nameEN;
    }

    public void setNameEN(String nameEN) {
        this.nameEN = nameEN;
    }

    public String getShortNameEN() {
        return shortNameEN;
    }

    public void setShortNameEN(String shortNameEN) {
        this.shortNameEN = shortNameEN;
    }
}
