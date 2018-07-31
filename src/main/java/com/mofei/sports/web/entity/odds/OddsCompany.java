package com.mofei.sports.web.entity.odds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class OddsCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
}
