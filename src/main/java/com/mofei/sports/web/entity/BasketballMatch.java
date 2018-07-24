package com.mofei.sports.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BasketballMatch {

    @Id
    @GeneratedValue
    private Long id;

    private Long hostTeamId;

    private int hostTeamScore;

    private Long guestTeamId;

    private int guestTeamScore;

    private float handicapScore;

    private int season;

    private int month;

    private Date matchDate;


}
