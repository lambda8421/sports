package com.mofei.sports.web.base;

public enum BasketballLeague {
    NBA(1),
    CBA(2);


    private int value;

    BasketballLeague(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
